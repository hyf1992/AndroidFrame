package com.hyf.frame.androidframe.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;


import com.hyf.frame.androidframe.utils.PreferenceUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hyf on 2018/1/11.
 */

public class LoggingInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Request.Builder builder = oldRequest.newBuilder()
                .addHeader("Content-Type", "application/json;charset=UTF-8");
        HttpUrl httpUrl = null;
        String token = "";
        if (!TextUtils.isEmpty(token)) {
            httpUrl = oldRequest.url().newBuilder().addQueryParameter("token", token).build();
        }
        if (httpUrl != null) builder.url(httpUrl);
        Request newRequest = builder.build();
        return chain.proceed(newRequest);
    }
}
