package com.hyf.frame.androidframe;

import android.os.Environment;
import android.util.Log;

import org.junit.Test;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSink;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        testApk();
    }


    public static void testApk() {
        //下载路径，如果路径无效了，可换成你的下载路径
        //final String url = "http://c.qijingonline.com/test.mkv";
        final String url = "http://app.ool.vc/downloads/ool-app.apk";
        final File dest = new File("D:/", url.substring(url.lastIndexOf("/") + 1));

        if (dest.exists()) {
            dest.mkdir();
        }
        Request request = new Request.Builder().url(url).build();
        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.print(e.getMessage());
                // 下载失败
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Sink sink = null;
                BufferedSink bufferedSink = null;
                try {
                    //String mSDCardPath= Environment.getExternalStorageDirectory().getAbsolutePath();
                    String mSDCardPath = "D:/";

                    sink = Okio.sink(dest);
                    bufferedSink = Okio.buffer(sink);
                    System.out.print(bufferedSink.writeAll(response.body().source()));
                    bufferedSink.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bufferedSink != null) {
                        bufferedSink.close();
                    }
                }
            }
        });
    }

    public static void testGzip() {

        /*Sink sink = null;

        BufferedSink bufferedSink = null;

        GzipSink gzipSink = null;

        try {

            File dest = new File("D:/gzip.txt");

            sink = Okio.sink(dest);

            gzipSink = new GzipSink(sink);

            bufferedSink = Okio.buffer(gzipSink);

            bufferedSink.writeUtf8("android vs ios");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            closeQuietly(bufferedSink);

        }*/

        Source source = null;

        BufferedSource bufferedSource = null;

        GzipSource gzipSource = null;

        try {

            File file = new File("D:/gzip.txt");

            source = Okio.source(file);

            gzipSource = new GzipSource(source);

            bufferedSource = Okio.buffer(gzipSource);

            String content = bufferedSource.readUtf8();

            System.out.println(content);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            closeQuietly(bufferedSource);

        }
    }

    public static void testSource() {
        Source source = null;

        BufferedSource bufferedSource = null;

        try {

            File file = new File("D:/test.txt");

            source = Okio.source(file);

            bufferedSource = Okio.buffer(source);

            String content = bufferedSource.readUtf8();

            System.out.println(content);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            closeQuietly(bufferedSource);

        }

    }

    private static void testSink() {
        Sink sink = null;

        BufferedSink bufferedSink = null;

        try {

            File dest = new File("D:/dest.txt");

            sink = Okio.sink(dest);

            bufferedSink = Okio.buffer(sink);

            bufferedSink.writeUtf8("11111111111");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            closeQuietly(bufferedSink);

        }
    }

    public static void closeQuietly(Closeable closeable) {

        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception ignored) {

            }

        }

    }
}