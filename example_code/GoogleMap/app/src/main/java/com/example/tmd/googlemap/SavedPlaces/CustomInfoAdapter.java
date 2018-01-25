package com.example.tmd.googlemap.SavedPlaces;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmd.googlemap.R;
import com.example.tmd.googlemap.SavedPlaces.Place;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by tmd on 08/04/2017.
 */

public class CustomInfoAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity mContext;
    private Place mPlace;

    public CustomInfoAdapter(Activity context, Place place) {
        mContext = context;
        mPlace = place;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        //        LayoutInflater inflater = mContext.getLayoutInflater();// C1
        LayoutInflater inflater = LayoutInflater.from(mContext);// C2
        View v = inflater.inflate(R.layout.item_info_place_show_in_map, null);
        ImageView mImgPlace = (ImageView) v.findViewById(R.id.image_view_place);
        TextView mTxtPlace = (TextView) v.findViewById(R.id.text_view_place);
        mImgPlace.setImageResource(mPlace.getImage());
        mTxtPlace.setText(mPlace.getName());
        return v;

    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
