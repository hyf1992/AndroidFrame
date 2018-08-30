package com.hyf.frame.androidframe.dagger;

import android.app.Application;
import android.content.Context;

import com.hyf.frame.androidframe.ui.behavior.BehaviorActivity;
import com.hyf.frame.androidframe.ui.behavior.BehaviorModule;
import com.hyf.frame.androidframe.ui.login.LoginActivity;
import com.hyf.frame.androidframe.ui.login.LoginModule;
import com.hyf.frame.androidframe.ui.main.MainActivity;
import com.hyf.frame.androidframe.ui.main.MainModule;
import com.hyf.frame.androidframe.ui.search.SearchActivity;
import com.hyf.frame.androidframe.ui.search.SearchModule;

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

    @ActivityScope
    @ContributesAndroidInjector(modules = BehaviorModule.class)
    abstract BehaviorActivity behaviorActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = SearchModule.class)
    abstract SearchActivity searchActivity();
}
