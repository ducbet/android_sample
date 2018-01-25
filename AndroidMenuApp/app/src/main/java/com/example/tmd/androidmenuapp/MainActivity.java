package com.example.tmd.androidmenuapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    /*
        - GridView: (cũ rồi, giờ dùng recycler view)
            + Tương tự ListView. Hiển thị (thường là ảnh) dạng lưới nhưng dữ liệu đưa vào là mảng 1 chiều.
            + android:numColumns="" : số cột. số dòng = số phần tử / số cột (làm tròn lên).
                        VD: 17 item / 3 cột => 5 hàng đủ, hàng thứ 6 có 2 item

        - Tab Selector: (cũ rồi) nếu quá phức tạp thì nên chia các content thành file xml khác
            + Tab Host: chứa Tab Widgets (Tab Buttons), FrameLayouts (Tab contents)
            + Tab Widgets: là thẻ để chọn tab
            + Frame layout là layout dù đè lên nhau thì cũng chỉ hiện layout trên cùng

            + Nếu dùng file layout ngoài thì phải include vào linear layout:
                    <include layout="@layout/tab_apps_menu"/>

            TabHost tabHost = (TabHost) findViewById(R.id.tab_host);
            tabHost.setup();

            // Tạo tab:
            TabHost.TapSpec tab = tabHost.newTabSpec("id không trùng nhau"); // đặt id cho tab
            tab.setContent(R.id.tab1); // tab1 là id của LinearLayout trong activity_main6
            tab.setIndicator("Xâu hiển thị trên tab button");
            tabHost.addTab(spec);

    */

    private ImageView mNavigationBar;

    private ArrayList<AppItem> mArrAppItem1, mArrAppItem2;
    private MenuAppAdapter mMenuAppAdapter;
    private GridView mGridView1, mGridView2;

    private TabHost mTabHost;

    public static boolean isClickedNavigationBar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);
        removeTittleBar();
        setContentView(R.layout.activity_main);

        addControls();
        createTabHost();

        createData();

        mTabHost.getTabWidget().setDividerDrawable(null);
    }


    private void createData() {
        mArrAppItem1 = new ArrayList<AppItem>();
        setDataGridView1();
        mMenuAppAdapter = new MenuAppAdapter(this, R.layout.item_recycler_view, mArrAppItem1);
        mGridView1.setAdapter(mMenuAppAdapter);

        mArrAppItem2 = new ArrayList<AppItem>();
        setDataGridView2();
        mMenuAppAdapter = new MenuAppAdapter(this, R.layout.item_recycler_view, mArrAppItem2);
        mGridView2.setAdapter(mMenuAppAdapter);
    }


    private void createTabHost() {

        // Tạo tab host
        mTabHost = (TabHost) findViewById(R.id.tab_host);
        mTabHost.setup();

        //Tạo tab:


        createTab("t1", "APPS", R.id.tab1);
        createTab("t2", "WIDGETS", R.id.tab2);
    }


    private void createTab(String id, String nameTab, int content) {
        TabHost.TabSpec tab = mTabHost.newTabSpec(id);
        tab.setContent(content);

        LayoutInflater layoutInflater = getLayoutInflater();
        View tab_indicator = layoutInflater.inflate(R.layout.tab_indicator, null);

        TextView txtTabIndicator = (TextView) tab_indicator.findViewById(R.id.text_view_tab_indicator);
        txtTabIndicator.setText(nameTab);
        tab.setIndicator(tab_indicator);
        mTabHost.addTab(tab);
    }


    private void addControls() {

        LinearLayout linearLayoutTab1 = (LinearLayout) findViewById(R.id.tab1);
        mGridView1 = (GridView) linearLayoutTab1.findViewById(R.id.grid_view_menu_app);

        LinearLayout linearLayoutTab2 = (LinearLayout) findViewById(R.id.tab2);
        mGridView2 = (GridView) linearLayoutTab2.findViewById(R.id.grid_view_menu_app);

        mNavigationBar = (ImageView) findViewById(R.id.image_view_navigation_bar);

    }


    private void setDataGridView1() {
        mArrAppItem1.add(new AppItem(R.drawable.chrome, "Chrome"));
        mArrAppItem1.add(new AppItem(R.drawable.calculator, "Calculator"));
        mArrAppItem1.add(new AppItem(R.drawable.calendar, "Calendar"));
        mArrAppItem1.add(new AppItem(R.drawable.camera, "Camera"));
        mArrAppItem1.add(new AppItem(R.drawable.clean_master, "Clean Master"));
        mArrAppItem1.add(new AppItem(R.drawable.drive, "Drive"));
        mArrAppItem1.add(new AppItem(R.drawable.dropbox, "Dropbox"));

        mArrAppItem1.add(new AppItem(R.drawable.gallery_android, "Gallery"));
        mArrAppItem1.add(new AppItem(R.drawable.gmail, "Gmail"));
        mArrAppItem1.add(new AppItem(R.drawable.gmap, "Maps"));
        mArrAppItem1.add(new AppItem(R.drawable.google_plus, "Google+"));
        mArrAppItem1.add(new AppItem(R.drawable.google, "Google"));
        mArrAppItem1.add(new AppItem(R.drawable.messenger, "Messenger"));
        mArrAppItem1.add(new AppItem(R.drawable.setting, "Settings"));
        mArrAppItem1.add(new AppItem(R.drawable.voice_search, "Voice Search"));
        mArrAppItem1.add(new AppItem(R.drawable.zalo, "Zalo"));
        mArrAppItem1.add(new AppItem(R.drawable.zing, "Zing MP3"));

        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "Demo app"));
        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "Activity_P"));
        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "Activity_P"));
        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "Kakukube"));
        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "Kakukube"));
        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "TextView_EditText_Button"));
        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "Test"));
        mArrAppItem1.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "CheckLifeTimeCycle"));

        mArrAppItem1.add(new AppItem(R.drawable.zombie_tsunami, "Zombie Tsunami"));
        mArrAppItem1.add(new AppItem(R.drawable.candy_crush, "Candy Crush Saga"));

        mArrAppItem1.add(new AppItem(R.drawable.slither, "Slither.io"));
        mArrAppItem1.add(new AppItem(R.drawable.plants_vs_zombies, "Plants vs. Zombies"));
        Collections.sort(mArrAppItem1);
    }

    private void setDataGridView2() {
        mArrAppItem2.add(new AppItem(R.drawable.asphalt8, "Asphalt 8: Airborne"));
        mArrAppItem2.add(new AppItem(R.drawable.shadow_fight_2, "Shadow Fight 2"));
        mArrAppItem2.add(new AppItem(R.drawable.clock, "Clock"));
        mArrAppItem1.add(new AppItem(R.drawable.playstore, "Play Store"));
        mArrAppItem2.add(new AppItem(R.drawable.hangouts, "Hangouts"));
        mArrAppItem2.add(new AppItem(R.drawable.camera360, "Camera360"));

        mArrAppItem2.add(new AppItem(R.drawable.screen_off_and_lock, "Close"));


        mArrAppItem2.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "EventHandling"));
        mArrAppItem2.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "EventHandling"));
        mArrAppItem2.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "MyTest2"));
        mArrAppItem2.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "MyTest2"));
        mArrAppItem2.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "HelloWorld"));
        mArrAppItem2.add(new AppItem(R.drawable.ic_launcher_xxxhdpi, "learn"));

        mArrAppItem2.add(new AppItem(R.drawable.facebook, "Facebook"));
        mArrAppItem2.add(new AppItem(R.drawable.xkanji, "Xkanji"));
        mArrAppItem2.add(new AppItem(R.drawable.fruit_ninja, "Fruit Ninja"));
        mArrAppItem2.add(new AppItem(R.drawable.my_talking_tom, "My Talking Tom"));
        mArrAppItem2.add(new AppItem(R.drawable.google_photos, "Google Photos"));
        mArrAppItem2.add(new AppItem(R.drawable.youtube, "Youtube"));
        mArrAppItem2.add(new AppItem(R.drawable.google_translate, "Google Dịch"));
        mArrAppItem2.add(new AppItem(R.drawable.suge_dict, "Suge Dict"));
        mArrAppItem2.add(new AppItem(R.drawable.google_play_tro_choi, "Google Play Trò chơi"));

        Collections.sort(mArrAppItem2);
    }

    public void removeTittleBar() {
        //remove title bar,..//phai de truoc setContentView(R.layout.activity_animation);

        getSupportActionBar().hide();//hide Title Bar (tên application)

        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //hide Navigation Bar (thanh dưới cùng)
//                | View.SYSTEM_UI_FLAG_FULLSCREEN //hide Status Bar (thanh trên cùng)
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // quay trở lại trạng thái ẩn nếu không chạm nữa
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void clickNavigationBar(View view) {
        Toast.makeText(this, "Không thoát được đâu =)) Đừng cố =))", Toast.LENGTH_SHORT).show();
        isClickedNavigationBar = true;
    }
}
