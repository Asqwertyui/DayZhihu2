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
import com.ks.dayzhihu2.bena.Dely;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/6/30.
 */

public class RclZhihuadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Dely.StoriesBean> mList;
    private Context context;

    public RclZhihuadapter(ArrayList<Dely.StoriesBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            View view = View.inflate(context, R.layout.ban, null);
            ViewHodler1 hodler1=new ViewHodler1(view);
            return hodler1;
        }else {
            if(viewType==1){
                View view = View.inflate(context, R.layout.tet, null);
                ViewHolder2 holder2 = new ViewHolder2(view);
                return holder2;
            }else {
                View view = View.inflate(context, R.layout.art, null);
                ViewHolder3 holder3 = new ViewHolder3(view);
                return holder3;
            }
        }

    }
private int pos=0;
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type==0){
            ViewHodler1 hodler1= (ViewHodler1) holder;
            hodler1.ban.setImages(mList).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Dely.StoriesBean ban= (Dely.StoriesBean) path;
                    Glide.with(context).load(ban.getImages()).into(imageView);
                }
            }).start();
        }else {
          if(type==1){
              ViewHolder2 holder2= (ViewHolder2) holder;
              if(mList.size()>0&&mList!=null){
                pos=position-1;
              }else {
                  pos=position;
              }
              holder2.tv.setText("今日热闻");
          }else {
              if(type==2){
                  ViewHolder3 holder3= (ViewHolder3) holder;
                  if(mList.size()>0&&mList!=null){
                      pos=position-1-1;
                  }else {
                      pos=position;
                  }
                  Dely.StoriesBean bean = mList.get(pos);
                  holder3.tvv.setText(bean.getTitle());
                  Glide.with(context).load(bean.getImages().toString()).into(holder3.iv);
              }
          }
        }
    }

    @Override
    public int getItemCount() {
        if(mList.size()>0&&mList!=null){
            return mList.size()+1;
        }else {
            if(mList.size()>0&&mList!=null){
                return mList.size()+1+1;
            }else {
                return mList.size();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else {
            if(position==1){
                return 1;
            }else {
                return 2;
            }
        }
    }

    class ViewHodler1 extends RecyclerView.ViewHolder{
private Banner ban;
        public ViewHodler1(View itemView) {
            super(itemView);
           ban= itemView.findViewById(R.id.ban);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        private TextView tv;
        public ViewHolder2(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder{
        private TextView tvv;
        private ImageView iv;
        public ViewHolder3(View itemView) {
            super(itemView);
           tvv= itemView.findViewById(R.id.tvv);
           iv= itemView.findViewById(R.id.iv);
        }
    }
}
