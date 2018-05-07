package com.example.disen.codingtest.utilities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.disen.codingtest.AddUsersFragment;
import com.example.disen.codingtest.UsersListFragment;

/**
 * Created by disen on 5/6/2018.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {
    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new AddUsersFragment();
            default:
                return new UsersListFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 1:
                return "Add a user";
            default:
                return "Users";
        }
    }
}
