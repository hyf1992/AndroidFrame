package com.hyf.frame.androidframe.network;


import com.hyf.frame.androidframe.beans.DeviceList;
import com.hyf.frame.androidframe.beans.HttpResult;
import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.entities.DeviceInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by hyf on 2018/3/27.
 */

public interface HttpServices {
    //根据用户id获取用户
    @Headers("Cache-Control: public, max-age=3600")
    @GET("v1/cook/category/query")
    Observable<MobResult<CookResult>> getCookCategory();

    @POST("device/getDeviceLastConnectTime")
    Observable<HttpResult<List<DeviceInfo>>> getDevices(@Body DeviceList deviceList);
}
