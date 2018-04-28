package com.hyf.frame.androidframe.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.hyf.frame.androidframe.R;
import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.entities.User;
import com.hyf.frame.androidframe.rxjava.ExceptionObserver;
import com.hyf.frame.androidframe.rxjava.RxSchedulers;
import com.hyf.frame.androidframe.ui.BaseActivity;
import com.hyf.frame.androidframe.ui.animation.AnimationActivity;
import com.hyf.frame.androidframe.ui.login.LoginActivity;
import com.hyf.frame.androidframe.utils.LogUtils;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;
import javax.inject.Inject;

import cn.nekocode.rxlifecycle.LifecycleEvent;
import cn.nekocode.rxlifecycle.RxLifecycle;
import dagger.android.DaggerActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;


public class MainActivity extends DaggerActivity implements MainContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();
    //private Realm realm;
    @Inject
    MainPresenter mainPresenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.abc);
        mainPresenter.getCookCategory();
    }

    public void changeName(View view) {
        //testApk();
        startActivity(new Intent(this, AnimationActivity.class));
        // 淡入淡出的动画效果
        //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        // 从左向右滑动的效果
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        //mainPresenter.test();
        /*Observable.interval(3, TimeUnit.SECONDS)
                .compose(RxLifecycle.bind(this).<Long>disposeObservableWhen(LifecycleEvent.DESTROY))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        ToastUtils.showShort(aLong + "数据");
                    }
                });*/
    }

    public void testApk() {
        //下载路径，如果路径无效了，可换成你的下载路径
        //final String url = "http://c.qijingonline.com/test.mkv";
        final String url = "http://test-1251233192.coscd.myqcloud.com/1_1.apk";
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ool/download/";
        File file = new File(path);
        if (!file.exists()) {
            Log.d(TAG, file.mkdirs() + "");
        }
        final File dest = new File(path, url.substring(url.lastIndexOf("/") + 1));
        if (dest.exists()) {
            dest.delete();
        }
        Request request = new Request.Builder().url(url).build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.networkInterceptors().add(chain -> {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse
                    .newBuilder()
                    .body(new FileResponseBody(originalResponse))
                    .build();
        });
        builder.build().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "error");
                // 下载失败
                //e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.body() instanceof FileResponseBody) {

                }
                /*BufferedSink sink = Okio.buffer(Okio.sink(dest));
                Buffer buffer = sink.buffer();
                long contentLength = response.body().contentLength();
                long total = 0;
                long len;
                int bufferSize = 200 * 1024; //200kb

                BufferedSource source = response.body().source();
                while ((len = source.read(buffer, bufferSize)) != -1) {
                    sink.emit();
                    total += len;
                    int progress = (int) (((double) total / contentLength) * 100);
                    formatProgress(progress);
                }
                source.close();
                sink.close();*/
            }
        });
    }

    private long preTime;

    public void formatProgress(int progress) {
        if (progress == 100) {
            preTime = 0;
            Log.d(TAG, "已传输字节" + progress);
            return;
        }
        if (System.currentTimeMillis() - preTime > 1000) {
            Log.d(TAG, "已传输字节" + progress);
            preTime = System.currentTimeMillis();
        }
    }

    @Override
    public void getCookCategory(CookResult cookResult) {
        LogUtils.d(TAG, cookResult.getChilds().size() + "长度");

    }

    @Override
    public void onError(int code) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class FileResponseBody extends ResponseBody{
        Response originalResponse;

        FileResponseBody(Response originalResponse) {
            this.originalResponse = originalResponse;
        }

        @Nullable
        @Override
        public MediaType contentType() {
            return originalResponse.body().contentType();
        }

        @Override
        public long contentLength() {
            return originalResponse.body().contentLength();
        }

        @Override
        public BufferedSource source() {
            return Okio.buffer(new ForwardingSource(originalResponse.body().source()) {
                long bytesReaded = 0;

                @Override
                public long read(@NonNull Buffer sink, long byteCount) throws IOException {
                    long bytesRead = super.read(sink, byteCount);
                    bytesReaded += bytesRead == -1 ? 0 : bytesRead;
                    return bytesRead;
                }
            });
        }
    }
}
