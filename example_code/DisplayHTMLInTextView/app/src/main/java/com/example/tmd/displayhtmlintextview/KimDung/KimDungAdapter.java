package com.example.tmd.displayhtmlintextview.KimDung;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tmd.displayhtmlintextview.R;

import java.util.List;

/**
 * Created by tmd on 22/04/2017.
 */

public class KimDungAdapter extends RecyclerView.Adapter<KimDungAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mList;

    public KimDungAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = (String) mList.get(position);
        holder.blindData(item);
    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }

        public void blindData(String item) {
            mTextView.setText(item);
        }
    }
}
