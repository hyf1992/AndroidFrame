package com.hyf.frame.androidframe.beans;

import java.util.List;

/**
 * Created by hyf on 2018/5/7
 */
public class DeviceList {
    private List<String> deviceList;

    public DeviceList() {
    }

    public DeviceList(List<String> deviceList) {
        this.deviceList = deviceList;
    }

    public List<String> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<String> deviceList) {
        this.deviceList = deviceList;
    }
}
