package com.hyf.frame.androidframe.ui.main;


import android.arch.lifecycle.ViewModel;

import com.hyf.frame.androidframe.dagger.ActivityScope;

@ActivityScope
public class MainViewModel extends ViewModel implements MainContract.View {
    private MainModel model;

    public MainViewModel(MainModel model) {
        this.model = model;
    }

    @Override
    public void showError(int code) {

    }
}
