package com.example.tmd.fragment_p;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements QuestionFragment.OnSendResult{

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<QuestionFragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (ViewPager) findViewById(R.id.view_pager_question);

        // Khoi tao list fragment
        mFragments = new ArrayList<QuestionFragment>();
        for (int i = 0; i < 10; i++) {
            mFragments.add(QuestionFragment.newInstance(i));
        }

        // Khoi tao Adapter
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);

        // Gan Adapter cho ViewPager
        mViewPager.setAdapter(mPagerAdapter);



    }

    @Override
    public void sendResult(int result) {

    }
}
