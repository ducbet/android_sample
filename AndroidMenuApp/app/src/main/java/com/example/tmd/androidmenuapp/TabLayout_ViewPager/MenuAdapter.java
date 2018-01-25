package com.example.tmd.androidmenuapp.TabLayout_ViewPager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.androidmenuapp.AppItem;
import com.example.tmd.androidmenuapp.CantExitAcctivity;
import com.example.tmd.androidmenuapp.R;

import java.util.List;

import static com.example.tmd.androidmenuapp.TabLayout_ViewPager.Main2Activity.isClickedNavigationBar;


/**
 * Created by tmd on 29/03/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {


    private Context mContext;
    private int mResource;
    private List<AppItem> mAppItems;

    public MenuAdapter(Context context, int resource, List<AppItem> appItems) {
        mContext = context;
        mResource = resource;
        mAppItems = appItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppItem item = mAppItems.get(position);
        holder.blindData(item);
    }


    @Override
    public int getItemCount() {
        if (mAppItems != null) {
//            System.out.println("printf " + mAppItems.size() + " item");
            return mAppItems.size();
        } else {
            System.out.println("mAppItems null");
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageView;
        private View mView;

        public void blindData(AppItem item) {
            mTextView.setText(item.getName());
            mImageView.setImageResource(item.getImage());
            if (item.getName().equals("Close")) {
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(1);
                    }
                });
            } else {
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isClickedNavigationBar) {
                            openCantExitActivity();
                        }
                    }
                });

            }
        }

        private void openCantExitActivity() {
            Intent intent = new Intent(mContext, CantExitAcctivity.class);
            mContext.startActivity(intent);

        }

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.image_avatar);
            mTextView = (TextView) itemView.findViewById(R.id.text_view_name_app);
        }
    }
}
