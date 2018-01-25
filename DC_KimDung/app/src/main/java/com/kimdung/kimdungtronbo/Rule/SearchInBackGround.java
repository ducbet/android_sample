package com.kimdung.kimdungtronbo.Rule;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.kimdung.kimdungtronbo.database.DatabaseHelper;
import com.kimdung.kimdungtronbo.models.Chapter;
import com.kimdung.kimdungtronbo.models.Novel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.text.Html.FROM_HTML_MODE_COMPACT;

/**
 * Created by tmd on 07/05/2017.
 */

public class SearchInBackGround extends AsyncTask<Object, Void, Void> {

    private static final String TAG = "MY_TAG_SearchInBackGround";

    private static final String NEED_SEARCH = "sau đó mới";

    private List<Chapter> mListChapters;
    private Novel mNovel;
    private Chapter readingChapter;
    private DatabaseHelper mDatabaseHelper;
    private Context mContext;
    private String mDeContent = "";

    @Override
    protected Void doInBackground(Object... params) {
        Thread.currentThread().setName("SearchInBackGround");// để tiện debug

        // đối số theo thứ tự: novel, readingChapter, mContext
        mNovel = (Novel) params[0];
        readingChapter = (Chapter) params[1];
        mContext = (Context) params[2];

//        Log.d(TAG, "readingChapter: " + readingChapter.getDeId());

        mDatabaseHelper = new DatabaseHelper(mContext);
        mListChapters = mNovel.getListChapters();

        //lấy index của chapter trong listChapter, load từ index + 1 -> hết -> 0 -> index - 1 (dùng %)
        int index = getIndexOfChapterInList();
        int numberOfChapter = mListChapters.size();
        // asyntask.cancel(true); cũng không kill được process asyn đang thực hiện, phải kill thủ công
        // bằng check !isCancelled()
//        Log.d(TAG, "getIndexOfChapterInList: " + index + "; numberOfChapter: " + numberOfChapter);
        for (int i = (index + 1) % numberOfChapter; !isCancelled() && i != index; i = (i + 1) % numberOfChapter) {
            mDeContent = mDatabaseHelper.getDeContentOfChapters(mListChapters.get(i));
            boolean result = searchKeyWord();
//            if (result) {
//                Log.d(TAG, "SearchInBackGround: chap " + (i + 1));
//            }
        }
//        Log.d(TAG, "MyThread running: " + Thread.currentThread().getName());

        return null;
    }

    public boolean searchKeyWord() {
        // thuật toán này loại bỏ các từ trùng lặp rồi mới kiểm tra
        // => đoạn văn độ dài càng lớn càng hiệu quả

        // xóa toàn bộ html tag trong mContent
        String mTmpContent = removeHtmlTag();

        // xóa toàn bộ ký tự đặc biệt trong mContent
        mTmpContent = mTmpContent.replaceAll("\\W", " ").toLowerCase();

        // cắt mContent thành từng token
        String[] stringAllToken;
        stringAllToken = mTmpContent.split(" ");

        // ném các token vào HashSet để đảm bảo không có token trùng lặp (HashSet tự động làm)
        Set<String> setAllToken = new HashSet<>(Arrays.asList(stringAllToken));

        // add ngược lại arrayList để dùng .get(0),...
        List<String> arrayAllToken = new ArrayList<>();
        arrayAllToken.addAll(setAllToken);

        // cắt NEED_SEARCH thành từng Token rồi ném vào ArrayList
        String[] stringListNeedSearch;
        stringListNeedSearch = NEED_SEARCH.replaceAll("\\W", " ").toLowerCase().split(" ");
        List<String> arrayListNeedSearch = new ArrayList<>(Arrays.asList(stringListNeedSearch));

//        Log.d(TAG, "-_-HashSet: " + setAllToken.size() + ";arrayAllToken: " + arrayAllToken.size());

        // kiểm tra token trong arrayAllToken, nếu có lỗi thì add vào listMistake
        for (int i = 0; i < arrayAllToken.size(); i++) {
            if (arrayAllToken.get(i).equals(arrayListNeedSearch.get(0))) {
//                Log.d(TAG, "searchKeyWord: " + arrayAllToken.get(i));
                arrayListNeedSearch.remove(0);
//                Log.d(TAG, "searchKeyWord: left: " + arrayListNeedSearch.get(0));

            }
        }
        if (arrayListNeedSearch.size() == 0) {
            return true;
        }
        return false;
    }

    private String removeHtmlTag() {
        String mTmpContent;
        // mContent k thay doi
//        Log.d("TAG", "checkValidParagraph: mContent_before: \"" + mContent + "\"");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mTmpContent = android.text.Html.fromHtml(mDeContent, FROM_HTML_MODE_COMPACT).toString();
        } else {
            mTmpContent = android.text.Html.fromHtml(mDeContent).toString();
        }
//        Log.d("TAG", "checkValidParagraph: mContent_after: \"" + mContent + "\"");
        return mTmpContent;
    }

    public int getIndexOfChapterInList() {
        for (int i = 0; i < mListChapters.size(); i++) {
//            Log.d(TAG, "id chapter " + (i + 1) + "= " + mListChapters.get(i).getDeId() + "; readingChapter: " + readingChapter.getDeId());
            if (mListChapters.get(i).getDeId() == readingChapter.getDeId()) {
                return i;
            }
        }
        // không bao giờ xảy ra
        // chả biết return gì nên để ntn
        return mListChapters.size() - 1;
    }
}
