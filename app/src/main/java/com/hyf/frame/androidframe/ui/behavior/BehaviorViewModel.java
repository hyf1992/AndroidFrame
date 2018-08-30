package com.hyf.frame.androidframe.ui.behavior;


import android.arch.lifecycle.ViewModel;

import com.hyf.frame.androidframe.dagger.ActivityScope;

@ActivityScope
public class BehaviorViewModel extends ViewModel implements BehaviorContract.View {
    private BehaviorModel model;

    public BehaviorViewModel(BehaviorModel model) {
        this.model = model;
    }

    @Override
    public void showError(int code) {

    }
}
