package com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.FriendSuggest_RecyclerView;

/**
 * Created by tmd on 31/03/2017.
 */

public class ItemFriendSuggest {
    private int mAvatar;
    private String mName;

    public int getAvatar() {
        return mAvatar;
    }

    public String getName() {
        return mName;
    }

    public int getNumMutualFriends() {
        return mNumMutualFriends;
    }

    public ItemFriendSuggest(int avatar, String name) {
        mAvatar = avatar;
        mName = name;
    }

    public ItemFriendSuggest(int avatar, String name, int numMutualFriends) {

        mAvatar = avatar;
        mName = name;
        mNumMutualFriends = numMutualFriends;
    }

    private int mNumMutualFriends;

}

