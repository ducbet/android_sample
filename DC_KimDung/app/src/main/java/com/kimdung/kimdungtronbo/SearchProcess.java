package com.kimdung.kimdungtronbo;

import android.util.Log;

import com.kimdung.kimdungtronbo.models.Chapter;
import com.kimdung.kimdungtronbo.models.Paragraph;
import com.kimdung.kimdungtronbo.models.SearchResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 6/5/2017.
 */

public class SearchProcess {
    private static final String TAG = "MY_TAG_SearchProcess";

    public static List<SearchResult> searchChapter(List<Chapter> originList, String query) {

        List<SearchResult> mChaps = new ArrayList<>();
//        Log.d(TAG, "Bat dau search");
        query = query.toLowerCase().trim();
        // fix thua dau cach
        StringBuffer buffer = new StringBuffer(query);
        for (int i = 0; i < buffer.length() - 1; i++) {
            if (buffer.charAt(i) == ' ' && buffer.charAt(i + 1) == ' ') {
                buffer.deleteCharAt(i);
                i--;
            }
        }
        query = buffer.toString();

        String[] keyWords = query.split(" ");
        int currentWordIndex = 0;
        for (Chapter chapter : originList) {
//            Log.d(TAG, "ChapterName = " + chapter.getDeName());
            // chay qua tung chaper
            currentWordIndex = 0;
            String displayContent = "";
            // lay ra list cac doan
            List<Paragraph> paragraphList = chapter.getListParagraphs();
            for (int i = 0; i < paragraphList.size(); i++) {
                // chay tung doan
                String content = paragraphList.get(i).getContent();
                // lay tung tu
                String[] bufferPara = content.split(" ");
                for (int j = 0; i < bufferPara.length; i++) {
                    String tmp = bufferPara[i];
//                    Log.d(TAG, "ChapName = " + chapter.getDeName() + " - " + "tmp = " + tmp);
                    // so sanh bang voi key hien tai
                    if (tmp.toLowerCase().equals(keyWords[currentWordIndex])) {
                        currentWordIndex++;
                        displayContent += " ... " + tmp;
                        if (i < bufferPara.length - 1) {
                            displayContent += " ";
                            displayContent += bufferPara[i + 1];
                        }
                    }
                }
            }
            if (currentWordIndex == keyWords.length) {
                SearchResult result = new SearchResult(chapter, displayContent);
                mChaps.add(result);
            }
        }
//        Log.d(TAG, "ket thuc search");
        return mChaps;
    }

    public static void debug(List<SearchResult> list) {
        Log.d(TAG, "Bat dau show");
        for (SearchResult result : list) {
            Log.d(TAG, result.getChapter().getDeName() + " - " + result.getDisplayContent());
        }
        Log.d(TAG, "Ket thuc show");
    }
}
