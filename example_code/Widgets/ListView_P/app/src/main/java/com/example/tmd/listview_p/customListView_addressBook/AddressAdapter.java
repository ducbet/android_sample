package com.example.tmd.listview_p.customListView_addressBook;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmd.listview_p.R;

import java.util.List;

/**
 * Created by tmd on 21/03/2017.
 */

public class AddressAdapter extends ArrayAdapter<AddressContact> implements View.OnClickListener {

    /*
        - MyClassAdapter extends ArrayAdapter<MyClass>
        - superConstructor(..., ..., object:List<T>)
        - đổi Context -> Activity

        - override method getView
    */

    TextView txtName, txtPhone;
    ImageButton imbCall, imbSMS, imbDetail;

    // màn hình sử dụng layout này
    Activity context;

    // layout cho từng dòng muốn hiển thị (custom layout)
    int resource;

    // nguồn dữ liệu
    List<AddressContact> objects;

    public AddressAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<AddressContact> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater(); // LayoutInflater build file xml thành file code
        View row = inflater.inflate(this.resource, null);

        // lấy các Widget trong row:
        TextView txtName = (TextView) row.findViewById(R.id.txtName);
        TextView txtPhone = (TextView) row.findViewById(R.id.txtPhone);
        ImageButton imbCall = (ImageButton) row.findViewById(R.id.imbCall);
        ImageButton imbSMS = (ImageButton) row.findViewById(R.id.imbSMS);
        ImageButton imbDetail = (ImageButton) row.findViewById(R.id.imbDetail);

        // int position: vị trí hiện tại cần vẽ lên
        // trả về addressContact muốn vẽ
        AddressContact addressContact = this.objects.get(position);
        txtName.setText(addressContact.getName());
        txtPhone.setText(addressContact.getPhoneNumber());

        imbDetail.setOnClickListener(this);
        imbCall.setOnClickListener(this);
        imbSMS.setOnClickListener(this);

        Animation anim = AnimationUtils.loadAnimation(context, R.anim.animation);
        row.startAnimation(anim);
        return row;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imbCall) {
            Toast.makeText(this.context, "Call", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.imbSMS) {
            Toast.makeText(this.context, "SMS", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.imbDetail) {
            Toast.makeText(this.context, "Detail", Toast.LENGTH_SHORT).show();
        }

    }
}
