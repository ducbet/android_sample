package com.example.tmd.kakukube;

import android.graphics.Color;

/**
 * Created by tmd on 24/03/2017.
 */

public class ItemKakukube {
    private int mColor;

    public int getColor() {
        return mColor;
    }

    public boolean isCorrect() {
        return mCorrect;
    }

    public ItemKakukube(int color, boolean correct) {

        mColor = color;
        mCorrect = correct;
    }

    private boolean mCorrect;

}
