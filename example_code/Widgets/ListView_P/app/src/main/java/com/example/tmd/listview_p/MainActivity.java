package com.example.tmd.listview_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tmd.listview_p.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /*
        - Dùng để hiện thị dữ liệu dạng danh sách. VD: danh bạ điện thoại
        - Nếu là dữ liệu cô định thì dùng Array cũng được, nếu là dữ liệu động thì dùng Collection.
            Nếu muốn thì dùng toàn bộ là Colection cũng được nhưng phải dùng hàm chuyển từ List[] thành Collection
                vì dữ liệu lưu trong strings.xml được lấy ra dạng String[]
            Arrays.asList(); convert List[] to Collection. Ngược với: Object[] toArray ();
        - Khi dữ liệu thay đổi thì phải cập nhật lại adapter: adapterName.notifyDataSetChanged();

        - Nguồn và adapter phải có cùng kiểu
        - Các bước tạo ListView: Nguồn -> Adapter -> ListView
            + B1: Xác định nguồn có kiểu gì
            + B2: Tạo adapter có cùng kiểu dữ liệu với nguồn, sau đó gán nguồn cho adapter này
            + B3: Gán adapter cho ListView

        - lvName.setOnItemClickListener() bắt sự kiện khi click vào 1 item trong ListView
        - lvName.setOnItemLongClickListener() longClick
        - listSelector: tô màu dòng đang được chọn

    */

    ArrayList<String> arrayAddressBook;
    ArrayAdapter<String> adapterAddressBook;
    ListView lvAddressBook;

    EditText edtName;
        Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        lvAddressBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "OnClick " + arrayAddressBook.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        lvAddressBook.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "OnLongClick " + arrayAddressBook.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewAddress();
            }
        });
    }

    private void saveNewAddress() {
        String newAddress = edtName.getText().toString();
        if(!newAddress.equals("")){
            arrayAddressBook.add(newAddress); // thêm dữ liệu mới
            adapterAddressBook.notifyDataSetChanged();// cập nhật lại dữ liệu
            edtName.setText("");
        }
        edtName.requestFocus();
    }

    private void addControls() {
        lvAddressBook = (ListView) findViewById(R.id.lvAddressBook);
        edtName = (EditText) findViewById(R.id.edtName);
        btnSave = (Button) findViewById(R.id.btnSave);

        arrayAddressBook = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.danhBaBanDau))); //B1
        adapterAddressBook = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayAddressBook);//(màn hình cần dùng, giao diện sử dụng, nguồn dữ liệu) //B2
        lvAddressBook.setAdapter(adapterAddressBook); //B3
    }
}

