package com.kimdung.kimdungtronbo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kimdung.kimdungtronbo.adapters.NovelListAdapter;
import com.kimdung.kimdungtronbo.database.DatabaseHelper;
import com.kimdung.kimdungtronbo.models.Novel;

import java.io.IOException;
import java.util.List;

import static com.kimdung.kimdungtronbo.Rule.Charcode.sortCharcode;

public class NovelsListActivity extends AppCompatActivity {

    private static final String TAG = "MY_TAG_NovelsListActivity";

    private RecyclerView mRecyclerViewNovelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTittleBar();
        setContentView(R.layout.activity_novels_list);

        //
        Thread.currentThread().setName("NovelsListActivity");// để tiện debug
//        Log.d(TAG, "MyThread running: " + Thread.currentThread().getName());

        // copy database
        try {
            DatabaseHelper.copyDataBase(this);
        } catch (IOException e) {
        }

        // phải sort charcode không thì k check mistake được
        sortCharcode();

        // lay tham chieu
        mRecyclerViewNovelList = (RecyclerView) findViewById(R.id.recycler_view_novel_list);

        // do du lieu vao recycler view
        mRecyclerViewNovelList.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHelper helper = new DatabaseHelper(this);
        List<Novel> novelList = helper.getNovelList();
        NovelListAdapter novelListAdapter = new NovelListAdapter(novelList, this);
        mRecyclerViewNovelList.setAdapter(novelListAdapter);
    }

    public void removeTittleBar() {
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);
        getSupportActionBar().hide();//hide Title Bar (tên application)

    }
}
