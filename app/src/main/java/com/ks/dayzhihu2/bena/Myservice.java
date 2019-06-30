package com.ks.dayzhihu2.bena;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by F0519 on 2019/6/28.
 */

public interface Myservice {
    //http://api.tianapi.com/wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    public String wee="http://api.tianapi.com/wxnew/";
    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<Wee> getwee();
    //http://news-at.zhihu.com/api/4/news/latest
    public String zhihu="http://news-at.zhihu.com/";
    @GET("api/4/news/latest")
    Observable<Dely>getZhihu();
}
