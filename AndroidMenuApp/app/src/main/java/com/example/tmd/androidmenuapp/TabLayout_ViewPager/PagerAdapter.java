package com.example.tmd.androidmenuapp.TabLayout_ViewPager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by tmd on 29/03/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<MenuFragment> mFragments;

    public PagerAdapter(FragmentManager fm, Context context, List<MenuFragment> fragments) {
        super(fm);
        mContext = context;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "   APPS   ";
            case 4:
                return "  WIDGETS  ";
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        if (mFragments == null) return 0;
        return mFragments.size();
    }
}
