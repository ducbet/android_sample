package com.example.tmd.phieu_khao_sat_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<VoteItem> mListVoteItems = new ArrayList<VoteItem>();
    private RecyclerView mRecyclerView;
    private VoteAdapter mVoteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        createDataForListVote();
        createRecyclerView();

    }

    private void createDataForListVote() {
        mListVoteItems.add(new VoteItem(R.drawable.cuong));
        mListVoteItems.add(new VoteItem(R.drawable.cuong));
        mListVoteItems.add(new VoteItem(R.drawable.cuong));
        mListVoteItems.add(new VoteItem(R.drawable.cuong));
    }

    private void createRecyclerView() {
        mVoteAdapter = new VoteAdapter(mListVoteItems);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mVoteAdapter);
    }

    private void addControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    }
}
