package com.kimdung.kimdungtronbo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 28/4/2017.
 */

public class Novel implements Serializable {
    private int mStId;
    private String mStName;
    private int mAuId;
    private String mStImage;
    private String mStDescribe;
    private List<Chapter> mListChapters;
    private List<String> mListMisTake;

    public List<String> checkValidChapter(Chapter chapter) {
        // check mistake 1 chapter
        return chapter.checkValid();
    }

    public List<String> checkValid() {
        // check mistake toàn bộ novel
        // dung foreach se error ConcurrentModificationException
        // ném các token vào HashSet để đảm bảo không có token trùng lặp (HashSet tự động làm)
        Set<String> setAllMistake = new HashSet<>();
        for (int i = 0; i < mListChapters.size(); i++) {
            setAllMistake.addAll(checkValidChapter(mListChapters.get(i)));
        }
        mListMisTake.addAll(setAllMistake);
        return mListMisTake;
    }

    public void clearListChapters() {
        mListChapters.clear();
        // garbage collector
        System.gc();
    }

    public List<Chapter> getListChapters() {
        return mListChapters;
    }

    public Novel(int stId, String stName, int auId, String stImage, String stDescribe) {
        mStId = stId;
        mStName = stName;
        mAuId = auId;
        mStImage = stImage;
        mStDescribe = stDescribe;
        mListChapters = new ArrayList<>();
        mListMisTake = new ArrayList<>();
    }

    public void addChapter(Chapter chapter) {
        mListChapters.add(chapter);
    }

    public Novel() {
    }

    public int getStId() {
        return mStId;
    }

    public void setStId(int stId) {
        mStId = stId;
    }

    public String getStName() {
        return mStName;
    }

    public void setStName(String stName) {
        mStName = stName;
    }

    public int getAuId() {
        return mAuId;
    }

    public void setAuId(int auId) {
        mAuId = auId;
    }

    public String getStImage() {
        return mStImage;
    }

    public void setStImage(String stImage) {
        mStImage = stImage;
    }

    public String getStDescribe() {
        return mStDescribe;
    }

    public void setStDescribe(String stDescribe) {
        mStDescribe = stDescribe;
    }

    @Override
    public String toString() {
        return getStId() + "-" + getStName() + "-" + getAuId() + "-" + getStImage() + "-" + getStDescribe();
    }
}
