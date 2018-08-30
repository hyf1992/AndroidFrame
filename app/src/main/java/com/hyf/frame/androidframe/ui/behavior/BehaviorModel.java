package com.hyf.frame.androidframe.ui.behavior;


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
public class BehaviorModel implements BehaviorContract.Model {
    private BehaviorActivity activity;

    @Inject
    BehaviorModel(BehaviorActivity activity) {
        this.activity = activity;
    }
}
