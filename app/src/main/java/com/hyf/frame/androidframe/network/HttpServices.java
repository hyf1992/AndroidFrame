package com.hyf.frame.androidframe.network;


import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.entities.CookResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by hyf on 2018/3/27.
 */

public interface HttpServices {
    //根据用户id获取用户
    @Headers("Cache-Control: public, max-age=3600")
    @GET("v1/cook/category/query")
    Observable<MobResult<CookResult>> getCookCategory();
}
