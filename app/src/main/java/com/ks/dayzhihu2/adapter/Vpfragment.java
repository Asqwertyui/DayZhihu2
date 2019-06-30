package com.ks.dayzhihu2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/6/28.
 */

public class Vpfragment extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragments;

    public Vpfragment(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        mFragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
