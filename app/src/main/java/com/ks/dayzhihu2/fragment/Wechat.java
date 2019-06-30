package com.ks.dayzhihu2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ks.dayzhihu2.R;
import com.ks.dayzhihu2.adapter.RclWemyadapter;
import com.ks.dayzhihu2.bena.Wee;
import com.ks.dayzhihu2.model.Mymodelimpl;
import com.ks.dayzhihu2.persent.Mypersentimpl;
import com.ks.dayzhihu2.view.Myview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Wechat extends Fragment implements Myview {


    private View view;
    private RecyclerView mRv;
    private ArrayList<Wee.NewslistBean> mNewslistBeans;
    private RclWemyadapter mRclWemyadapter;
    private Mypersentimpl mMypersentimpl;

    public Wechat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        mMypersentimpl = new Mypersentimpl(new Mymodelimpl(), this);
        mMypersentimpl.getData();
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));

        mNewslistBeans = new ArrayList<>();
        mRclWemyadapter = new RclWemyadapter(mNewslistBeans, getActivity());
        mRv.setAdapter(mRclWemyadapter);
    }

    @Override
    public void OnSuccess(Wee wee) {
        if(wee!=null){
            List<Wee.NewslistBean> list = wee.getNewslist();
            mNewslistBeans.addAll(list);
            mRclWemyadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void OnFail(String msg) {
        Log.e("tga",msg);
    }
}
