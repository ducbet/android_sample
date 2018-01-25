package com.example.tmd.googlemap.SavedPlaces;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmd.googlemap.MapsActivity;
import com.example.tmd.googlemap.R;

import java.util.ArrayList;

/**
 * Created by tmd on 08/04/2017.
 */

public class ListPlacesAdapter extends RecyclerView.Adapter<ListPlacesAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Place> mList;

    public ListPlacesAdapter(Context context, ArrayList<Place> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_info_place_recycler_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = mList.get(position);
        holder.blindData(place);
    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImgPlace;
        private TextView mTxtPlace;
        private Place mPlace;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgPlace = (ImageView) itemView.findViewById(R.id.image_view_place);
            mTxtPlace = (TextView) itemView.findViewById(R.id.text_view_place);
            itemView.setOnClickListener(this);
        }

        public void blindData(Place place) {
            mPlace = place;
            mTxtPlace.setText(place.getName());
            mImgPlace.setImageResource(place.getImage());
        }

        @Override
        public void onClick(View v) {
            System.out.println(mContext.toString());
            Intent intent = new Intent(mContext, MapsActivity.class);
            intent.putExtra("PLACE", mPlace);
            mContext.startActivity(intent);
        }
    }
}
