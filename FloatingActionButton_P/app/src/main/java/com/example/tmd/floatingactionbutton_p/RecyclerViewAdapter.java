package com.example.tmd.floatingactionbutton_p;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by tmd on 02/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHoler> {

    private Context mContext;
    private List<Paragraph> mListParagraph;

    public RecyclerViewAdapter(Context context, List<Paragraph> listParagraph) {
        mContext = context;
        mListParagraph = listParagraph;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_row_paragraph, parent, false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        Paragraph paragraph = mListParagraph.get(position);
        holder.blindData(paragraph);
    }

    @Override
    public int getItemCount() {
        if (mListParagraph != null) return mListParagraph.size();
        return 0;
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public ViewHoler(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }

        public void blindData(Paragraph paragraph) {
            mTextView.setText(getAdapterPosition() + "");
        }
    }
}
