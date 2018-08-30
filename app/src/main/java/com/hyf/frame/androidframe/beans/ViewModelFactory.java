package com.hyf.frame.androidframe.beans;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.hyf.frame.androidframe.ui.BaseModel;
import com.hyf.frame.androidframe.ui.behavior.BehaviorModel;
import com.hyf.frame.androidframe.ui.behavior.BehaviorViewModel;
import com.hyf.frame.androidframe.ui.login.LoginModel;
import com.hyf.frame.androidframe.ui.login.LoginViewModel;
import com.hyf.frame.androidframe.ui.main.MainModel;
import com.hyf.frame.androidframe.ui.main.MainViewModel;
import com.hyf.frame.androidframe.ui.search.SearchModel;
import com.hyf.frame.androidframe.ui.search.SearchViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private BaseModel model;

    private ViewModelFactory() {

    }

    public static ViewModelFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory();
                }
            }
        }
        return INSTANCE;
    }

    public ViewModelFactory setModel(BaseModel model) {
        this.model = model;
        return this;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (model == null)
            throw new IllegalArgumentException("model can not null");
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel((MainModel) model);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel((LoginModel) model);
        } else if (modelClass.isAssignableFrom(BehaviorViewModel.class)) {
            //noinspection unchecked
            return (T) new BehaviorViewModel((BehaviorModel) model);
        } else if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            //noinspection unchecked
            return (T) new SearchViewModel((SearchModel) model);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
