package com.example.tmd.optionmenu_p.BTVN;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.tmd.optionmenu_p.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> mList;
    private ContactAdapter mAdapter;
    private RecyclerView mRecyclerView;

    private ContactDataSource mDatabase;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main_add_address, menu);
        MenuItem searchMenu = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchMenu.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_add:
                Contact newContact =  new Contact(i, R.mipmap.ic_launcher, "Triệu Minh Đức " + i++, "01669870048", "An Xá, Ba Đình, Hà Nội");
                if (mDatabase.insertContact(newContact)){
//                    Toast.makeText(this, "INSERT SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    mList.add(newContact);
                    mAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(this, "INSERT FAILED", Toast.LENGTH_SHORT).show();
                }
                mRecyclerView.scrollToPosition(0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mList = new ArrayList<Contact>();
        addData();
//        mDatabase = new ContactDataSource(this);
//        mList = mDatabase.getAllContacts();
        mAdapter = new ContactAdapter(mList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void addData() {
        for (i = 1; i < 100; i++) {
            mList.add(new Contact(i, R.mipmap.ic_launcher, "Triệu Minh Đức " + i, "01669870048", "An Xá, Ba Đình, Hà Nội"));
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
        aBuilder.setTitle("Bạn có muốn thoát không?")
                .setPositiveButton("OK, thoát đi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Không, ấn nhầm đấy", null)
                .show();
    }
}
