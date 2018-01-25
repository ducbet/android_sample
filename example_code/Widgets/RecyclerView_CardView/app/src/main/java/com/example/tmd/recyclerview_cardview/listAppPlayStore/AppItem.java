package com.example.tmd.recyclerview_cardview.listAppPlayStore;

/**
 * Created by tmd on 21/03/2017.
 */

public class AppItem {
    private int mImageAvatar;
    private String mTitle;
    private String mNSX;
    private float mRating;
    private int mImageStatus;
    private String mTxtStatus;

    public int getmImageAvatar() {
        return mImageAvatar;
    }

    public void setmImageAvatar(int mImageAvatar) {
        this.mImageAvatar = mImageAvatar;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmNSX() {
        return mNSX;
    }

    public void setmNSX(String mNSX) {
        this.mNSX = mNSX;
    }

    public float getmRating() {
        return mRating;
    }

    public void setmRating(float mRating) {
        this.mRating = mRating;
    }

    public int getmImageStatus() {
        return mImageStatus;
    }

    public void setmImageStatus(int mImageStatus) {
        this.mImageStatus = mImageStatus;
    }

    public String getmTxtStatus() {
        return mTxtStatus;
    }

    public void setmTxtStatus(String mTxtStatus) {
        this.mTxtStatus = mTxtStatus;
    }

    public AppItem(int mImageAvatar, String mTitle, String mNSX, float mRating, int mImageStatus, String mTxtStatus) {
        this.mImageAvatar = mImageAvatar;
        this.mTitle = mTitle;
        this.mNSX = mNSX;
        this.mRating = mRating;
        this.mImageStatus = mImageStatus;
        this.mTxtStatus = mTxtStatus;
    }
}
