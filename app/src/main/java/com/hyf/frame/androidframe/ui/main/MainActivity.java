package com.hyf.frame.androidframe.ui.main;

import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.hyf.frame.androidframe.R;
import com.hyf.frame.androidframe.databinding.ActivityMainBinding;
import com.hyf.frame.androidframe.ui.BaseActivity;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();
    private long firstTime;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime < 2000) {
            super.onBackPressed();
        } else {
            ToastUtils.showShort("再按一次退出程序");
            firstTime = System.currentTimeMillis();
        }
    }
    /*public void testApk() {
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
                *//*BufferedSink sink = Okio.buffer(Okio.sink(dest));
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
                sink.close();*//*
            }
        });
    }*/

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





    /*private class FileResponseBody extends ResponseBody{
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
    }*/
}
