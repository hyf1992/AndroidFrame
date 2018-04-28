package com.hyf.frame.androidframe.network;

import com.hyf.frame.androidframe.app.Constants;

/**
 * Created by hyf on 2018/3/27.
 */

public class HostType {
    private static final int DEFAULT_HOST = 0;

    /**
     * 根据host类型获取请求地址
     *
     * @param hostType
     * @return
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            default:
                host = Constants.DEFAULT_HOST;
                break;
        }
        return host;
    }
}
