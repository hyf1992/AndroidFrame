package com.hyf.frame.androidframe.rxjava;


import com.hyf.frame.androidframe.beans.HttpResult;

/**
 * Created by hyf on 2017/10/9.
 */

public class HttpResultException extends RuntimeException {
    private HttpResult result;
    private int code;

    public HttpResultException(int code) {
        this.code = code;
    }

    public HttpResultException(HttpResult result) {
        this.result = result;
    }

    public HttpResult getResult() {
        return result;
    }

    public void setResult(HttpResult result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
