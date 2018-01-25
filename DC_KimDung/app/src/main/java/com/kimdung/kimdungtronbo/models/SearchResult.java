package com.kimdung.kimdungtronbo.models;

/**
 * Created by Admin on 6/5/2017.
 */

public class SearchResult {
    private Chapter mChapter;
    private String mDisplayContent;

    public SearchResult(Chapter chapter, String displayContent) {
        mChapter = chapter;
        mDisplayContent = displayContent;
    }

    public Chapter getChapter() {
        return mChapter;
    }

    public void setChapter(Chapter chapter) {
        mChapter = chapter;
    }

    public String getDisplayContent() {
        return mDisplayContent;
    }

    public void setDisplayContent(String displayContent) {
        mDisplayContent = displayContent;
    }

}
