package com.kimdung.kimdungtronbo.models;

import android.content.Context;
import android.util.Log;

import com.kimdung.kimdungtronbo.database.DatabaseHelper;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 28/4/2017.
 */

public class Chapter implements Serializable {
    private static final String TAG = "MY_TAG_Chapter";

    private int mDeId;
    private String mDeName;
    private String mDeSource;
    private List<Paragraph> mListParagraphs;
    private int mStId;
    private Date mDeDate;
    private String resultSearchContent;
    private List<String> mListMisTake;

    public List<Paragraph> getContentMarked() {
        if (mListMisTake == null) {
            // == null tức là chưa check đến
            Log.d(TAG, "check thủ công chapter: ");
            checkValid();
        }
        List<Paragraph> mListParagraphMarked = new ArrayList<>();
        for (int i = 0; i < mListParagraphs.size(); i++) {
            mListParagraphMarked.add(mListParagraphs.get(i).getContentMarked());
        }
        return mListParagraphMarked;
    }

    public List<String> checkValidParagraph(Paragraph paragraph) {
        // check mistake 1 paragraph
        return paragraph.checkValid();
    }

    public List<String> checkValid() {
        // check mistake toàn bộ chapter
        // dung foreach se error ConcurrentModificationException
        // ném các token vào HashSet để đảm bảo không có token trùng lặp (HashSet tự động làm)
        Set<String> setAllMistake = new HashSet<>();
        for (int i = 0; i < mListParagraphs.size(); i++) {
            setAllMistake.addAll(checkValidParagraph(mListParagraphs.get(i)));
        }
        if (mListMisTake == null) {
            mListMisTake = new ArrayList<>();
        }
        mListMisTake.clear();// có thể có danh sách lỗi rồi do đã được check thủ công
        mListMisTake.addAll(setAllMistake);
        return mListMisTake;
    }

    public String getResultSearchContent() {
        return resultSearchContent;
    }

    public void setResultSearchContent(String resultSearchContent) {
        this.resultSearchContent = resultSearchContent;
    }

    public List<String> getListMisTake() {
        // tránh lỗi
        if (mListMisTake != null) {
            return mListMisTake;
        } else {
            mListMisTake = new ArrayList<>();
            return mListMisTake;// == null thi return 1
        }
    }

    public Chapter(int stId, String stName, int auId, String stImage, String stDescribe, int deId, String deName, String deSource, int stId1, Date deDate) {
        mDeId = deId;
        mDeName = deName;
        mDeSource = deSource;
        mListParagraphs = new ArrayList<>();
        mStId = stId1;
        mDeDate = deDate;
    }

    public Chapter(int deId, String deName, String deSource, List<Paragraph> listParagraphs, int stId, Date deDate) {
        mDeId = deId;
        mDeName = deName;
        mDeSource = deSource;
        mListParagraphs = listParagraphs;
        mStId = stId;
        mDeDate = deDate;
    }

    public Chapter() {
    }

    public List<Paragraph> getListParagraphs() {
        return mListParagraphs;
    }

    public int getDeId() {
        return mDeId;
    }

    public void setDeId(int deId) {
        mDeId = deId;
    }

    public String getDeName() {
        return mDeName;
    }

    public void setDeName(String deName) {
        mDeName = deName;
    }

    public String getDeSource() {
        return mDeSource;
    }

    public void setDeSource(String deSource) {
        mDeSource = deSource;
    }

    public int getStId() {
        return mStId;
    }

    public void setStId(int stId) {
        mStId = stId;
    }

    public Date getDeDate() {
        return mDeDate;
    }

    public void setDeDate(Date deDate) {
        mDeDate = deDate;
    }

    public String getStringDeDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(getDeDate());
    }

    public String getStName(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        return helper.getStNameOfChapter(mStId);
    }

    @Override
    public String toString() {
        return getDeId()
//                + "-" + getDeName()
//                + "-" + getDeSource()
//                + "-" + getDeContent()
                + "-" + getStId()
                + "-" + getStringDeDate();
    }

}
