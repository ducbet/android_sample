package com.example.tmd.recyclerview_cardview.listAppPlayStore;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tmd.recyclerview_cardview.R;

import java.util.List;

/**
 * Created by tmd on 21/03/2017.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private List<AppItem> mAppItems;

    public StoreAdapter(List<AppItem> mAppItems) {
        this.mAppItems = mAppItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Hàm cho phép tạo ra 1 view mới
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store_vertical, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // TODO: 21/03/2017 fill data to recyclerView
        // lấy ra object tai vi tri thu positon
        AppItem item = mAppItems.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        //return số lượng item có trong recyclerView
        if (mAppItems != null) {
            return mAppItems.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextTitle, mTxtStatus, mTxtNSX;
        private ImageView mImageAvatar, mImgStatus;
        private RatingBar mRatingBar;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            mTxtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
            mTxtNSX = (TextView) itemView.findViewById(R.id.txtNSX);
            mImageAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            mImgStatus = (ImageView) itemView.findViewById(R.id.imgStatus);
            mRatingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }

        public void bindData(AppItem item) {
            mTextTitle.setText(item.getmTitle());
            mImageAvatar.setImageResource(item.getmImageAvatar());
            mTxtNSX.setText(item.getmNSX());
            mTxtStatus.setText(item.getmTxtStatus());
            mImgStatus.setImageResource(item.getmImageStatus());
            mRatingBar.setRating(item.getmRating());
        }
    }
}
