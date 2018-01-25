package com.kimdung.kimdungtronbo.database;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.kimdung.kimdungtronbo.adapters.ChapterListAdapter;
import com.kimdung.kimdungtronbo.models.Chapter;
import com.kimdung.kimdungtronbo.models.Novel;
import com.kimdung.kimdungtronbo.models.Paragraph;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.kimdung.kimdungtronbo.Rule.ParagraphProcess.splitChapter;

/**
 * Created by tmd on 03/05/2017.
 */

public class LoadChapterInBackGround extends AsyncTask<Object, Void, Void> {

    private static final String TAG = "MY_TAG_LoadChapter";
    private int updateAdapter;
    private ChapterListAdapter mChapterListAdapter;
    private Context mContext;
    private Novel mNovel;
    private DatabaseHelper mDatabaseHelper;
    private Cursor c;

    @Override
    protected void onCancelled() {
//        Log.d(TAG, "onCancelled: ");
        super.onCancelled();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Object... params) {
        Thread.currentThread().setName("LoadChapterInBackGround");// để tiện debug

        // đối số theo thứ tự: mNovel, mAdapter, mContext
        mNovel = (Novel) params[0];
        mChapterListAdapter = (ChapterListAdapter) params[1];
        mContext = (Context) params[2];

//        Log.d(TAG, "MyThread running: " + Thread.currentThread().getName());
        mDatabaseHelper = new DatabaseHelper(mContext);
        // DatabaseHelper chỉ loaddatabase, lấy cursor trỏ vào db nhưng chưa new Chapter hay Paragraph gì cả
        c = mDatabaseHelper.getCursorChaptersOfANovel(mNovel);

        // lấy cursor để load dần từng chap
        loadTungChap();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

//        Log.d(TAG, "LoadChapterInBackGround: onPostExecute ");
//        searchChapter(mNovel.getListChapters(), "du thị niên");
        // garbage collector
        c = null;
        System.gc();
    }

    public void loadTungChap() {
        // cancel() kill asyntask but not kill process, must kill manually  by check !isCancelled()
        for (int i = 0; !isCancelled() && c != null && c.moveToNext(); i++) {
            int deId = c.getInt(c.getColumnIndex(NovelContract.ChapterEntry.COLUMN_DE_ID));
            String deName = c.getString(c.getColumnIndex(NovelContract.ChapterEntry.COLUMN_DE_NAME));
            String deSource = c.getString(c.getColumnIndex(NovelContract.ChapterEntry.COLUMN_DE_SOURCE));
            String deContent = c.getString(c.getColumnIndex(NovelContract.ChapterEntry.COLUMN_DE_CONTENT));

            // tách mContent thành từng Paragraph
            List<Paragraph> listParagraphs = splitChapter(mDatabaseHelper.getDeContentChapter(deId));

            // in hoa, in đậm tiêu đề (câu đầu tiên là tiêu đề)
            listParagraphs.get(0).h1().bold();

            int stID = c.getInt(c.getColumnIndex(NovelContract.ChapterEntry.COLUMN_ST_ID));
            String stringDeDate = c.getString(c.getColumnIndex(NovelContract.ChapterEntry.COLUMN_DE_DATE));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date deDate = null;
            try {
                deDate = format.parse(stringDeDate);
            } catch (ParseException e) {
            }

            Chapter chapter = new Chapter(deId, deName, deSource, listParagraphs, stID, deDate);
//            Log.d(TAG, "loadTungChap in thread" + Thread.currentThread().getName() + " " + deName);

            // add chapter dần dần vào listChapter của novel, lúc đầu list này rỗng (nhưng vẫn != null)
            mNovel.addChapter(chapter);

            // mỗi lần load đc 1 chap thì hiện ra ChapterList
            publishProgress();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        mChapterListAdapter.notifyDataSetChanged();
    }
}