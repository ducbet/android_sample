package com.kimdung.kimdungtronbo.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kimdung.kimdungtronbo.ChapterListFragment;
import com.kimdung.kimdungtronbo.R;
import com.kimdung.kimdungtronbo.ReadingActivity;
import com.kimdung.kimdungtronbo.models.Chapter;

import java.util.List;

/**
 * Created by Admin on 28/4/2017.
 */

public class ChapterListAdapter extends RecyclerView.Adapter<ChapterListAdapter.ViewHolder> {

    private static final String TAG = "MY_TAG_ChapterListAdapter";
    List<Chapter> mChapterList;
    ChapterListFragment.OnChangeContentReading mOnChangeContentReading;
    ChapterListFragment.OnJumpToReadingFragment mOnJumpToReadingFragment;

    public List<Chapter> getChapterList() {
        return mChapterList;
    }

    public void setOnChangeContentReading(ChapterListFragment.OnChangeContentReading onChangeContentReading) {
        mOnChangeContentReading = onChangeContentReading;
    }


    public void setOnJumpToReadingFragment(ChapterListFragment.OnJumpToReadingFragment onJumpToReadingFragment) {
        mOnJumpToReadingFragment = onJumpToReadingFragment;
    }

    public ChapterListAdapter(List<Chapter> chapterList, ChapterListFragment.OnChangeContentReading onChangeContentReading) {
        mChapterList = chapterList;
        mOnChangeContentReading = onChangeContentReading;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_chapter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chapter chapter = mChapterList.get(position);
        holder.bindData(chapter);
    }

    public void updateReadingFragment(Chapter chapter) {
        if (mOnChangeContentReading != null)
            mOnChangeContentReading.refresh(chapter.getListParagraphs());
        if (mOnJumpToReadingFragment != null)
            mOnJumpToReadingFragment.jump();
    }

    @Override
    public int getItemCount() {
        return mChapterList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewDeName;
        private TextView mTextViewDeDate;
        private Chapter mChapter;
        private LinearLayout mLinearLayoutBackground;
        private CardView mCardViewBackground;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewDeName = (TextView) itemView.findViewById(R.id.text_view_dename);
            mTextViewDeDate = (TextView) itemView.findViewById(R.id.text_view_dedate);
            mLinearLayoutBackground = (LinearLayout) itemView.findViewById(R.id.view_background);
            mCardViewBackground = (CardView) itemView.findViewById(R.id.card_background);
        }

        public void bindData(final Chapter chapter) {
            mChapter = chapter;

            mTextViewDeName.setText(chapter.getDeName());
            // TODO: 08/05/2017  
            if (chapter.getResultSearchContent() == null) {
//                Log.d(TAG, "bindData: getResultSearchContent: null");
                mTextViewDeDate.setText(chapter.getStringDeDate());
                mCardViewBackground.setCardBackgroundColor(Color.WHITE);
            } else if (chapter.getResultSearchContent().equals("")) {
//                Log.d(TAG, "bindData: getResultSearchContent: empty");
                mTextViewDeDate.setText(chapter.getStringDeDate());
                mCardViewBackground.setCardBackgroundColor(Color.parseColor("#FFCDD2"));
            } else {
//                Log.d(TAG, "bindData: getResultSearchContent: " + chapter.getResultSearchContent());
                mTextViewDeDate.setText(chapter.getResultSearchContent());
                mCardViewBackground.setCardBackgroundColor(Color.parseColor("#8BC34A"));
            }
            itemView.setOnClickListener(    new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateCurrentChapter();
//                    Log.d(TAG, "onClick in thread: " + Thread.currentThread().getName());
                    if (mOnChangeContentReading != null)
                        mOnChangeContentReading.refresh(chapter.getListParagraphs());
                    if (mOnJumpToReadingFragment != null)
                        mOnJumpToReadingFragment.jump();
                }
            });
        }

        public void updateCurrentChapter() {
            for (int i = 0; i < mChapterList.size(); i++) {
                if (mChapterList.get(i) == mChapter) {
//                    Log.d(TAG, "updateCurrentChapter: " + i);
                    ReadingActivity.mCurrentChap = i;
                    return;
                }
            }
        }
    }

    public void resetHighlight() {
        // TODO: 08/05/2017
        for (Chapter chapter : mChapterList) {
            chapter.setResultSearchContent(null);
            notifyDataSetChanged();
        }
    }
}
