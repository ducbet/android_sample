package com.example.tmd.optionmenu_p.BTVN;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.optionmenu_p.R;

import java.util.ArrayList;


/**
 * Created by tmd on 16/04/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> mList;
    private Context mContext;
    private ContactDataSource mDataSource = new ContactDataSource(mContext);

    public ContactAdapter(ArrayList<Contact> list, Context context) {
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

    public void getFilter(String newText) {
        ArrayList<Contact> originList = mDataSource.getAllContacts();

        if (newText.equals("")) {
            mList = originList;
        } else {
            mList.removeAll(mList);
            for (int i = 0; i < originList.size(); i++) {
                if (originList.get(i).getName().contains(newText)) {
                    mList.add(originList.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView mAvatar;
        private TextView mName;
        private TextView mPhone;
        private TextView mAddress;
        private ImageView mMore;
        private PopupMenu mPopupMenu;
        private EditText edtName, edtPhone, edtAddress;
        private ContactDataSource mDataSource = new ContactDataSource(mContext);

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
                            createDeleteAlertDialog().show();
                            break;
                        case R.id.popup_menu_edit:
                            createEditAlertDialog().show();
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
        }

        @Override
        public void onClick(View v) {
            mPopupMenu.show();
        }

        @Override
        public boolean onLongClick(final View v) {
            createDeleteAlertDialog().show();
            return false;
        }

        private AlertDialog createDeleteAlertDialog() {
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(mContext);
            aBuilder.setTitle("Xác nhận xóa");
            aBuilder.setMessage("Bạn có muốn xóa: " + mName.getText() + " ?");
            aBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    deleteContact();
                }
            });
            aBuilder.setNegativeButton("No", null);
            AlertDialog builder = aBuilder.create();
            return builder;
        }

        private void deleteContact() {
            Contact contact = mList.get(getAdapterPosition());
            if (mDataSource.deleteContact(contact.getID())) {
                mList.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
            } else {
                Toast.makeText(mContext, "DELETE CONTACT FAILED", Toast.LENGTH_SHORT).show();
            }
        }

        private void editContact() {
            Toast.makeText(mContext, "getAdapterPosition() " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            Contact contact = mList.get(getAdapterPosition());
            contact.setName(edtName.getText().toString());
            contact.setPhone(edtPhone.getText().toString());
            contact.setAddress(edtAddress.getText().toString());
            if (mDataSource.updateContact(contact)) {
                Toast.makeText(mContext, "UPDATED SUCCESSFUL", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            } else {
                Toast.makeText(mContext, "UPDATED FAILED", Toast.LENGTH_SHORT).show();
            }
        }

        private AlertDialog createEditAlertDialog() {
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(mContext);

            View v = LayoutInflater.from(mContext).inflate(R.layout.edit_contact, null, false);
            edtName = (EditText) v.findViewById(R.id.edit_text_name);
            edtPhone = (EditText) v.findViewById(R.id.edit_text_phone);
            edtAddress = (EditText) v.findViewById(R.id.edit_text_address);

//            edtName.setText(mName.getText().toString());// khoi tao gia tri ban dau la thong tin cu cua contact
//            edtPhone.setText(mPhone.getText().toString());
//            edtAddress.setText(mAddress.getText().toString());
            aBuilder.setTitle("Cập nhật dữ liệu của: " + mName.getText())
                    .setView(v)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editContact();
                        }
                    })
                    .setNegativeButton("Cancel", null);
            AlertDialog dialog = aBuilder.create();
            return dialog;
        }

        public void blindData(Contact item) {
            mAvatar.setImageResource(item.getAvatar());
            mName.setText(item.getName());
            mPhone.setText(item.getPhone());
            mAddress.setText(item.getAddress());
        }

        private void addEvents() {
            mMore.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        private void addControls() {
            mAvatar = (ImageView) itemView.findViewById(R.id.image_view_avatar);
            mName = (TextView) itemView.findViewById(R.id.text_view_name);
            mPhone = (TextView) itemView.findViewById(R.id.text_view_phone);
            mAddress = (TextView) itemView.findViewById(R.id.text_view_address);
            mMore = (ImageView) itemView.findViewById(R.id.image_view_more);
        }


    }
}
