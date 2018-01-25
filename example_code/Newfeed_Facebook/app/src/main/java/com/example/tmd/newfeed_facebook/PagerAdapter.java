package com.example.tmd.newfeed_facebook;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by tmd on 30/03/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private Context mContext;

    public PagerAdapter(FragmentManager fm, List fragments, Context context) {
        super(fm);
        mFragments = fragments;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        if (mFragments != null) return mFragments.size();
        return 0;
    }
}
