package com.example.tmd.androidmenuapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.tmd.androidmenuapp.MainActivity.isClickedNavigationBar;


/**
 * Created by tmd on 25/03/2017.
 */

public class MenuAppAdapter extends ArrayAdapter<AppItem> {

    Context context;
    int resource;
    List<AppItem> objects;

    private TextView mTextView;
    private ImageView mImageView;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = LayoutInflater.from(context).inflate(resource, parent, false);

        mTextView = (TextView) row.findViewById(R.id.text_view_name_app);
        mImageView = (ImageView) row.findViewById(R.id.image_avatar);

        AppItem item = objects.get(position);
        mTextView.setText(item.getName());

        mImageView.setImageResource(item.getImage());
        if (item.getName().equals("Close")) {
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(1);
                }
            });
        } else {
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isClickedNavigationBar) {
                        openCantExitActivity();
                    }
                }
            });

        }

        return row;
    }

    private void openCantExitActivity() {
        Intent intent = new Intent(context, CantExitAcctivity.class);
        context.startActivity(intent);

    }

    public MenuAppAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<AppItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
}
