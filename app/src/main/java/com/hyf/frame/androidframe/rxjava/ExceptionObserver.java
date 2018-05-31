package com.hyf.frame.androidframe.rxjava;

import android.content.Context;
import android.content.Intent;

import com.alibaba.fastjson.JSONException;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.hyf.frame.androidframe.beans.HttpResult;
import com.hyf.frame.androidframe.ui.BaseView;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import io.reactivex.observers.DefaultObserver;
import retrofit2.HttpException;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by hyf on 2018/3/27.
 */

public abstract class ExceptionObserver<T> extends DefaultObserver<T> {
    public static final int CAST_CODE = 0;
    private BaseView view;

    public ExceptionObserver(BaseView view) {
        this.view = view;
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof HttpResultException) {
            httpResultException(((HttpResultException) t).getResult());
        } else {
            elseException(t);
        }
    }

    @Override
    public void onComplete() {

    }

    private void httpResultException(HttpResult result) {
        view.showError(result.getCode());
        switch (result.getCode()) {

            default:

                break;
        }
    }


    /**
     * 其他异常
     *
     * @param throwable
     */
    private void elseException(Throwable throwable) {

    }
}


