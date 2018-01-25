package com.example.dc.retrofit_lib;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tmd on 25/04/2017.
 */

public class GithubModel {
    // TODO: 25/04/2017 6 sau khi get Data thanh cong

    @SerializedName("login")
    private String mLogin;
    @SerializedName("id")
    private int mID;
    @SerializedName("avatar_url")
    private String mAvatarUrl;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("html_url")
    private String mHtmlUrl;
//    @SerializedName("followers_url")
    private String mFollowUrl;

    public String getLogin() {
        return mLogin;
    }

    public int getID() {
        return mID;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getFollowUrl() {
        return mFollowUrl;
    }
}
