package com.hyf.frame.androidframe.rxjava;

/**
 * Created by hyf on 2018/3/27.
 */

public class CustomException extends Exception {
    private int errCode;

    public CustomException(int errCode){
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
