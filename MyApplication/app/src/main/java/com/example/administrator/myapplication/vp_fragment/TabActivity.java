package com.example.administrator.myapplication.vp_fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;



public class TabActivity extends FragmentActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    List<Fragment> list = new ArrayList<>();
    String[] title = new String[]{"普通会员", "白银会员", "黄金会员", "铂金会员", "钻石会员", "黑钻会员"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabLayout =  findViewById(R.id.tablayout);
        viewPager =  findViewById(R.id.viewpager);

        initFragmentList();
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), list, title));
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initFragmentList() {
        for (int i = 0; i < title.length; i++) {
            tabLayout.addTab(tabLayout.newTab());
            if(i%2==0){
                PlusOneFragment rankFragment = new PlusOneFragment();
                Bundle b = new Bundle();
                b.putInt("index", i);
                rankFragment.setArguments(b);
                list.add(rankFragment);
            }else{
                TabFragment rankFragment = new TabFragment();
                Bundle b = new Bundle();
                b.putInt("index", i);
                rankFragment.setArguments(b);
                list.add(rankFragment);
            }

        }
    }


}
