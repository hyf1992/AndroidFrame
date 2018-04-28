package com.hyf.frame.androidframe.dagger;

import android.app.Application;
import android.content.Context;

import com.hyf.frame.androidframe.ui.login.LoginActivity;
import com.hyf.frame.androidframe.ui.login.LoginModule;
import com.hyf.frame.androidframe.ui.main.MainActivity;
import com.hyf.frame.androidframe.ui.main.MainModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by hyf on 2018/3/26.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();
}
