package com.example.tmd.recyclerview_cardview.recyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.recyclerview_cardview.R;

import java.util.List;

/**
 * Created by tmd on 23/03/2017.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    private List<ItemRecyclerView> mItemApp;

    public ItemRecyclerViewAdapter(List<ItemRecyclerView> itemApp) {
        this.mItemApp = itemApp;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemRecyclerView item = mItemApp.get(position);
        holder.blind(item);
    }

    @Override
    public int getItemCount() {
        if (mItemApp.size() != 0) {
            return mItemApp.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTxtNameApp;
        private ImageView mImgAvatar, mImgTmp;

        public ViewHolder(View item) {
            super(item);

            mImgAvatar = (ImageView) item.findViewById(R.id.image_avatar);
            mTxtNameApp = (TextView) item.findViewById(R.id.text_view_name_app);
            item.setOnClickListener(this);
        }

        public void blind(ItemRecyclerView item) {

            mImgAvatar.setImageResource(item.getImage());
            mTxtNameApp.setText(item.getNameApp());

        }

        @Override
        public void onClick(View v) {
            ItemRecyclerView item = mItemApp.get(getAdapterPosition());
            Toast.makeText(v.getContext(), item.getNameApp(), Toast.LENGTH_SHORT).show();

            mImgAvatar.setImageResource(R.drawable.cuong);
        }
    }
}


