package com.hyf.frame.androidframe.ui.login;

import android.arch.lifecycle.ViewModel;

import com.hyf.frame.androidframe.dagger.ActivityScope;


@ActivityScope
public class LoginViewModel extends ViewModel implements LoginContract.View {
    private LoginModel model;

    public LoginViewModel(LoginModel model) {
        this.model = model;
    }



    @Override
    public void showError(int code) {

    }
}
