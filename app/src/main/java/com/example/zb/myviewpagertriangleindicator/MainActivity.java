package com.example.zb.myviewpagertriangleindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerTriangleIndicator mViewPagerTriangleIndicator;
    private List<String>   mTitles    = Arrays.asList("新闻", "音乐");
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_main_content);
        mViewPagerTriangleIndicator = (ViewPagerTriangleIndicator) findViewById(R.id.vpti_main_tab);
        //创建Fragment
        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        mFragments.add(oneFragment);
        mFragments.add(twoFragment);
        //设置指示器标题
        mViewPagerTriangleIndicator.setPageTitle(mTitles);
        //绑定ViewPager
        mViewPagerTriangleIndicator.setViewPagerWithIndicator(mViewPager);
        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }
            @Override
            public int getCount() {
                return mFragments.size();
            }
        });

    }
}
