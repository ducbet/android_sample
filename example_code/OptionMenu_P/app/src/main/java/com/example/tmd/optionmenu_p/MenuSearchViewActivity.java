package com.example.tmd.optionmenu_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuSearchViewActivity extends AppCompatActivity {
    ArrayList<String> arrProvince;
    ArrayAdapter<String> adapterProvince;
    ListView lvProvince;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_search_view);

        addControls();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterProvince.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void addControls() {
        lvProvince = (ListView) findViewById(R.id.lvAddressBook);

        arrProvince = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.tinhThanhVN)));
        adapterProvince = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrProvince);
        lvProvince.setAdapter(adapterProvince);
    }
}
