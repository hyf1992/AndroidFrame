package com.hyf.frame.androidframe.ui.main;


import com.hyf.frame.androidframe.beans.DeviceList;
import com.hyf.frame.androidframe.beans.HttpResult;
import com.hyf.frame.androidframe.dagger.ActivityScope;
import com.hyf.frame.androidframe.entities.DeviceInfo;
import com.hyf.frame.androidframe.network.HttpClient;
import com.hyf.frame.androidframe.rxjava.RxSchedulers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by hyf on 2018/3/26.
 */
@ActivityScope
public class MainModel implements MainContract.Model {
    private MainActivity activity;

    @Inject
    MainModel(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public Observable<HttpResult<List<DeviceInfo>>> getDevices(DeviceList deviceList) {
        return HttpClient.getInstance().getDefaultService().getDevices(deviceList)
                .compose(RxSchedulers.io_main(activity));
    }
}
