package com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView;

import com.example.tmd.newfeed_facebook.R;

import java.util.Date;

/**
 * Created by tmd on 30/03/2017.
 */

public class ItemStatus {

    public static int PRIVATE = R.drawable.private_modifier_gray;
    public static int FRIENDS = R.drawable.friends_gray;
    public static int PUBLIC = R.drawable.public_gray;
    public static int SPECIFIC_FRIENDS = R.drawable.specific_friends_gray;

    private int mAvatar = 0;
    private String mName = "";
    private Date mTimeCreate = new Date();
    private int mModifier = PRIVATE;
    private String mContent = "";
    private int mImgContent = 0;
    private int mNumLikes = 0;
    private int mNumShares = 0;
    private int mNumViews = 0;
    private int mNumComments = 0;

    public ItemStatus(int avatar, String name, Date timeCreate, int modifier, String content, int imgContent, int numLikes) {
        mAvatar = avatar;
        mName = name;
        mTimeCreate = timeCreate;
        mModifier = modifier;
        mContent = content;
        mImgContent = imgContent;
        mNumLikes = numLikes;
    }

    public int getImgContent() {
        return mImgContent;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public String getName() {
        return mName;
    }

    public Date getTimeCreate() {
        return mTimeCreate;
    }

    public int getModifier() {
        return mModifier;
    }

    public String getContent() {
        return mContent;
    }

    public int getNumLikes() {
        return mNumLikes;
    }

    public int getNumComments() {
        return mNumComments;
    }

    public int getNumShares() {
        return mNumShares;
    }

    public int getNumViews() {
        return mNumViews;
    }

    public ItemStatus(int avatar, String name, Date timeCreate, int modifier, String content, int numLikes) {
        mAvatar = avatar;
        mName = name;
        mTimeCreate = timeCreate;
        mModifier = modifier;
        mContent = content;
        mNumLikes = numLikes;
    }

    public ItemStatus(int avatar, String name, Date timeCreate, int modifier, int imgContent, int numLikes) {
        mAvatar = avatar;
        mName = name;
        mTimeCreate = timeCreate;
        mModifier = modifier;
        mImgContent = imgContent;
        mNumLikes = numLikes;
    }

    public ItemStatus(int avatar, String name, Date timeCreate, int modifier, String content, int numLikes, int numShares, int numViews, int numComments) {

        mAvatar = avatar;
        mName = name;
        mTimeCreate = timeCreate;
        mModifier = modifier;
        mContent = content;
        mNumLikes = numLikes;
        mNumShares = numShares;
        mNumViews = numViews;
        mNumComments = numComments;
    }
}
