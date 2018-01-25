package com.example.tmd.phieu_khao_sat_example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by tmd on 30/03/2017.
 */

public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.ViewHolder> {

    private List<VoteItem> mItems;

    public VoteAdapter(List<VoteItem> items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_vote, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VoteItem item = mItems.get(position);
        holder.blindData(item);
    }

    @Override
    public int getItemCount() {
        if (mItems != null) return mItems.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImgSmall, mImgLarge, mImgDelImage, mImgDelRow;
        private EditText mEdtContent;

        public ViewHolder(View itemView) {
            super(itemView);

            mImgSmall = (ImageView) itemView.findViewById(R.id.image_view_small);
            mImgLarge = (ImageView) itemView.findViewById(R.id.image_view_large);
            mImgDelImage = (ImageView) itemView.findViewById(R.id.image_view_del_image);
            mImgDelRow = (ImageView) itemView.findViewById(R.id.image_view_del_row);
            mEdtContent = (EditText) itemView.findViewById(R.id.edit_text_content);

            mEdtContent.setOnClickListener(this);

            itemView.findViewById(R.id.image_view_small).setOnClickListener(this);
            itemView.findViewById(R.id.image_view_del_image).setOnClickListener(this);
            itemView.findViewById(R.id.image_view_del_row).setOnClickListener(this);
        }

        public void blindData(VoteItem item) {
            mEdtContent.setText(item.getContent());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_view_small:
                    // show large, del image
                    mImgLarge.setVisibility(View.VISIBLE);
                    mImgDelImage.setVisibility(View.VISIBLE);
                    break;
                case R.id.image_view_del_image:
                    // gone large, del image
                    mImgLarge.setVisibility(View.GONE);
                    mImgDelImage.setVisibility(View.GONE);
                    // gone small
                    mImgSmall.setVisibility(View.VISIBLE);
                    break;
                case R.id.image_view_del_row:
                    delRow();
                    break;
                case R.id.edit_text_content:
                    addRow();
                    break;
                default:

            }
        }

        private void addRow() {
            if (getAdapterPosition() == getItemCount() - 1) {
                mItems.add(new VoteItem(R.drawable.cuong));
//                notifyDataSetChanged(); // kiểm tra lại toàn bộ
                notifyItemInserted(getItemCount()); // thông báo là chỉ thêm 1 phần tử (có xđ vị trí)
            }


        }

        private void delRow() {
            mItems.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());

        }
    }


}
