package com.hyf.frame.androidframe.ui.login;

import android.arch.lifecycle.ViewModelProviders;

import com.hyf.frame.androidframe.beans.ViewModelFactory;
import com.hyf.frame.androidframe.dagger.ActivityScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public abstract class LoginModule {

    @Provides
    @ActivityScope
    static LoginViewModel provideViewModel(LoginActivity activity, LoginModel model) {
        return ViewModelProviders.of(activity, ViewModelFactory.getInstance().setModel(model)).get(LoginViewModel.class);
    }
}
