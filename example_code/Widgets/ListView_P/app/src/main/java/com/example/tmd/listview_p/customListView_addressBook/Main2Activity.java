package com.example.tmd.listview_p.customListView_addressBook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tmd.listview_p.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    /*
        - Nên dùng RecyclerView
        ListView cơ bản: CB
        ListView nâng cao: NC

        - Nguồn:
            + CB: ArrayList<String>
            + NC: ArrayList<MyClass> -> phải tự tạo MyClass (implements Serializable)
        - Adapter:
            + CB: ArrayAdapter<String>
            + NC: Nguồn không phải String mà là MyClass, mà nguồn với adapter phải cùng kiểu
                -> phải tự tạo MyClassAdapter

            + CB: new ArrayAdapter<String>(..., android.R.layout.simple_list_item_1, ...);
            + NC: tự tạo item.xml

    */

    ListView lvAddressBook;
    AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();

        setListView();
    }

    private void setListView() {
        ArrayList<AddressContact> listAdress = new ArrayList<AddressContact>();
        listAdress.add(new AddressContact(1, "SĐT", "01669870048"));
        listAdress.add(new AddressContact(2, ".Mẹ", "01698152785"));
        listAdress.add(new AddressContact(3, ".Bố", "0989738346"));
        listAdress.add(new AddressContact(4, ".A Tuấn", "0903471476"));
        for (int i = 5; i < 1000; i++) {
            listAdress.add(new AddressContact(i, i + " - A", String.valueOf(156 * i * i * i * i + i * i)));
        }

        addressAdapter = new AddressAdapter(this, R.layout.item_contact, listAdress);
        lvAddressBook.setAdapter(addressAdapter);


    }

    private void addControls() {
        lvAddressBook = (ListView) findViewById(R.id.lvAddressBook);


    }
}
