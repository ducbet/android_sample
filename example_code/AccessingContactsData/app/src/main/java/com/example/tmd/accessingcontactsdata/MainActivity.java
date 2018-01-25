package com.example.tmd.accessingcontactsdata;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> mList;
    private ContactAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private static int GET_ALL_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
//        Contact newContact = new Contact("ABC", "01203", "Ha Noi");
//        mList.add(newContact);
//        mAdapter.notifyDataSetChanged();
    }

    private void getContact() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name_ColumnName = ContactsContract.Contacts.DISPLAY_NAME;
                int index_ColumnName = cursor.getColumnIndex(name_ColumnName);
                String name = cursor.getString(index_ColumnName);

                String name_ColumnPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
                int index_ColumnPhone = cursor.getColumnIndex(name_ColumnPhone);
                String phone = cursor.getString(index_ColumnPhone);

                Contact contact = new Contact(name, phone, "");
                mList.add(contact);
            }
        }
    }

    public void requestPermission() {
        // kiem tra xem app da duoc user cap quyen hay chua
        int isGrant = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CONTACTS);
        if (isGrant == PackageManager.PERMISSION_GRANTED) {
            // da duoc cap quyen
            getContact();
            Toast.makeText(this, "PERMISSION_GRANTED", Toast.LENGTH_SHORT).show();
        } else if (isGrant == PackageManager.PERMISSION_DENIED) {
            // chua duoc cap quyen
            // de bat su kien khi ng dung allow thi phai override onRequestPermissionsResult

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_CONTACTS)) {
                // Trường hợp này là cần show 1 lời giải thích tới user
                // là tại sao mình cần truy cập quyền này
                AlertDialog.Builder aBuiler = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Request Image Permission")
                        .setMessage("We want to access to your external storage to get image and update avatar")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(
                                        MainActivity.this,
                                        new String[]{Manifest.permission.READ_CONTACTS},
                                        GET_ALL_CONTACT);
                            }
                        })
                        .setNegativeButton("NO", null);
                aBuiler.create().show();
            } else {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        GET_ALL_CONTACT);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_ALL_CONTACT) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // user vua moi cap quyen
                getContact();
                mAdapter.notifyDataSetChanged();
                Toast.makeText(this, "PERMISSION_GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                // user khong cap quyen
                Toast.makeText(this, "PERMISSION_DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void addControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mList = new ArrayList<Contact>();
        requestPermission(); // request permission and get contact
        mAdapter = new ContactAdapter(mList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

}
