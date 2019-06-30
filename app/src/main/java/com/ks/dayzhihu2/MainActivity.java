package com.ks.dayzhihu2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ks.dayzhihu2.fragment.About;
import com.ks.dayzhihu2.fragment.Collection;
import com.ks.dayzhihu2.fragment.Gank;
import com.ks.dayzhihu2.fragment.Gload;
import com.ks.dayzhihu2.fragment.Setting;
import com.ks.dayzhihu2.fragment.V2Ex;
import com.ks.dayzhihu2.fragment.Wechat;
import com.ks.dayzhihu2.fragment.Zhihu;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
//苏清芬
public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private Toolbar mTl;
    private MaterialSearchView mSearch;
    private FrameLayout mFn;
    private FrameLayout mFm;
    private NavigationView mNv;
    private DrawerLayout mDl;
    private ActionBarDrawerToggle mToggle;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Integer> mStrings;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mTl = (Toolbar) findViewById(R.id.tl);
        mTl.setTitle(R.string.Zhihu);
        mSearch = (MaterialSearchView) findViewById(R.id.search);
        mFm = (FrameLayout) findViewById(R.id.fm);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mNv = (NavigationView) findViewById(R.id.nv);
        //侧滑设置图片展示
        mNv.setItemIconTintList(null);
        //---三杠侧滑开关控制
        setSupportActionBar(mTl);
        mToggle = new ActionBarDrawerToggle(this, mDl, mTl, R.string.app_name, R.string.app_name);
        mDl.addDrawerListener(mToggle);
        mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorAccent));
        mToggle.syncState();
        //搜索框
        initSearch();
        //侧滑
        initNavigation();
        //初始化对应页面
        initFragment();
        //初始化标题
        initTitle();
        //初始化页面管理
        mManager = getSupportFragmentManager();
        //加载第一个页面知乎日报
        addZhihufragment();
    }

    private void addZhihufragment() {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.fm,mFragments.get(0));
        transaction.commit();
    }

    private void initTitle() {
        mStrings = new ArrayList<>();
        mStrings.add(R.string.Zhihu);
        mStrings.add(R.string.Wechat);
        mStrings.add(R.string.Gank);
        mStrings.add(R.string.gload);
        mStrings.add(R.string.v2ex);
        mStrings.add(R.string.collection);
        mStrings.add(R.string.setting);
        mStrings.add(R.string.about);

    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new Zhihu());
        mFragments.add(new Wechat());
        mFragments.add(new Gank());
        mFragments.add(new Gload());
        mFragments.add(new V2Ex());
        mFragments.add(new Collection());
        mFragments.add(new Setting());
        mFragments.add(new About());
    }

    private void initNavigation() {
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.zhi){
                    SwitchFrasgment(AppConstants.TYPE_ZHIHU);
                }else if(item.getItemId()==R.id.wechat){
                    SwitchFrasgment(AppConstants.TYPE_WECHAT);
                }else if(item.getItemId()==R.id.gank){
                    SwitchFrasgment(AppConstants.TYPE_GANK);
                }else if(item.getItemId()==R.id.gload){
                    SwitchFrasgment(AppConstants.TYPE_GOLD);
                }else if(item.getItemId()==R.id.v2ex){
                    SwitchFrasgment(AppConstants.TYPE_V2EX);
                }else if(item.getItemId()==R.id.collect){
                    SwitchFrasgment(AppConstants.TYPE_COLLECT);
                }else if(item.getItemId()==R.id.setting){
                    SwitchFrasgment(AppConstants.TYPE_SETTINGS);
                }else if(item.getItemId()==R.id.about){
                    SwitchFrasgment(AppConstants.TYPE_ABOUT);
                }
                mDl.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }
    private int lastType=0;
    private void SwitchFrasgment(int type) {
        FragmentTransaction transaction = mManager.beginTransaction();
        Fragment fragment = mFragments.get(type);
        if(!fragment.isAdded()){
            transaction.add(R.id.fm,fragment);
        }
        Fragment lastfragment = mFragments.get(lastType);
        transaction.hide(lastfragment);
        //显示碎片
        transaction.show(fragment);
        transaction.commit();
        lastType=type;
        mTl.setTitle(mStrings.get(type));
    }

    //搜索框
    private void initSearch() {
        mSearch.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                mSearch.isSearchOpen();
            }

            @Override
            public void onSearchViewClosed() {
                mSearch.closeSearch();
            }
        });
        mSearch.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
    //选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        MenuItem item = menu.findItem(R.id.serch);
        item.setVisible(true);
        mSearch.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }
    //返回按钮处理
    @Override
    public void onBackPressed() {
        if (mSearch.isSearchOpen()) {
            mSearch.closeSearch();
        } else {
            super.onBackPressed();

        }
    }
}
