package com.kimdung.kimdungtronbo.Rule;

import android.os.AsyncTask;
import android.util.Log;

import com.kimdung.kimdungtronbo.models.Chapter;
import com.kimdung.kimdungtronbo.models.Novel;

import java.util.List;

import static com.kimdung.kimdungtronbo.ReadingActivity.mCurrentChap;


/**
 * Created by tmd on 03/05/2017.
 */

public class CheckMistakeInBackGround extends AsyncTask<Novel, Void, Void> {

    private static final String TAG = "MY_TAG_CheckChinhTa";
    private List<Chapter> mListChapters;
    private Novel mNovel;

    @Override
    protected Void doInBackground(Novel... params) {
        Thread.currentThread().setName("CheckChinhTaInBackGround");// để tiện debug
        // đối số theo thứ tự: novel
        mNovel = (Novel) params[0];

        mListChapters = mNovel.getListChapters();
        Log.d(TAG, "MyThread running: " + Thread.currentThread().getName());

        int numberOfChapter = mListChapters.size();

        // asyntask.cancel(true); cũng không kill được process asyn đang thực hiện, phải kill thủ công
        // bằng check !isCancelled()
        // vòng for này check toàn lỗi mistake trong novel
        // có hàm mNovel.checkValid() để check mistake toàn bộ nhưng không có isCancel để dừng
        // load lần lượt từ đầu đến cuối
//        for (int i = 0; !isCancelled() && i < mListChapters.size(); i++) {
        // load từ chapter đang đọc

        mNovel.checkValidChapter(mListChapters.get(mCurrentChap));
        Log.d(TAG, "Chapter checked: " + (mCurrentChap + 1) + " (current chapter)");
        for (int i = (mCurrentChap + 1) % numberOfChapter; !isCancelled() && i != mCurrentChap; i = (i + 1) % numberOfChapter) {
            mNovel.checkValidChapter(mListChapters.get(i));
            Log.d(TAG, "Chapter checked: " + (i + 1));
        }
        Log.d(TAG, "Chapter checked: All chapter loaded" );
        return null;
    }
}
