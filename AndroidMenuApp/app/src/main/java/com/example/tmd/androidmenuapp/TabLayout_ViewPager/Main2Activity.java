package com.example.tmd.androidmenuapp.TabLayout_ViewPager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tmd.androidmenuapp.AppItem;
import com.example.tmd.androidmenuapp.MenuAppAdapter;
import com.example.tmd.androidmenuapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    /*
        - TabLayout, ViewPager:
            + Nếu TabLayout nằm ngoài ViewPager thì dùng mTabLayout.setupWithViewPager(mViewPager);
            + ViewPager giống RecyclerView, nhưng mỗi item là 1 fragment
            + Khỏi tạo:
                + B1: Tạo list fragment (extends Fragment)
                + B2: Tạo Adapter (extends FragmentPagerAdapter)
                + B3: setAdapter cho ViewPager

            + TabLayout:
                + Override getPageTitle() để đạt tên cho tab


    */

    private ImageView mImgNavigationBar;
    public static boolean isClickedNavigationBar = false;

    private Animation mAnimHideThumb;

    private TabLayout mTabLayout, mTabLayoutBottom;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;

    private ArrayList<AppItem> mArrAppItem1 = new ArrayList<AppItem>();
    private ArrayList<AppItem> mArrAppItem2 = new ArrayList<AppItem>();

    private List<MenuFragment> mFragments = new ArrayList<MenuFragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTittleBar();

        setContentView(R.layout.activity_main2);

        addControls();
        addEvents();
        setDataGridView1();
        setDataGridView2();
        createViewPager();

    }

    private void addEvents() {
        mViewPager.setOnPageChangeListener(this);
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

    private void createViewPager() {
        mFragments.add(new MenuFragment(this, mArrAppItem1));
        mFragments.add(new MenuFragment(this, mArrAppItem1));
        mFragments.add(new MenuFragment(this, mArrAppItem1));
        mFragments.add(new MenuFragment(this, mArrAppItem1));
        mFragments.add(new MenuFragment(this, mArrAppItem2));

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), this, mFragments);
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void addControls() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mImgNavigationBar = (ImageView) findViewById(R.id.image_view_navigation_bar);

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayoutBottom = (TabLayout) findViewById(R.id.tab_layout_bottom);
        mTabLayoutBottom.setupWithViewPager(mViewPager);

        mAnimHideThumb = AnimationUtils.loadAnimation(this, R.anim.anim_hide_thumb_tab_layout_bottom);

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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTabLayoutBottom.startAnimation(mAnimHideThumb);
//        mTabLayoutBottom.setVisibility(View.INVISIBLE);
        System.out.println("onPageSelected  INVISIBLE");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        mTabLayoutBottom.setVisibility(View.VISIBLE);
//        System.out.println("onPageScrolled  VISIBLE");
    }
}
