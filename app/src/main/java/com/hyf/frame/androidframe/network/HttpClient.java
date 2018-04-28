package com.hyf.frame.androidframe.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;

import com.baronzhang.retrofit2.converter.FastJsonConverterFactory;
import com.hyf.frame.androidframe.app.Constants;
import com.hyf.frame.androidframe.utils.PreferenceUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by hyf on 2018/3/27.
 */

public class HttpClient {
    private static volatile HttpClient httpClient;
    private static final long READ_TIME_OUT = 30000;
    private static final long CONNECT_TIME_OUT = 30000;
    private static final SparseArray<HttpServices> services = new SparseArray<>();
    private Retrofit.Builder builder;

    private HttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(new CommonParamsInterceptor())
                .build();
        builder = new Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    }

    public static HttpClient getInstance() {
        if (httpClient == null) {
            synchronized (HttpClient.class) {
                if (httpClient == null) {
                    httpClient = new HttpClient();
                }
            }
        }
        return httpClient;
    }

    public HttpServices getDefaultService() {
        return getService(0);
    }

    public HttpServices getService(int hostType) {
        HttpServices httpServices = services.get(hostType);
        if (httpServices == null) {
            Retrofit retrofit = builder.baseUrl(HostType.getHost(hostType)).build();
            httpServices = retrofit.create(HttpServices.class);
            services.put(hostType, httpServices);
        }
        return httpServices;
    }


    //访问设置参数
    class CommonParamsInterceptor implements Interceptor {
        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("key", Constants.MOB_APPKEY).build();
            request = request.newBuilder().addHeader("Content-Type", "application/json").url(httpUrl).build();
            return chain.proceed(request);
        }
    }
}
