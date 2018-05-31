package com.hyf.frame.androidframe.beans;

import java.io.Serializable;

/**
 * Created by hyf on 2017/6/13.
 */

public class HttpResult<T> implements Serializable {
    private int code = 200;
    private int specialCode;
    private String msg;
    private T datas;

    public HttpResult() {
    }

    public HttpResult(T datas) {
        this.datas = datas;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public int getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(int specialCode) {
        this.specialCode = specialCode;
    }
}
