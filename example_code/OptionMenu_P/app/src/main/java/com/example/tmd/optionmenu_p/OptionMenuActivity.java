package com.example.tmd.optionmenu_p;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class OptionMenuActivity extends AppCompatActivity {

    /*
        - OptionMenu để thao tác với toàn bộ
        - B1: Tạo file xml menu: new directory...
            + Item cần có id và title
        - B2: Nạp file xml và memory bằng inflater
            onCreateOptionsMenu(Menu menu)
        - B3: onOptionsItemSelected(MenuItem item)
    */

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        mTextView = (TextView) findViewById(R.id.text_view_color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_red:
                mTextView.setBackgroundColor(Color.RED);
                break;
            case R.id.menu_item_gray:
                mTextView.setBackgroundColor(Color.GRAY);
                break;
            case R.id.menu_item_green:
                mTextView.setBackgroundColor(Color.GREEN);
                break;
            default:

        }

        return super.onOptionsItemSelected(item);
    }
}
