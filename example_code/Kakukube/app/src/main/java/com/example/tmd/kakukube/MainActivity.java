package com.example.tmd.kakukube;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.kakukube.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static TextView mTxtLevel;
    public static RecyclerView mRecyclerView;
    public static KakukubeAdapter mKakukubeAdapter;
    public static LevelKakukube mLevel;
    public static boolean LOSE = false;

    private ProgressBar mProgressBar;
    public static final int MAX_PROGRESS = 3000;
    public static int mDecreaseProgress = 50;
    public static int mProgress = MAX_PROGRESS;

    public static CountDownTimer countDownTimer;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        mLevel = new LevelKakukube(this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, mLevel.getItemPerRow()));

        mKakukubeAdapter = new KakukubeAdapter(this, mLevel.getArrayItem());
        mRecyclerView.setAdapter(mKakukubeAdapter);

        countDownTimer = new CountDownTimer(MAX_PROGRESS, mDecreaseProgress) {

            @Override
            public void onTick(long millisUntilFinished) {
                mProgressBar.setProgress(mProgress);
                mProgress -= mDecreaseProgress;
            }

            @Override
            public void onFinish() {
                mProgress = 0;
                mProgressBar.setProgress(mProgress);
                Toast.makeText(MainActivity.this, "TIME OVER", Toast.LENGTH_LONG).show();
                LOSE = true;
            }
        }.start();
    }

    private void addControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_kakukube);
        mTxtLevel = (TextView) findViewById(R.id.text_view_level);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mProgressBar.setMax(MAX_PROGRESS);
        mProgressBar.setProgress(MAX_PROGRESS);
    }

}
