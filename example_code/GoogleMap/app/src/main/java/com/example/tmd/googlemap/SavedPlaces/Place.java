package com.example.tmd.googlemap.SavedPlaces;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by tmd on 08/04/2017.
 */

public class Place implements Serializable, Comparable<Place> {

    private String mName;
    private int mImage;
    private double mLat;
    private double mLng;

    public String getName() {
        return mName;
    }

    public int getImage() {
        return mImage;
    }

    public double getLat() {
        return mLat;
    }

    public double getLng() {
        return mLng;
    }

    public Place(String name, int image, double lat, double lng) {
        mName = name;
        mImage = image;
        mLat = lat;
        mLng = lng;
    }

    @Override
    public int compareTo(@NonNull Place o) {
        return mName.compareToIgnoreCase(o.getName());
    }
}
