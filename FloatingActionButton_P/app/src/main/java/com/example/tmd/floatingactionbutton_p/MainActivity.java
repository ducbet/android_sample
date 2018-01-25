package com.example.tmd.floatingactionbutton_p;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Paragraph> mListParagraph;
    private RecyclerViewAdapter mReadingAdapter;
    private RecyclerView mRecyclerViewContent;
    private FloatingActionButton mFabAdd, mFabNext, mFabPrevious, mFabSearch;
    private Animation mShowFrameLayoutAnimation, mHideFrameLayoutAnimation;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

        mListParagraph = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            mListParagraph.add(new Paragraph(""));
        }
        mReadingAdapter = new RecyclerViewAdapter(this, mListParagraph);
        mRecyclerViewContent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewContent.setAdapter(mReadingAdapter);

    }

    private void addEvents() {
        mFabAdd.setOnClickListener(this);
        mFabNext.setOnClickListener(this);
        mFabPrevious.setOnClickListener(this);
        mFabSearch.setOnClickListener(this);

        hideFab();// hide luon // phai dat sau setOnClickListener
//        Log.d("TAG", "addControls: mFabSearch.isClickable()" + mFabSearch.isClickable());
    }

    private void addControls() {
            mFabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
            mFabNext = (FloatingActionButton) findViewById(R.id.fab_next);
            mFabPrevious = (FloatingActionButton) findViewById(R.id.fab_previous);
            mFabSearch = (FloatingActionButton) findViewById(R.id.fab_search);

        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout_fab);

        mRecyclerViewContent = (RecyclerView) findViewById(R.id.recycler_view_reading_content);

        mShowFrameLayoutAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_frame_fab_rotate_show);
//        mShowFrameLayoutAnimation.setInterpolator(new BounceInterpolator());
        mHideFrameLayoutAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_frame_fab_rotate_hide);


    }

    @Override
    public void onClick(View v) {
//        Log.d("TAG", "onClick: mFabSearch.isClickable()" + mFabSearch.isClickable());
        if (mFabSearch.isClickable()) {
            hideFab();
        } else {
            showMoreFab();
        }
    }

    private void hideFab() {
        mFrameLayout.startAnimation(mHideFrameLayoutAnimation);
        mFabAdd.setImageResource(R.drawable.ic_add_white_24px);
        mFabSearch.setClickable(false);
        mFabNext.setClickable(false);
        mFabPrevious.setClickable(false);
    }

    private void showMoreFab() {
        mFabSearch.setClickable(true);
        mFabNext.setClickable(true);
        mFabPrevious.setClickable(true);
        mFabAdd.setImageResource(R.drawable.ic_remove_white_24px);
        mFrameLayout.startAnimation(mShowFrameLayoutAnimation);
    }
}
