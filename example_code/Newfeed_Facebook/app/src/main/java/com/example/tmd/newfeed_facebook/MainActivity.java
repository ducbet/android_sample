package com.example.tmd.newfeed_facebook;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tmd.newfeed_facebook.Messenger_Notification_Setting.LoadingFragment;
import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.FriendSuggest_RecyclerView.ItemFriendSuggest;
import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemLoading;
import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemPostStatus;
import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemStatus;
import com.example.tmd.newfeed_facebook.NewFeed.NewFeedFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemStatus.FRIENDS;
import static com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemStatus.PRIVATE;
import static com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemStatus.PUBLIC;
import static com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemStatus.SPECIFIC_FRIENDS;

public class MainActivity extends AppCompatActivity {

    public static SimpleDateFormat sdfDate = new SimpleDateFormat("MMM dd");
    public static SimpleDateFormat sdfHour = new SimpleDateFormat("h:mma");

    private List mListNewFeed = new ArrayList();
    private List<ItemFriendSuggest> mItemFriendSuggests = new ArrayList<ItemFriendSuggest>();

    private List mFragments = new ArrayList();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTittleBar();
        setContentView(R.layout.activity_main);


        addControls();
        createNewFeedFragment();
        addTabLayoutEvents();
    }

    private void createNewFeedFragment() {
        createDataNewFeed();
        mFragments.add(new NewFeedFragment(mListNewFeed, this));

        mFragments.add(new LoadingFragment());
        mFragments.add(new LoadingFragment());
        mFragments.add(new LoadingFragment());
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments, this);

        mViewPager.setAdapter(mPagerAdapter);
        setTabIcon();
    }

    private void setTabIcon() {
        for (int i = 0; i < mFragments.size(); i++) {
            switch (i) {
                case 0:
                    mTabLayout.getTabAt(i).setIcon(R.drawable.cry);
                    break;
                case 1:
                    mTabLayout.getTabAt(i).setIcon(R.drawable.friends_gray);
                    break;
                case 2:
                    mTabLayout.getTabAt(i).setIcon(R.drawable.public_gray);

                    break;
                case 3:
                    mTabLayout.getTabAt(i).setIcon(R.drawable.three_line_option_gray);

                    break;
                default:
            }
        }
    }

    private void createDataNewFeed() {
        Date today = new Date();
        mListNewFeed.add(new ItemPostStatus(R.drawable.cuong_avatar));

        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                PUBLIC,
                "Từ ngày lên đại học anh ít thời gian hát hẳn, đêm nay a hát tặng e nhé :))) Minh Cuong",
                -69
        ));

        createListFriendsSuggest();

        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                FRIENDS,
                "-_- -_- -_- -_- -_- -_- -_-",
                R.drawable.gau_cuong,
                -47
        ));
        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                PRIVATE,
                "Uyên ỉn ọp",
                -47
        ));

        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                PUBLIC,
                "Điên đầu mất @@ (cái đồ cương hâm nữa, e đăng face mà cũng nói, hứ hứ, yêu hâm :D)",
                -29
        ));
        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                FRIENDS,
                "hợ hợ",
                -2
        ));
        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                PUBLIC,
                R.drawable.gau_cuong_2,
                -47
        ));
        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                FRIENDS,
                "hiihi",
                -8
        ));
        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                SPECIFIC_FRIENDS,
                "hihihihihihihihihihihihihihihimc",
                -21
        ));
        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                FRIENDS,
                "Minh Cương",
                -7
        ));
        mListNewFeed.add(new ItemStatus(
                R.drawable.cuong_avatar,
                "Minh Cương",
                today,
                FRIENDS,
                "Cương xị nỡ",
                -52
        ));
        mListNewFeed.add(new ItemLoading());
    }

    private void createListFriendsSuggest() {
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.cuong_large, "Minh Cuong", 1));
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.hanh, "Nguyễn Văn Hãnh", 60));
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.dai, "Quang Đại", 45));
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.nhan, "Nguyễn Đức Nhân", 38));
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.quyet, "Tư Quyết", 69));
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.thu, "Thanh Thư", 72));
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.default_avatar, "Triệu Đức", 72));
        mItemFriendSuggests.add(new ItemFriendSuggest(R.drawable.lam, "Tùng Lâm", 42));
        mListNewFeed.add(mItemFriendSuggests);
    }

    private void addTabLayoutEvents() {
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int positon = tab.getPosition();
                switch (positon) {
                    case 0:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.cry);
                        break;
                    case 1:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.friends_blue);
                        break;
                    case 2:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.public_blue);
                        break;
                    case 3:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.three_line_option_blue);
                        break;
                    default:
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int positon = tab.getPosition();
                switch (positon) {
                    case 0:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.cry);
                        break;
                    case 1:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.friends_gray);
                        break;
                    case 2:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.public_gray);
                        break;
                    case 3:
                        mTabLayout.getTabAt(positon).setIcon(R.drawable.three_line_option_gray);
                        break;
                    default:
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


    private void addControls() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void removeTittleBar() {
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);
        getSupportActionBar().hide();//hide Title Bar (tên application)
    }
}
