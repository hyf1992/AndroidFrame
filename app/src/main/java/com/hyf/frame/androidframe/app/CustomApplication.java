package com.hyf.frame.androidframe.app;

import com.blankj.utilcode.util.Utils;
import com.hyf.frame.androidframe.dagger.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import io.realm.Realm;

/**
 * Created by hyf on 2018/3/26.
 */

public class CustomApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        Realm.init(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
