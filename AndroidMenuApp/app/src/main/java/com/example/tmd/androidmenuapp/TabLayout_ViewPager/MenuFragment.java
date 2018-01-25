package com.example.tmd.androidmenuapp.TabLayout_ViewPager;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tmd.androidmenuapp.AppItem;
import com.example.tmd.androidmenuapp.MenuAppAdapter;
import com.example.tmd.androidmenuapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private List<AppItem> mAppItems;
    private Context mContext;

    private RecyclerView mRecyclerView;
    private MenuAdapter mMenuAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void createData() {
        mMenuAdapter = new MenuAdapter(mContext, R.layout.item_recycler_view, mAppItems);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 5));
        mRecyclerView.setAdapter(mMenuAdapter);
    }


    public MenuFragment() {
        // Required empty public constructor
    }

    public MenuFragment(Context context, List<AppItem> appItems) {
        mAppItems = appItems;
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_menu);
        createData();

        return v;
    }

}
