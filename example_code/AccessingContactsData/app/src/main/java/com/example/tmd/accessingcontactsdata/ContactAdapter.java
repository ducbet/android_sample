package com.example.tmd.accessingcontactsdata;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by tmd on 16/04/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> mList;
    private Context mContext;

    public ContactAdapter(ArrayList<Contact> list, Context context) {
        mList = list;
        mContext = context;
    }

    public void add(Contact c) {
        mList.add(c);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_info, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact item = mList.get(position);
        holder.blindData(item);
    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mPhone;
        private TextView mAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            addControls();
        }


        public void blindData(Contact item) {
            mName.setText(item.getName());
            mPhone.setText(item.getPhone());
            mAddress.setText(item.getAddress());
        }

        private void addControls() {
            mName = (TextView) itemView.findViewById(R.id.text_view_name);
            mPhone = (TextView) itemView.findViewById(R.id.text_view_phone);
            mAddress = (TextView) itemView.findViewById(R.id.text_view_address);
        }
    }
}
