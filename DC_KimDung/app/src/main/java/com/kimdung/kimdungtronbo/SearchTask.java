package com.kimdung.kimdungtronbo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.kimdung.kimdungtronbo.adapters.ChapterListAdapter;
import com.kimdung.kimdungtronbo.models.Chapter;
import com.kimdung.kimdungtronbo.models.Paragraph;

import java.util.List;

/**
 * Created by Admin on 7/5/2017.
 */

public class SearchTask extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "MY_TAG_SearchTask";

    private Context mContext;
    private ChapterListAdapter mChapterListAdapter;
    private String mQuery;

    List<Chapter> list;

    public SearchTask(Context context, ChapterListAdapter chapterListAdapter, String query) {
        mContext = context;
        mChapterListAdapter = chapterListAdapter;
        mQuery = query;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(mContext, "Bắt đầu tìm kiếm!", Toast.LENGTH_SHORT).show();
        mQuery = mQuery.toLowerCase().trim();
        mQuery = fixSpace(mQuery);
        list = mChapterListAdapter.getChapterList();

        // TODO: 08/05/2017
        // đặt tất cả màu thành đỏ, nếu cái này khớp thì mới chuyển thành xanh
        for (Chapter chapter : list) {
            chapter.setResultSearchContent(null);
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
//        Log.d(TAG, "Bat dau doInBackgound");
        search();
        return null;
    }


    public String fixSpace(String origin) {
        StringBuffer buffer = new StringBuffer(origin);
        for (int i = 0; i < buffer.length() - 1; i++) {
            if (buffer.charAt(i) == ' ' && buffer.charAt(i + 1) == ' ') {
                buffer.deleteCharAt(i);
                i--;
            }
        }
        return buffer.toString();
    }

    public void search() {
        Log.d(TAG, "search: start");
        String resultSearchContent = "";
        String[] keyWords = mQuery.split(" ");
        int count = 0;
        for (int i = 0; !isCancelled() && i < list.size(); i++) {
            count = 0;
            resultSearchContent = "";
            Chapter chapter = list.get(i);
            List<Paragraph> listPara = chapter.getListParagraphs();
            for (int j = 0; !isCancelled() && j < listPara.size(); j++) {
                Paragraph para_ = listPara.get(j);
                String para = para_.getContent();
                para = para.replaceAll("\\W", " ");
                String[] paraArr = para.split(" ");
                for (int k = 0; !isCancelled() && k < paraArr.length; k++) {
//                    Log.d(TAG, "Tu hien tai la: " + paraArr[k]);
                    if (count < keyWords.length && paraArr[k].toLowerCase().equals(keyWords[count])) {
//                        Log.d(TAG, "Da tim thay tu " + paraArr[k] + " va count = " + count);
                        count++;
                        resultSearchContent += paraArr[k];
                        if (k < paraArr.length - 1) {
                            resultSearchContent += " ";
                            resultSearchContent += paraArr[k + 1];
                            resultSearchContent += " ... ";
                        }
                        if (count > keyWords.length)
                            break;
                    }
                }
            }

            if (count == keyWords.length) {
                // xoa dau xoa cuoi
                StringBuffer result = new StringBuffer(resultSearchContent);
                while (result.charAt(0) == '.' || result.charAt(0) == ' ') {
                    result.deleteCharAt(0);
                }

                while (result.charAt(result.length() - 1) == '.' || result.charAt(result.length() - 1) == ' ') {
                    result.deleteCharAt(result.length() - 1);
                }
//                Log.d(TAG, "search: result.toString(): " + result.toString());
                chapter.setResultSearchContent(result.toString());
                publishProgress();
            } else {
                // TODO: 08/05/2017  
                chapter.setResultSearchContent("");
            }

        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        if (!isCancelled())
            mChapterListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mContext, "Kết thúc tìm kiếm!", Toast.LENGTH_SHORT).show();
    }
}
