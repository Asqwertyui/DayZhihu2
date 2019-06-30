package com.ks.dayzhihu2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ks.dayzhihu2.R;
import com.ks.dayzhihu2.bena.Wee;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/6/28.
 */

public class RclWemyadapter extends RecyclerView.Adapter<RclWemyadapter.ViewHolder> {
    private ArrayList<Wee.NewslistBean> mNewslistBeans;
    private Context context;

    public RclWemyadapter(ArrayList<Wee.NewslistBean> newslistBeans, Context context) {
        mNewslistBeans = newslistBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.weca, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Wee.NewslistBean bean = mNewslistBeans.get(position);
        holder.tv.setText(bean.getTitle());
        holder.tvv.setText(bean.getDescription());
        holder.tvvv.setText(bean.getCtime());
        Glide.with(context).load(bean.getPicUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mNewslistBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private  TextView tvv;
        private TextView tvvv;
        private ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tvv=itemView.findViewById(R.id.tvv);
            tvvv=itemView.findViewById(R.id.tvvv);
           iv=itemView.findViewById(R.id.iv);
        }
    }
}
