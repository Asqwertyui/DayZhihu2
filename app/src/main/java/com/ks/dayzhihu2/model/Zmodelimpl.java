package com.ks.dayzhihu2.model;

import android.util.Log;

import com.ks.dayzhihu2.bena.Dely;
import com.ks.dayzhihu2.bena.Myservice;
import com.ks.dayzhihu2.callbcak.Zcallbak;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by F0519 on 2019/6/30.
 */

public class Zmodelimpl implements Zmodel {
    @Override
    public void getZhihu(final Zcallbak zcallbak) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myservice.zhihu)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<Dely> zhihu = myservice.getZhihu();
        zhihu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Dely>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Dely dely) {
                    if(dely!=null){
                        zcallbak.OnSuccess(dely);
                    }else {
                        zcallbak.OnFail("no");
                    }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("tag","onComplete");
                    }
                });
    }
}
