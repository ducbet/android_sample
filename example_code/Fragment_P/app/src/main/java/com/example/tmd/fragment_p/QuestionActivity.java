package com.example.tmd.fragment_p;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements QuestionFragment.OnSendResult, View.OnClickListener, ViewPager.OnPageChangeListener {

    private Button mBtnBack, mBtnNext;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<QuestionFragment> mFragments;

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        addControls();
        addEvents();

        createViewPager();

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setIcon(R.mipmap.ic_launcher);

        }
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(R.mipmap.ic_launcher_round);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(R.mipmap.ic_launcher);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void createViewPager() {
        // Khoi tao list fragment
        mFragments = new ArrayList<QuestionFragment>();
        for (int i = 0; i < 20; i++) {
            mFragments.add(QuestionFragment.newInstance(i));
        }

        // Khoi tao Adapter
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);

        // Gan Adapter cho ViewPager
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void addEvents() {
        mBtnBack.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(this);
    }

    private void addControls() {
        mBtnBack = (Button) findViewById(R.id.button_back);
        mBtnNext = (Button) findViewById(R.id.button_next);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_question);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);// neu muon dat tablayout xa viewpager
    }

    @Override
    public void onClick(View v) {
        int currentPosition = mViewPager.getCurrentItem();
        switch (v.getId()) {
            case R.id.button_back:
                currentPosition--;
                mViewPager.setCurrentItem(currentPosition);
                break;
            case R.id.button_next:
                currentPosition++;
                mViewPager.setCurrentItem(currentPosition);
                break;
            default:
                break;
        }
    }

    @Override
    public void sendResult(int result) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // Khi người dùng scroll
    }

    @Override
    public void onPageSelected(int position) {
        // Khi màn hình hiện lên
        mBtnBack.setVisibility(View.VISIBLE);
        mBtnNext.setVisibility(View.VISIBLE);

        if (position == 0) {
            mBtnBack.setVisibility(View.INVISIBLE);
        } else if (position == mPagerAdapter.getCount() - 1) {
            mBtnNext.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
