package com.example.tmd.kakukube;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.Random;

import static com.example.tmd.kakukube.MainActivity.mKakukubeAdapter;
import static com.example.tmd.kakukube.MainActivity.mRecyclerView;

/**
 * Created by tmd on 24/03/2017.
 */

public class LevelKakukube {
    private final int EASY = 0; // 3x3
    private final int MEDIUM = 5; // 4x4
    private final int HARD = 10; // 5x5
    private final int SUPER_HARD = 15; // 6x6
    public static int mLevel = 1;

    private ArrayList mArrayItem = new ArrayList();

    private int mAlphaDifference;
    private double mSpeedIncreaseAlpha;
    private int mItemPerRow;
    private int mDifferenceItem;
    private int mColor, mColor2;

    private Random mRandom = new Random();

    Context mContext;


    public static int getmLevel() {
        return mLevel;
    }


    public LevelKakukube(Context context) {
        this.mContext = context;
        mSpeedIncreaseAlpha = 1.2;
        mAlphaDifference = 100;
        mLevel = 1;
        mItemPerRow = 3; // EASY
        setDataKakukube();
    }


    public void setItemPerRow() {
        switch (mLevel) {
            case MEDIUM:
                mItemPerRow = 4;
                break;
            case HARD:
                mItemPerRow = 5;
                break;
            case SUPER_HARD:
                mItemPerRow = 6;
                break;
        }
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, mItemPerRow));
    }

    public void loadNewLevel() {
        setLevel();
        getItemColor();
        setItemPerRow();
        mArrayItem.removeAll(mArrayItem);
        for (int i = 0; i < mItemPerRow * mItemPerRow; i++) {
            mArrayItem.add(i, new ItemKakukube(mColor, false));
        }
        setDifferenceItem();
        mKakukubeAdapter.notifyDataSetChanged();
    }

    public void setDataKakukube() {

        getItemColor();
        for (int i = 0; i < mItemPerRow * mItemPerRow; i++) {
            mArrayItem.add(i, new ItemKakukube(mColor, false));
        }
        setDifferenceItem();
    }

    private void getItemColor() {
        int[] mDecColor = new int[4];
        int mAlphaColor2;
        boolean doAgain = false;
        do {
            doAgain = false;
            try {
                for (int i = 0; i < 4; i++) {
                    mDecColor[i] = mRandom.nextInt(256); // alpha, red, green, blue
                }

                if (mDecColor[0] > mAlphaDifference) {
                    mAlphaColor2 = mDecColor[0] - mAlphaDifference;
                } else {
                    mAlphaColor2 = mDecColor[0] + mAlphaDifference;
                }
                mColor = Color.argb(mDecColor[0], mDecColor[1], mDecColor[2], mDecColor[3]);// nếu không tồn tại Color này thì ném ra Exception và tìm màu khác
                mColor2 = Color.argb(mAlphaColor2, mDecColor[1], mDecColor[2], mDecColor[3]);// nếu không tồn tại Color này thì ném ra Exception và tìm màu khác
            } catch (Exception e) {
                System.out.println("Unknown color, do again");
                doAgain = true;
            }
        } while (doAgain);
    }

    private void setDifferenceItem() {
        mDifferenceItem = mRandom.nextInt(mItemPerRow * mItemPerRow - 1);
        mArrayItem.remove(mDifferenceItem);
        mArrayItem.add(mDifferenceItem, new ItemKakukube(mColor2, true));
    }

    private void setLevel() {
        if (mAlphaDifference > 1)
            mAlphaDifference = (int) (mAlphaDifference / mSpeedIncreaseAlpha);
        mLevel++;
        System.out.printf("Difference: %d, level: %d\n", mAlphaDifference, mLevel);
    }

    public ArrayList getArrayItem() {
        return mArrayItem;
    }

    public int getItemPerRow() {
        return mItemPerRow;
    }
}
