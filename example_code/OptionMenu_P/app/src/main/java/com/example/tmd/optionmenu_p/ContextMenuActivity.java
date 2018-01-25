package com.example.tmd.optionmenu_p;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContextMenuActivity extends AppCompatActivity {

    /*
        - ContextMenu: Giống OptionMenu nhưng áp dụng lên View. Các View chia sẻ chung ContextMenu
        - B1: Tạo file xml menu: new directory...
            + Item cần có id và title
        - B2: Nạp file xml và memory bằng inflater
            + onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
        - B3: onContextItemSelected(MenuItem item)
        - B4: Đăng ký ContextMenu cho View: registerForContextMenu(viewName);

        - Vì các View dùng chung ContextMenu nên phải đánh dấu xem Item vừa được chọn thuộc View nào
    */

    private Button mBtn1, mBtn2, mBtn3;
    private Button mBtnSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        addControls();
        addEvents();
    }

    private void addEvents() {
        mBtn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mBtnSelected = mBtn1;
                return false;
            }
        });

        mBtn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mBtnSelected = mBtn2;
                return false;
            }
        });

        mBtn3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mBtnSelected = mBtn3;
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu_red:
                mBtnSelected.setTextColor(Color.RED);
                break;
            case R.id.context_menu_gray:
                mBtnSelected.setTextColor(Color.GRAY);
                break;
            case R.id.context_menu_green:
                mBtnSelected.setTextColor(Color.GREEN);
                break;
            default:
        }

        return super.onContextItemSelected(item);
    }

    private void addControls() {
        mBtn1 = (Button) findViewById(R.id.button1);
        mBtn2 = (Button) findViewById(R.id.button2);
        mBtn3 = (Button) findViewById(R.id.button3);
        registerForContextMenu(mBtn1);
        registerForContextMenu(mBtn2);
        registerForContextMenu(mBtn3);
    }
}
