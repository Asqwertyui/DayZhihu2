package com.ks.dayzhihu2.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ks.dayzhihu2.R;
import com.ks.dayzhihu2.adapter.Vpfragment;
import com.ks.dayzhihu2.zhihufragment.Daynew;
import com.ks.dayzhihu2.zhihufragment.Deplay;
import com.ks.dayzhihu2.zhihufragment.Hot;
import com.ks.dayzhihu2.zhihufragment.Title;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhihu extends Fragment {


    private View view;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mStrings;
    private Vpfragment mVpfragment;

    public Zhihu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhihu, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mVp = (ViewPager) view.findViewById(R.id.vp);
        mFragments = new ArrayList<>();
        mFragments.add(new Daynew());
        mFragments.add(new Title());
        mFragments.add(new Deplay());
        mFragments.add(new Hot());
        mStrings = new ArrayList<>();
       mTab.addTab(mTab.newTab().setText("日报"));
       mTab.addTab(mTab.newTab().setText("主题"));
       mTab.addTab(mTab.newTab().setText("专栏"));
       mTab.addTab(mTab.newTab().setText("热门"));
        mVpfragment = new Vpfragment(getChildFragmentManager(), mFragments);
        mVp.setAdapter(mVpfragment);
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }
}
