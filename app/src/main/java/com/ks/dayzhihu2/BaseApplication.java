package com.ks.dayzhihu2;

import android.app.Application;

/**
 * Created by $lzj on 2019/5/6.
 */
public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }

    public static BaseApplication getInstance() {
        return application;
    }
}
