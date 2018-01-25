package com.kimdung.kimdungtronbo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimdung.kimdungtronbo.adapters.ReadingAdapter;
import com.kimdung.kimdungtronbo.models.Paragraph;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadingFragment extends Fragment implements ChapterListFragment.OnChangeContentReading {

    private static final String TAG = "MY_TAG_ReadingFragment";
    private  List<Paragraph> mListParagraph;
    private ReadingAdapter mReadingAdapter;
    public static RecyclerView mRecyclerViewContent;// public static đêr truy cập được từ Reading Activity

    public ReadingAdapter getReadingAdapter() {
        return mReadingAdapter;
    }

    public void setReadingAdapter(ReadingAdapter readingAdapter) {
        mReadingAdapter = readingAdapter;
    }

    public ReadingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_reading, container, false);
        mListParagraph = new ArrayList<>();
        mReadingAdapter = new ReadingAdapter(getContext(), mListParagraph);
        mRecyclerViewContent = (RecyclerView) v.findViewById(R.id.recycler_view_reading_content);
        mRecyclerViewContent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerViewContent.setAdapter(mReadingAdapter);
        return v;
    }


    public static ReadingFragment newInstance() {

        Bundle args = new Bundle();

        ReadingFragment fragment = new ReadingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void refresh(List<Paragraph> listParagraph) {
        // load lại nội dung chap mới
        mReadingAdapter.setListParagraph(listParagraph);
        mReadingAdapter.notifyDataSetChanged();
    }
}
