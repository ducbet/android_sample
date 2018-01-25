package com.kimdung.kimdungtronbo.Rule;

import com.kimdung.kimdungtronbo.models.Paragraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmd on 02/05/2017.
 */


public class ParagraphProcess {
    public static List<Paragraph> splitChapter(String deSource){
        List<Paragraph> mListParagraph = new ArrayList<>();
        String[] arr = deSource.split("<br/>");
        for (int i = 0; i < arr.length; i++) {
            mListParagraph.add(new Paragraph(arr[i]));
        }
        // garbage collector
        arr = null;
        System.gc();
        return mListParagraph;
    }
}