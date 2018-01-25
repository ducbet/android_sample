package com.example.tmd.sqlite_db.SQLite_DB;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmd.sqlite_db.R;
import com.example.tmd.sqlite_db.SQLite_DB.ContactByCommand._CRUDHelper;

import java.util.ArrayList;


/**
 * Created by tmd on 23/04/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> mList;
    private Context mContext;

    public ContactAdapter(Context context, ArrayList<Contact> list) {
        mList = list;
        mContext = context;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mName;
        private TextView mPhone;
        private TextView mAddress;
        private TextView mId;
        private ImageView mMore;
        private PopupMenu mPopupMenu;
        private _CRUDHelper mContact_CRUD = new _CRUDHelper(mContext);

        public ViewHolder(View itemView) {
            super(itemView);
            addControls();
            addEvents();
            createPopupMenu();
        }

        private void createPopupMenu() {
            mPopupMenu = new PopupMenu(mContext, mMore);
            mPopupMenu.getMenuInflater().inflate(R.menu.popup_menu_del_row, mPopupMenu.getMenu());
            mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.popup_menu_del:
                            deleteDatabase();
                            break;
                        case R.id.popup_menu_update:
                            updateDatabase();
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
        }

        private void deleteDatabase() {
            Contact contact = mList.get(getAdapterPosition());
            int numRowAffected = mContact_CRUD.deleteContact(contact);
            mList.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
        }

        private void updateDatabase() {
            Contact contact = mList.get(getAdapterPosition());
            contact.setName("New name");
            contact.setPhone("New phone");
            contact.setAddress("New address");
            int numRowAffected = mContact_CRUD.updateContact(contact);
//            loadDatabase();// update nhieu row thi moi can
            notifyItemChanged(getAdapterPosition());
        }

        private void addEvents() {
            mMore.setOnClickListener(this);
        }

        public void blindData(Contact item) {
            mName.setText(item.getName());
            mPhone.setText(item.getPhone());
            mAddress.setText(item.getAddress());
            mId.setText(item.getId() + "");
        }

        private void addControls() {
            mName = (TextView) itemView.findViewById(R.id.text_view_name);
            mPhone = (TextView) itemView.findViewById(R.id.text_view_phone);
            mAddress = (TextView) itemView.findViewById(R.id.text_view_address);
            mId = (TextView) itemView.findViewById(R.id.text_view_id);
            mMore = (ImageView) itemView.findViewById(R.id.image_view_more);
        }

        @Override
        public void onClick(View v) {
            mPopupMenu.show();
        }
    }
}
