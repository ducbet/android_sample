package com.example.tmd.googlemap.SavedPlaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tmd.googlemap.R;

import java.util.ArrayList;
import java.util.Collections;

public class ListPlaces extends AppCompatActivity {

    private ArrayList<Place> mList;
    private ListPlacesAdapter mListPlacesAdapter;
    private RecyclerView mRevListPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_places);

        addControls();
    }

    private void addControls() {
        mList = new ArrayList<Place>();
        mRevListPlaces = (RecyclerView) findViewById(R.id.recycler_view_list_places);

        createListPlaces();
        mListPlacesAdapter = new ListPlacesAdapter(this, mList);
        mRevListPlaces.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRevListPlaces.setAdapter(mListPlacesAdapter);
    }

    private void createListPlaces() {
        mList.add(new Place("Nhà riêng", R.drawable.home, 21.044449, 105.851097));
        mList.add(new Place("Trường THPT Nguyễn Trãi", R.drawable.thpt_nguyen_trai, 21.029496, 105.822263));
        mList.add(new Place("Trường Đại học Bách khoa Hà Nội", R.drawable.bach_khoa, 21.005568, 105.843369));

        mList.add(new Place("Lăng Chủ tịch Hồ Chí Minh", R.drawable.lang_bac, 21.036727, 105.834635));
        mList.add(new Place("Times Square", R.drawable.times_square, 40.758879, -73.985099));
        mList.add(new Place("Las Vegas", R.drawable.las_vegas, 36.200067, -115.236846));
        mList.add(new Place("Tokyo Disneyland", R.drawable.tokyo_disneyland, 35.632870, 139.880384));
        mList.add(new Place("Sơn Đoòng", R.drawable.son_doong, 17.543116, 106.144849));

        mList.add(new Place("Hồ Hoàn Kiếm", R.drawable.ho_guom, 21.028975, 105.852193));
        mList.add(new Place("Tháp Eiffel", R.drawable.eiffel, 48.858369, 2.294506));
        mList.add(new Place("Tháp Nghiêng Pisa", R.drawable.pisa, 43.722950, 10.396597));
        Collections.sort(mList);
    }
}
