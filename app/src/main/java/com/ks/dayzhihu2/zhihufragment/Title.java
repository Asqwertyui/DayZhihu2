package com.ks.dayzhihu2.zhihufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ks.dayzhihu2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Title extends Fragment {


    public Title() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        return view;
    }

}
