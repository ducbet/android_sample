package com.example.tmd.newfeed_facebook.NewFeed;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.ItemLoading;
import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.NewFeedAdapter;
import com.example.tmd.newfeed_facebook.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFeedFragment extends Fragment {

    private List mList;
    private Context mContext;

    @SuppressLint("ValidFragment")
    public NewFeedFragment(List list, Context context) {
        mList = list;
        mContext = context;
    }

    private RecyclerView mRecyclerView;
    private NewFeedAdapter mNewFeedAdapter;

    public NewFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_feed, container, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            addRecyclerView(v);
        }
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void addRecyclerView(View v) {
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_new_feed);
        mNewFeedAdapter = new NewFeedAdapter(mList, mContext);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mNewFeedAdapter);
//        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                System.out.println("recyclerView.getScrollY()" + recyclerView.getScrollY());
//                    mList.add(0, new ItemLoading());
//                    mNewFeedAdapter.notifyItemInserted(0);
//                    mRecyclerView.getLayoutManager().scrollToPosition(0);
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mList.remove(0);
//                            mNewFeedAdapter.notifyItemRemoved(0);
//                        }
//                    }, 2000);
//                }
//            }
//        });
    }

}
