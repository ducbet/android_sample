package com.example.tmd.sqlite_db.SQLite_DB.ContactCopyFromAssests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tmd.sqlite_db.R;
import com.example.tmd.sqlite_db.SQLite_DB.Contact;
import com.example.tmd.sqlite_db.SQLite_DB.ContactAdapter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    public static long IdItemSelected = -1;

    private ArrayList<Contact> mList;
    private ContactAdapter mContactAdapter;
    private RecyclerView mRecyclerView;
    private Button mBtnLoad, mBtnInsert, mBtnUpdate, mBtnDelete;

    private _CRUDHelper mContact_CRUD = new _CRUDHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addControls();
        addEvents();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_load:
                loadDatabase();
                break;
            case R.id.button_insert:
                insertOneRow();
                break;
            case R.id.button_update:
                ALL_updateDatabase();
                break;
            case R.id.button_delete:
                ALL_deleteDatabase();
                break;
            default:
                break;
        }
    }

    private void ALL_deleteDatabase() {
        int numRowAffected = mContact_CRUD.ALL_deleteContact();
        Toast.makeText(this, "DELETED ALL: " + numRowAffected + " ROW", Toast.LENGTH_LONG).show();
        mList.clear();
        mContactAdapter.notifyDataSetChanged();
    }

    private void ALL_updateDatabase() {
        int numRowAffected = mContact_CRUD.ALL_updateContact();
        Toast.makeText(this, "UPDATED ALL: " + numRowAffected + " ROW", Toast.LENGTH_LONG).show();
        loadDatabase();
    }

    private void insertOneRow() {
        Contact newContact = new Contact("ABC", "01203", "Ha Noi");
        if (mContact_CRUD.insertContact(newContact)) {
//            Toast.makeText(this, "INSERT SUCCESSFUL", Toast.LENGTH_SHORT).show();
            mList.add(newContact);
            mContactAdapter.notifyDataSetChanged();
        } else {
//            Toast.makeText(this, "INSERT FAILED", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadDatabase() {
        /*
        - Chú ý: Nếu thay đổi tham chiếu của nguồn mList thì Adapter sẽ không load được dữ liệu nữa.
            Vì ta gán tham chiếu của mList trong hàm khởi tạo Adapter.
                public ContactAdapter(Context context, ArrayList<Contact> list) {
                    mList = list;
                    mContext = context;
                }
            => Hàm getAllContact() không nên giả lại ArrayList mà nên truyền ArrayList vào
        */
        mContact_CRUD.getAllContact(mList);
        mContactAdapter.notifyDataSetChanged();
    }

    private void addEvents() {
        mBtnLoad.setOnClickListener(this);
        mBtnInsert.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    private void addControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mBtnLoad = (Button) findViewById(R.id.button_load);
        mBtnInsert = (Button) findViewById(R.id.button_insert);
        mBtnUpdate = (Button) findViewById(R.id.button_update);
        mBtnDelete = (Button) findViewById(R.id.button_delete);

        mList = new ArrayList<Contact>();
        mContactAdapter = new ContactAdapter(this, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mContactAdapter);
    }

}
