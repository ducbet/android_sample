package com.kimdung.kimdungtronbo;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimdung.kimdungtronbo.Rule.CheckMistakeInBackGround;
import com.kimdung.kimdungtronbo.adapters.ChapterListAdapter;
import com.kimdung.kimdungtronbo.database.DatabaseHelper;
import com.kimdung.kimdungtronbo.database.LoadChapterInBackGround;
import com.kimdung.kimdungtronbo.models.Novel;
import com.kimdung.kimdungtronbo.models.Paragraph;

import java.util.List;

import static com.kimdung.kimdungtronbo.ReadingActivity.mLoadChapterInBackGround;
import static com.kimdung.kimdungtronbo.ReadingActivity.sMCheckMistakeInBackGround;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChapterListFragment extends Fragment {

    //    public final static String EXTRA_ST_ID = "stId";
    public final static String EXTRA_NOVEL = "novel";
    private static final String TAG = "TAG_ChapterListFragment";

    private RecyclerView mRecyclerViewChapterList;
    private DatabaseHelper mDatabaseHelper;
    private ChapterListAdapter mAdapter;

    private Novel mNovel;

    public ChapterListAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(ChapterListAdapter adapter) {
        mAdapter = adapter;
    }

    OnChangeContentReading mOnChangeContentReading;
    OnJumpToReadingFragment mOnJumpToReadingFragment;

    public void setOnChangeContentReading(OnChangeContentReading onChangeContentReading) {
        mOnChangeContentReading = onChangeContentReading;
    }

    public void setOnJumpToReadingFragment(OnJumpToReadingFragment onJumpToReadingFragment) {
        mOnJumpToReadingFragment = onJumpToReadingFragment;
    }

    public ChapterListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mDatabaseHelper = new DatabaseHelper(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNovel = (Novel) getArguments().getSerializable(EXTRA_NOVEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chapter_list, container, false);
        // lay tham chieu recycler view chapter list
        mRecyclerViewChapterList = (RecyclerView) v.findViewById(R.id.recycler_view_chapter_list);
        mRecyclerViewChapterList.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        // do du lieu vao adapter
//        mDatabaseHelper.getChaptersOfANovel(mNovel); // get chapter trong asyntask
        mAdapter = new ChapterListAdapter(mNovel.getListChapters(), mOnChangeContentReading);
        mLoadChapterInBackGround = (LoadChapterInBackGround) new LoadChapterInBackGround().execute(mNovel, mAdapter, getContext());
        mAdapter.setOnJumpToReadingFragment(mOnJumpToReadingFragment);
        mRecyclerViewChapterList.setAdapter(mAdapter);
    }

    public static ChapterListFragment newInstance(Novel novel) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_NOVEL, novel);

        ChapterListFragment fragment = new ChapterListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnChangeContentReading {
        public void refresh(List<Paragraph> listParagraph);
    }

    public interface OnJumpToReadingFragment {
        public void jump();
    }
}
