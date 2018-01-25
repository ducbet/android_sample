package com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.FriendSuggest_RecyclerView.FriendSuggestAdapter;
import com.example.tmd.newfeed_facebook.NewFeed.NewFeed_RecyclerView.FriendSuggest_RecyclerView.ItemFriendSuggest;
import com.example.tmd.newfeed_facebook.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.tmd.newfeed_facebook.MainActivity.sdfDate;
import static com.example.tmd.newfeed_facebook.MainActivity.sdfHour;

/**
 * Created by tmd on 30/03/2017.
 */

public class NewFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int ITEM_TYPE_NONE = 0;
    private final int ITEM_TYPE_1 = 1; // ItemNewFeed
    private final int ITEM_TYPE_2 = 2; // ItemFriendSuggest
    private final int ITEM_TYPE_3 = 3; // ItemPostStatus
    private final int ITEM_TYPE_4 = 4; // ItemLoading

    private List mList;
    private Context mContext;

    public NewFeedAdapter(List list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof ItemStatus) {
            return ITEM_TYPE_1;
        } else if (mList.get(position) instanceof ArrayList &&
                ((ArrayList) mList.get(position)).get(0) instanceof ItemFriendSuggest) {
            return ITEM_TYPE_2;
        } else if (mList.get(position) instanceof ItemPostStatus) {
            return ITEM_TYPE_3;
        } else if (mList.get(position) instanceof ItemLoading) {
            return ITEM_TYPE_4;
        } else {
            return ITEM_TYPE_NONE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case ITEM_TYPE_1:// ItemNewFeed
                v = LayoutInflater.from(mContext).inflate(R.layout.item_new_feed, parent, false);
                return new ViewHolder1(v);
            case ITEM_TYPE_2:// ItemFriendSuggest
                v = LayoutInflater.from(mContext).inflate(R.layout.item_list_friend_suggest, parent, false);
                return new ViewHolder2(v);
            case ITEM_TYPE_3:// ItemPostStatus
                v = LayoutInflater.from(mContext).inflate(R.layout.item_post_status, parent, false);
                return new ViewHolder3(v);
            case ITEM_TYPE_4:// ItemLoading
                v = LayoutInflater.from(mContext).inflate(R.layout.item_loading, parent, false);
                return new ViewHolder4(v);
            default:
                Toast.makeText(mContext, "ITEM ERROR", Toast.LENGTH_LONG).show();
                System.exit(1);
        }
        return null;// khong bao gio xay ra
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case ITEM_TYPE_1:// ItemNewFeed
                ((ViewHolder1) holder).blindData(mList.get(position));
                break;
            case ITEM_TYPE_2:// ItemFriendSuggest
                ((ViewHolder2) holder).blindData(mList.get(position));
                break;
            case ITEM_TYPE_3:// ItemPostStatus
                ((ViewHolder3) holder).blindData(mList.get(position));
                break;
            case ITEM_TYPE_4:// ItemLoading
                if (position == 0) {
                    ((ViewHolder4) holder).blindData(mList.get(position));
                }
                break;
            default:
                Toast.makeText(mContext, "ITEM ERROR", Toast.LENGTH_LONG).show();
                System.exit(1);
        }
    }


    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public class ViewHolder4 extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolder4(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        }

        public void blindData(final Object o) {
        }

        @Override
        public void onClick(View v) {

        }
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {

        private ImageView mAvatar;

        public ViewHolder3(View itemView) {
            super(itemView);
            mAvatar = (ImageView) itemView.findViewById(R.id.image_view_avatar);
        }


        public void blindData(Object o) {
            ItemPostStatus item = (ItemPostStatus) o;
            mAvatar.setImageResource(item.getAvatar());
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private RecyclerView mRecyclerView;
        private FriendSuggestAdapter mAdapter;

        public ViewHolder2(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_list_friend_suggest);
        }

        public void blindData(Object o) {
            List<ItemFriendSuggest> listFriendSuggest = (ArrayList<ItemFriendSuggest>) o;
            mAdapter = new FriendSuggestAdapter(listFriendSuggest);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private ImageView mAvatar;
        private TextView mName;
        private TextView mTimeCreate;
        private ImageView mModifier;
        private TextView mContent;
        private ImageView mImgContent;
        private TextView mNumLikes;
        private TextView mNumComments;
        private TextView mNumShares;
        private TextView mNumViews;

        public ViewHolder1(View itemView) {
            super(itemView);
            mAvatar = (ImageView) itemView.findViewById(R.id.image_view_avatar_account_up_status);
            mName = (TextView) itemView.findViewById(R.id.text_view_name_account_up_status);
            mTimeCreate = (TextView) itemView.findViewById(R.id.text_view_time_up_status);
            mModifier = (ImageView) itemView.findViewById(R.id.image_view_modifier);
            mContent = (TextView) itemView.findViewById(R.id.text_view_content);
            mImgContent = (ImageView) itemView.findViewById(R.id.image_view_img_content);
            mNumLikes = (TextView) itemView.findViewById(R.id.text_view_number_of_like);
            mNumComments = (TextView) itemView.findViewById(R.id.text_view_number_of_comments);
            mNumShares = (TextView) itemView.findViewById(R.id.text_view_number_of_shares);
            mNumViews = (TextView) itemView.findViewById(R.id.text_view_number_of_views);
        }


        public void blindData(Object o) {
            ItemStatus item = (ItemStatus) o;
            mAvatar.setImageResource(item.getAvatar());
            mName.setText(item.getName());
            mTimeCreate.setText(sdfDate.format(item.getTimeCreate()) + " at " + sdfHour.format(item.getTimeCreate()));
            mModifier.setImageResource(item.getModifier());
            if (item.getContent().toString().equals("")) {
                mContent.setVisibility(View.GONE);
            } else {
                mContent.setVisibility(View.VISIBLE);
                mContent.setText(item.getContent());
            }
            if (item.getImgContent() != 0) {
                mImgContent.setVisibility(View.VISIBLE);
                mImgContent.setImageResource(item.getImgContent());
            } else {
                mImgContent.setVisibility(View.GONE);
            }
            if (item.getNumLikes() != 0) {
                mNumLikes.setText(item.getNumLikes() + "");
            }
            if (item.getNumComments() != 0) {
                mNumComments.setText(item.getNumComments() + " Comments ");
            }
            if (item.getNumShares() != 0) {
                mNumShares.setText(item.getNumShares() + " Shares ");
            }
            if (item.getNumViews() != 0) {
                mNumViews.setText(item.getNumViews() + " Views ");
            }

        }
    }
}
