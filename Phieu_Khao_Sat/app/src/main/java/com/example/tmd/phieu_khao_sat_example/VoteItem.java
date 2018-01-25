package com.example.tmd.phieu_khao_sat_example;

/**
 * Created by tmd on 30/03/2017.
 */

public class VoteItem {
    private String mContent = "";
    private int mAvatar = 0;

    public String getContent() {
        return mContent;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public VoteItem(int avatar) {
        mAvatar = avatar;
    }

    public VoteItem(String content, int avatar) {

        mContent = content;
        mAvatar = avatar;
    }
}
