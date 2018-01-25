package com.example.tmd.androidmenuapp;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by tmd on 25/03/2017.
 */

public class AppItem implements Serializable, Comparable<AppItem>{
    private int mImage;
    private String mName;

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public AppItem(int image, String name) {

        mImage = image;
        mName = name;
    }

    @Override
    public int compareTo(@NonNull AppItem o) {
        return this.mName.compareToIgnoreCase(o.getName());
    }
}
