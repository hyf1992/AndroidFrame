package com.hyf.frame.androidframe.beans;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hyf.frame.androidframe.ui.BaseModel;
import com.hyf.frame.androidframe.ui.login.LoginModel;
import com.hyf.frame.androidframe.ui.login.LoginViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final BaseModel model;


    public static ViewModelFactory getInstance(BaseModel model) {

        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(model);
                }
            }
        }
        return INSTANCE;
    }


    private ViewModelFactory(BaseModel model) {
        this.model = model;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel((LoginModel) model);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
