package com.hyf.frame.androidframe.ui.main;

import com.hyf.frame.androidframe.dagger.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * Created by hyf on 2018/3/26.
 */
@Module
public abstract class MainModule {
    @ActivityScope
    @Binds
    abstract MainContract.Model model(MainModel mainModel);

    @ActivityScope
    @Binds
    abstract MainContract.Presenter presenter(MainPresenter mainPresenter);

    @ActivityScope
    @Binds
    abstract MainContract.View view(MainActivity mainActivity);
}
