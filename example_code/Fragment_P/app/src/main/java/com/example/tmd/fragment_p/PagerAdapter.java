package com.example.tmd.fragment_p;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by tmd on 28/03/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    // Fragment sẽ lưu lại fragment trước, hiện tại và sau

    private List<QuestionFragment> mFragments;

    public PagerAdapter(FragmentManager fm, List<QuestionFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        // trả về fragment taị vị trí thứ position
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        // Số lượng fragment có trong ViewPager
        if (mFragments != null) {
            return mFragments.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Tra ve title cua page tai vi tri position
        return "position " + position;
    }
}
