package com.hyf.frame.androidframe.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hyf.frame.androidframe.rxjava.RxSchedulers;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DaggerActivity;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by hyf on 2018/3/26.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView();
        initData();
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    protected abstract void setContentView();

    protected abstract void initData();

    @Override
    protected void onPause() {
        super.onPause();
        RxSchedulers.clear();
    }
}
