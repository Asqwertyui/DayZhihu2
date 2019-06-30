package com.ks.dayzhihu2.model;

import android.util.Log;


import com.ks.dayzhihu2.bena.Myservice;
import com.ks.dayzhihu2.bena.Wee;
import com.ks.dayzhihu2.callbcak.Mycallbcak;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by F0519 on 2019/6/28.
 */

public class Mymodelimpl implements Mymdoel {

    @Override
    public void getData(final Mycallbcak mycallbcak) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Myservice.wee)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<Wee> getwee = myservice.getwee();
        getwee.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Wee>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Wee wee) {
                        if (wee != null) {
                            mycallbcak.OnSuccess(wee);
                        } else {
                            mycallbcak.OnFail("mpo");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tga", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("tag", "onComplete");
                    }
                });
    }
}
