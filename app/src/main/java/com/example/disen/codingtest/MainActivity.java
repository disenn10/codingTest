package com.example.disen.codingtest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.disen.codingtest.utilities.ViewpagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewpagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
