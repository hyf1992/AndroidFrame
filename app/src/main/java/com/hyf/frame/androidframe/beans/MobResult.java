package com.hyf.frame.androidframe.beans;

/**
 * Created by hyf on 2017/9/29.
 */

public final class MobResult<T> {
    private String msg = "success";
    private int retCode;
    private T result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
