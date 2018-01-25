package com.example.tmd.recyclerview_cardview.listAppPlayStore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tmd.recyclerview_cardview.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    /*
        - Phải add thêm thư viện

    */

    private RecyclerView mRecyclerStore;
    private StoreAdapter mAdapter;
    private ArrayList mAppItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecyclerStore  = (RecyclerView) findViewById(R.id.recycler_stores);

        // 1. Set layout manager
        mRecyclerStore.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // 2. Set adapter
        mAppItems = new ArrayList();
        mAppItems.add(new AppItem(R.drawable.zalo, "1. Zalo: Nhắn gửi yêu thương", "VNG Online", 4.5f, R.mipmap.ic_launcher, "ĐÃ CÀI ĐẶT"));
        mAppItems.add(new AppItem(R.drawable.zing, "2. Zing MP3", "Media MobleLaps", 2.5f, 0, "MIỄN PHÍ"));
        mAppItems.add(new AppItem(R.drawable.messenger, "3. Messenger", "Facebook", 3.3f, R.mipmap.ic_launcher, "ĐÃ CÀI ĐẶT"));
        mAppItems.add(new AppItem(R.drawable.facebook, "4. Facebook", "Facebook", 4.2f, R.mipmap.ic_launcher, "CẬP NHẬT"));
        mAppItems.add(new AppItem(R.drawable.clean_master, "5. Clean Master", "Cheetah Mobile", 2.1f, R.mipmap.ic_launcher, "CẬP NHẬT"));
        mAppItems.add(new AppItem(R.drawable.candy_crush, "6. Candy Crush Saga", "VNG Online", 4.6f, R.mipmap.ic_launcher, "CẬP NHẬT"));
        mAppItems.add(new AppItem(R.drawable.clear, "7. NoName", "NoName", 0, 0, "MIỄN PHÍ"));
        mAppItems.add(new AppItem(R.drawable.clear, "8. NoName", "NoName", 0, 0, "MIỄN PHÍ"));
        mAppItems.add(new AppItem(R.drawable.clear, "9. NoName", "NoName", 0, 0, "MIỄN PHÍ"));

        mAdapter = new StoreAdapter(mAppItems);

        // 3. set adapter cho recycler view
        mRecyclerStore.setAdapter(mAdapter);

    }

}

