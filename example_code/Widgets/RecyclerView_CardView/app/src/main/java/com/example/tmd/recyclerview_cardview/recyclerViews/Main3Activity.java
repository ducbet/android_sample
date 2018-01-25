package com.example.tmd.recyclerview_cardview.recyclerViews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.tmd.recyclerview_cardview.R;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView mRecycler1, mRecycler2, mRecycler3;

    private ArrayList<ItemRecyclerView> mListItem;
    private ItemRecyclerViewAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        addControls();

        mListItem = new ArrayList<>();
        mItemAdapter = new ItemRecyclerViewAdapter(mListItem);

        setDataRecyclerView();

        mRecycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecycler3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        mRecycler1.setAdapter(mItemAdapter);
        mRecycler2.setAdapter(mItemAdapter);
        mRecycler3.setAdapter(mItemAdapter);

    }

    private void setDataRecyclerView() {
        for (int j = 0; j < 1000; j++) {
            mListItem.add(new ItemRecyclerView(R.mipmap.ic_launcher, "Chó Cương " + (j + 1)));
        }

    }

    private void addControls() {
        mRecycler1 = (RecyclerView) findViewById(R.id.recycler_view_section1);
        mRecycler2 = (RecyclerView) findViewById(R.id.recycler_view_section2);
        mRecycler3 = (RecyclerView) findViewById(R.id.recycler_view_section3);
    }
}
