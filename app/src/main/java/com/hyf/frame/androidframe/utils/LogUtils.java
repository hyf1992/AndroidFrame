package com.hyf.frame.androidframe.utils;

import android.util.Log;

public class LogUtils {
    private static int level = Log.ERROR;

    public static void v(String tag, String msg) {
        if (level <= Log.VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (level <= Log.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (level <= Log.INFO) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (level <= Log.WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (level <= Log.ERROR) {
            Log.e(tag, msg);
        }
    }

}
