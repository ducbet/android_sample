package com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.FriendSuggest_RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmd.newfeed_facebook.R;

import java.util.List;

/**
 * Created by tmd on 31/03/2017.
 */
public class FriendSuggestAdapter extends RecyclerView.Adapter<FriendSuggestAdapter.ViewHolder> {
    private List<ItemFriendSuggest> mList;
    private int mRealListSize;
    private int LARGR_NUMBER = 1000;

    public FriendSuggestAdapter(List<ItemFriendSuggest> list) {
        mList = list;
        if (list != null) {
            mRealListSize = list.size();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_friend_suggest, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemFriendSuggest itemFriendSuggest = mList.get(position % mRealListSize);
        holder.blindData(itemFriendSuggest);
    }

    @Override
    public int getItemCount() {
        if (mList != null) return LARGR_NUMBER;
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mAvatar;
        private TextView mName;
        private TextView mNumMatualFriends;

        public ViewHolder(View itemView) {
            super(itemView);
            mAvatar = (ImageView) itemView.findViewById(R.id.image_view_avatar);
            mName = (TextView) itemView.findViewById(R.id.text_view_name);
            mNumMatualFriends = (TextView) itemView.findViewById(R.id.text_view_mutual_friends);
        }

        public void blindData(ItemFriendSuggest item) {
            mAvatar.setImageResource(item.getAvatar());
            mName.setText(item.getName());
            if (item.getNumMutualFriends() != 0) {
                mNumMatualFriends.setText(item.getNumMutualFriends() + " mutual friends");
            }
        }
    }
}
