package com.kimdung.kimdungtronbo;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.kimdung.kimdungtronbo.Rule.CheckMistakeInBackGround;
import com.kimdung.kimdungtronbo.adapters.ReadingAdapter;
import com.kimdung.kimdungtronbo.adapters.ViewPagerReadingAdapter;
import com.kimdung.kimdungtronbo.database.LoadChapterInBackGround;
import com.kimdung.kimdungtronbo.models.Chapter;
import com.kimdung.kimdungtronbo.models.Novel;
import com.kimdung.kimdungtronbo.models.Paragraph;

import java.util.ArrayList;
import java.util.List;

import static com.kimdung.kimdungtronbo.ReadingFragment.mRecyclerViewContent;


public class ReadingActivity extends AppCompatActivity {

    private static final String TAG = "MY_TAG_ReadingActivity";
    public final static String EXTRA_NOVEL = "novel";
    private static final int REQUEST_CODE_SEARCH_VOICE = 1;

    private Novel mNovel;

    private ViewPager mViewPagerReading;
    private TabLayout mTabLayoutReading;
    private ViewPagerReadingAdapter mViewPagerReadingAdapter;
    public static int mCurrentChap = 0;

    private boolean mIsMarked = false;// flag để đánh dáu là đang hiện content đã được marked hay chưa
    private boolean mIsFirstOpenReadingFragment = true;

    private SearchView mSearchView;
    private ImageView mFindPrevious, mFindNext;
    private FrameLayout mFrameLayoutFind;

    public static LoadChapterInBackGround mLoadChapterInBackGround = null;
    public static CheckMistakeInBackGround sMCheckMistakeInBackGround = null;

    private MenuItem mMenuItemCheckMistake = null;
    private int currentParagraphHaveMistake = 0;

    // lấy mViewPagerReadingAdapter của mRecyclerViewContent trong ReadingFragment => không cần phải để public static ReadingAdapter mReadingAdapter;
    // lấy trong listener vì lúc khởi tạo ReadingAcivity thì chưa có Fragment
    private ReadingAdapter mReadingAdapter;
    private SearchTask mSearchTask;

    private List<Paragraph> mOriginparagraph = null;
    private List<Paragraph> mListParagraphMarked = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        setTitle("");
        // lay ra Novel
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                mNovel = (Novel) bundle.getSerializable(EXTRA_NOVEL);
//                setTitle(mNovel.getStName());
            }
        }

        addControls();
        addEvents();

        // do du lieu vao view pager
        mViewPagerReadingAdapter = new ViewPagerReadingAdapter(getSupportFragmentManager(), mNovel, mViewPagerReading);
        mViewPagerReading.setAdapter(mViewPagerReadingAdapter);

        // setup tablayout
        mTabLayoutReading.setupWithViewPager(mViewPagerReading);
    }


    private void addEvents() {
        mViewPagerReading.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mListParagraphMarked = null;
                    mIsMarked = false;
                    mFrameLayoutFind.setVisibility(View.GONE);
                    currentParagraphHaveMistake = 0;
                    if (mMenuItemCheckMistake != null) {
                        mMenuItemCheckMistake.setIcon(R.drawable.e_mistake);
                    }
                } else if (mIsFirstOpenReadingFragment) {
                    // load chapter mCurrentChap = 1 ở lần đầu tiên
                    mReadingAdapter = (ReadingAdapter) mRecyclerViewContent.getAdapter();
                    Chapter chapter = mNovel.getListChapters().get(mCurrentChap);
                    mReadingAdapter.setDataSource(chapter.getListParagraphs());
                    // check mistake từ current chapter -> hết và quay trở lại
                    checkChinhTa();
                    mIsFirstOpenReadingFragment = false;
                } else {
                    //phải xét lại list gốc liên tục, không thì có thể bị nhầm sang paragraph của chapter khác
                    mOriginparagraph = mNovel.getListChapters().get(mCurrentChap).getListParagraphs();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // findNextMistake()
        mFindNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: mFindNext ");
                mOriginparagraph = mNovel.getListChapters().get(mCurrentChap).getListParagraphs();
                Log.d(TAG, "onClick: current chap: " + mCurrentChap);
                if (currentParagraphHaveMistake < 0) {
                    currentParagraphHaveMistake = 0;
                }
                while (currentParagraphHaveMistake >= 0 &&
                        currentParagraphHaveMistake < mOriginparagraph.size() - 1 &&
                        !mOriginparagraph.get(currentParagraphHaveMistake).haveMistake()) {
                    currentParagraphHaveMistake++;
                    Log.d(TAG, "onClick: currentParagraphHaveMistake: " + currentParagraphHaveMistake);
                }
                currentParagraphHaveMistake++;
                if (currentParagraphHaveMistake >= 0 && currentParagraphHaveMistake <= mOriginparagraph.size() - 1)
                    mRecyclerViewContent.scrollToPosition(currentParagraphHaveMistake);
            }
        });
        // findNextMistake()
        mFindPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: mFindPrevious ");
                mOriginparagraph = mNovel.getListChapters().get(mCurrentChap).getListParagraphs();
                if (currentParagraphHaveMistake > mOriginparagraph.size() - 1) {
                    currentParagraphHaveMistake = mOriginparagraph.size() - 1;
                }
                while (currentParagraphHaveMistake > 0 &&
                        currentParagraphHaveMistake <= mOriginparagraph.size() - 1 &&
                        !mOriginparagraph.get(currentParagraphHaveMistake).haveMistake()) {
                    currentParagraphHaveMistake--;
                }
                currentParagraphHaveMistake--;
                if (currentParagraphHaveMistake >= 0 && currentParagraphHaveMistake <= mOriginparagraph.size() - 1)
                    mRecyclerViewContent.scrollToPosition(currentParagraphHaveMistake);
            }
        });
    }

    private void addControls() {
        // lay tham chieu tablayout va view pager
        mViewPagerReading = (ViewPager) findViewById(R.id.view_pager_reading);
        mTabLayoutReading = (TabLayout) findViewById(R.id.tab_layout_reading);

        mFindPrevious = (ImageView) findViewById(R.id.find_previous);
        mFindNext = (ImageView) findViewById(R.id.find_next);
        mFrameLayoutFind = (FrameLayout) findViewById(R.id.frame_layout_find);
    }

    // tao menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reading, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        mSearchView = (SearchView) menuItem.getActionView();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchChapter(query);
                // nếu đang ở fragment reading thì quay lại mục lục
                mViewPagerReading.setCurrentItem(0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText == null || newText.isEmpty()) {
                    // hủy asyntask
                    if (mSearchTask != null)
                        mSearchTask.cancel(true);
                    // bỏ hightlight row listChapter
                    mViewPagerReadingAdapter.getChapterListFragment().getAdapter().resetHighlight();
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_back_chapter:
                backChapter();
                break;
            case R.id.item_menu_next_chapter:
                nextChapter();
                break;
            case R.id.item_menu_voice_search:
                searchVoice();
                break;
            case R.id.item_menu_check_mistake:
                mMenuItemCheckMistake = item;
                changeMistakeButtonIcon(item);
                showFrameLayout();
                changeContentReading();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showFrameLayout() {
        if (mIsMarked) {
            // đang mark và muốn bỏ mark
            mFrameLayoutFind.setVisibility(View.GONE);
        } else {
            // đang không mark và muốn mark
            mFrameLayoutFind.setVisibility(View.VISIBLE);
        }
    }

    private void changeMistakeButtonIcon(MenuItem item) {
        if (mIsMarked) {
            // đang mark và muốn bỏ mark
            item.setIcon(R.drawable.e_mistake);
        } else {
            // đang không mark và muốn mark
            item.setIcon(R.drawable.e_mistake_marked);
        }
    }

    private void changeContentReading() {
        // lấy mViewPagerReadingAdapter của mRecyclerViewContent
        mReadingAdapter = (ReadingAdapter) mRecyclerViewContent.getAdapter();
        mOriginparagraph = mNovel.getListChapters().get(mCurrentChap).getListParagraphs();
//        Log.d(TAG, "changeContentReading: " + mIsMarked);
        if (mIsMarked) {
            // đang mark và muốn bỏ mark
            mReadingAdapter.setDataSource(mOriginparagraph);
            mIsMarked = false;
        } else if (mListParagraphMarked == null) {
            // đang không mark và muốn mark, chưa mark bao giờ
            mListParagraphMarked = markMistake(mReadingAdapter);
            showToastMessage("chapter này có: " + mNovel.getListChapters().get(mCurrentChap).getListMisTake().size() + " lỗi");
            mIsMarked = true;
        } else if (mListParagraphMarked != null) {
            // đang không mark và muốn mark, đã từng mark 1 lần rồi (giá trị đã được lưu lại)
            mReadingAdapter.setDataSource(mListParagraphMarked);
            mIsMarked = true;
            showToastMessage("chapter này có: " + mNovel.getListChapters().get(mCurrentChap).getListMisTake().size() + " lỗi");
        }
    }

    private List<Paragraph> markMistake(ReadingAdapter mReadingAdapter) {
        // return content marked
        List<Paragraph> mListParagraphMarked = mNovel.getListChapters().get(mCurrentChap).getContentMarked();
        mReadingAdapter.setDataSource(mListParagraphMarked);
        return mListParagraphMarked;
    }

    private void checkChinhTa() {
        // nếu check ở đây thì vào asyntask và check toàn bộ các chap
        // => thừa vì người dùng chỉ nhìn đc 1 chap bị đánh dấu
        // nếu check toàn bộ chap thì nên để thêm textView trong itemRowChapter để hiện số lỗi trong chap
        sMCheckMistakeInBackGround = (CheckMistakeInBackGround) new CheckMistakeInBackGround().execute(mNovel);
    }

    private void backChapter() {
        List<Chapter> listChapter = mNovel.getListChapters();
        if (mCurrentChap == 0) {
            showToastMessage("Đand ở chương đầu tiên!");
        } else {
            mCurrentChap--;
            mIsMarked = false;
            mListParagraphMarked = null;
            mFrameLayoutFind.setVisibility(View.GONE);
            currentParagraphHaveMistake = 0;
            if (mMenuItemCheckMistake != null) {
                mMenuItemCheckMistake.setIcon(R.drawable.e_mistake);
            }
            mViewPagerReadingAdapter.getChapterListFragment().getAdapter().updateReadingFragment(listChapter.get(mCurrentChap));
            mOriginparagraph = mNovel.getListChapters().get(mCurrentChap).getListParagraphs();
        }
    }

    private void nextChapter() {
        List<Chapter> listChapter = mNovel.getListChapters();
        if (mCurrentChap == listChapter.size() - 1) {
            showToastMessage("Đã hết chương!");
        } else {
            mCurrentChap++;
            mIsMarked = false;
            mListParagraphMarked = null;
            mFrameLayoutFind.setVisibility(View.GONE);
            currentParagraphHaveMistake = 0;
            if (mMenuItemCheckMistake != null) {
                mMenuItemCheckMistake.setIcon(R.drawable.e_mistake);
            }
            mViewPagerReadingAdapter.getChapterListFragment().getAdapter().updateReadingFragment(listChapter.get(mCurrentChap));
            mOriginparagraph = mNovel.getListChapters().get(mCurrentChap).getListParagraphs();
        }
    }

    @Override
    public void onBackPressed() {
        if (mViewPagerReading.getCurrentItem() == 1) {
            // nếu đang đọc thì về mục lục
            mViewPagerReading.setCurrentItem(0);
            // xem thêm trong trong setOnPageChangeListener của viewpager
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // nếu đang ở mục lục thì xóa hết dữ liệu và quay về main act

        // kill asyntask
        // asyntask.cancel(true); cũng không kill được process asyn đang thực hiện, phải kill thủ công
        if (mLoadChapterInBackGround != null) {
            mLoadChapterInBackGround.cancel(true);
            mLoadChapterInBackGround = null;
        }

        if (sMCheckMistakeInBackGround != null) {
            sMCheckMistakeInBackGround.cancel(true);
            sMCheckMistakeInBackGround = null;
        }
        if (mSearchTask != null) {
            mSearchTask.cancel(true);
        }
    }

    private void searchChapter(String query) {
        mSearchTask = new SearchTask(this, mViewPagerReadingAdapter.getChapterListFragment().getAdapter(), query);
        mSearchTask.execute();
    }

    private void searchVoice() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        // xac nhan ung dung muon gui yeu cau
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());

        // goi y nhung dieu nguoi dung muon noi
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Nói sau tiếng beep!");

        // goi y nhan dang nhung gi nguoi dung se noi
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "vi");
//
        // Xac dinh ban muon bao nhieu ket qua gan dung duoc tra ve
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        startActivityForResult(intent, REQUEST_CODE_SEARCH_VOICE);
    }

    private void showToastMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_SEARCH_VOICE) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                Log.d(TAG, "SOLUONG = " + text.size());
                for (String s : text) {
//                    Log.d(TAG, "element = " + s);
                    mSearchView.setQuery(s, false);
                    mSearchView.setIconified(false);// expand search view
                }
//                Log.d(TAG, "KET THUC");
            }
        } else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
            showToastMessage("Audio Error");
        } else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
            showToastMessage("Client Error");
        } else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
            showToastMessage("Network Error");
        } else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
            showToastMessage("No Match");
        } else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
            showToastMessage("Server Error");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
