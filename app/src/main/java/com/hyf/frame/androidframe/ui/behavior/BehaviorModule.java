package com.hyf.frame.androidframe.ui.behavior;


import android.arch.lifecycle.ViewModelProviders;

import com.hyf.frame.androidframe.beans.ViewModelFactory;
import com.hyf.frame.androidframe.dagger.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hyf on 2018/3/26.
 */
@Module
public abstract class BehaviorModule {
    @Provides
    @ActivityScope
    static BehaviorViewModel provideViewModel(BehaviorActivity activity, BehaviorModel model) {
        return ViewModelProviders.of(activity, ViewModelFactory.getInstance().setModel(model)).get(BehaviorViewModel.class);
    }
}
