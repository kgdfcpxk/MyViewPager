package com.example.administrator.myviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mTabViewPager;
    private LinearLayout mLinearTabWinXin;
    private LinearLayout mLinearTabFriend;
    private LinearLayout mLinearTabContact;
    private LinearLayout mLinearTabSettings;
    private ImageView mImgTabWinXin;
    private ImageView mImgTabFriend;
    private ImageView mImgTabContact;
    private ImageView mImgTabSettins;
    private List<View> mWinXinList = new ArrayList<>();
    private PagerAdapter mWinXinPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initTab();
        initEvent();
        adapter();
        mTabViewPager.setAdapter(mWinXinPagerAdapter);
        mTabViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateImg(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void adapter() {
        mWinXinPagerAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mWinXinList.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mWinXinList.get(position));
            }

            @Override
            public int getCount() {
                return mWinXinList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        };
    }

    private void initEvent() {
        mLinearTabWinXin.setOnClickListener(MainActivity.this);
        mLinearTabFriend.setOnClickListener(MainActivity.this);
        mLinearTabContact.setOnClickListener(MainActivity.this);
        mLinearTabSettings.setOnClickListener(MainActivity.this);
    }

    private void initTab() {
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        mWinXinList.add(inflater.inflate(R.layout.tab01,null));
        mWinXinList.add(inflater.inflate(R.layout.tab02,null));
        mWinXinList.add(inflater.inflate(R.layout.tab03,null));
        mWinXinList.add(inflater.inflate(R.layout.tab04,null));
    }

    /**
     * 初始化控件
     */
    private void initView() {
        // ViewPager
        mTabViewPager = (ViewPager) findViewById(R.id.id_tab_viewpager);
        // LinearLayout
        mLinearTabWinXin = (LinearLayout) findViewById(R.id.id_tab_winxin);
        mLinearTabFriend = (LinearLayout) findViewById(R.id.id_tab_friend);
        mLinearTabContact = (LinearLayout) findViewById(R.id.id_tab_contact);
        mLinearTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);
        // ImageView
        mImgTabWinXin = (ImageView) findViewById(R.id.id_tab_winxin_img);
        mImgTabFriend = (ImageView) findViewById(R.id.id_tab_friend_img);
        mImgTabContact = (ImageView) findViewById(R.id.id_tab_contact_img);
        mImgTabSettins = (ImageView) findViewById(R.id.id_tab_settings_img);
    }

    @Override
    public void onClick(View view) {
        resetImg();
        switch (view.getId()) {
            case R.id.id_tab_winxin:
                mTabViewPager.setCurrentItem(0);
                mImgTabWinXin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.id_tab_friend:
                mTabViewPager.setCurrentItem(1);
                mImgTabFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.id_tab_contact:
                mTabViewPager.setCurrentItem(2);
                mImgTabContact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                mTabViewPager.setCurrentItem(3);
                mImgTabSettins.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }
    private void updateImg(int position) {
        resetImg();
        switch (position) {
            case 0:
                mTabViewPager.setCurrentItem(0);
                mImgTabWinXin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                mTabViewPager.setCurrentItem(1);
                mImgTabFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                mTabViewPager.setCurrentItem(2);
                mImgTabContact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                mTabViewPager.setCurrentItem(3);
                mImgTabSettins.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }

    private void resetImg() {
        mImgTabWinXin.setImageResource(R.drawable.tab_weixin_normal);
        mImgTabFriend.setImageResource(R.drawable.tab_find_frd_normal);
        mImgTabContact.setImageResource(R.drawable.tab_address_normal);
        mImgTabSettins.setImageResource(R.drawable.tab_settings_normal);
    }
}
