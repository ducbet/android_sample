package com.example.tmd.loadimage.LoadAllImage;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tmd.loadimage.R;

import java.util.List;

/**
 * Created by tmd on 21/04/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context mContext;
    private List<MyImage> mList;

    public ImageAdapter(Context context, List<MyImage> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyImage item = mList.get(position);
        holder.blindData(item);
    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private String imagePath;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(this);
        }

        public void blindData(MyImage item) {
            imagePath = item.getImagePath();
//            System.out.println(imageName);
            Glide.with(mContext)
                    .load(imagePath)
                    .error(R.drawable.error)// load anh nay neu download loi
                    .placeholder(R.drawable.wait)// cac anh hien thi trong luc dang download
                    .into(mImageView);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ShowImage.class);
            intent.putExtra("IMAGE_PATH", imagePath);
            v.getContext().startActivity(intent);
        }
    }
}
