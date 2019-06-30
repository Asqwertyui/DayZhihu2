package com.ks.dayzhihu2.zhihufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ks.dayzhihu2.R;
import com.ks.dayzhihu2.adapter.RclZhihuadapter;
import com.ks.dayzhihu2.bena.Dely;
import com.ks.dayzhihu2.model.Zmodelimpl;
import com.ks.dayzhihu2.persent.Zpersentimpl;
import com.ks.dayzhihu2.view.Zview;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Daynew extends Fragment implements Zview {


    private View view;
    private RecyclerView mRv;
    private ArrayList<Dely.StoriesBean> mList;
    private RclZhihuadapter mRclZhihuadapter;
    private Zpersentimpl mZpersentimpl;

    public Daynew() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daynew, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        mZpersentimpl = new Zpersentimpl(new Zmodelimpl(), this);
        mZpersentimpl.getZhihu();
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mList = new ArrayList<>();
        mRclZhihuadapter = new RclZhihuadapter(mList, getActivity());
        mRv.setAdapter(mRclZhihuadapter);
    }

    @Override
    public void OnSuccess(Dely dely) {
        if(dely!=null){
            mList.addAll(dely.getStories());
            mRclZhihuadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void OnFail(String msg) {
        Log.e("tga",msg);
    }
}
