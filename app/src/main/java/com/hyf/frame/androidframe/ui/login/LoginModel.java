package com.hyf.frame.androidframe.ui.login;


import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.dagger.ActivityScope;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.entities.User;
import com.hyf.frame.androidframe.network.HttpClient;
import com.hyf.frame.androidframe.rxjava.RxSchedulers;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;

/**
 * Created by hyf on 2018/3/26.
 */
@ActivityScope
public class LoginModel implements LoginContract.Model {
    private LoginActivity activity;

    @Inject
    LoginModel(LoginActivity activity) {
        this.activity = activity;
    }

    @Override
    public Observable<MobResult<CookResult>> getCookCategory() {
        return HttpClient.getInstance().getDefaultService().getCookCategory()
                .compose(RxSchedulers.<MobResult<CookResult>>io_main());
    }

    @Override
    public Observable<MobResult<User>> getUser() {
        MobResult<User> mobResult = new MobResult<>();
        mobResult.setResult(new User());
        return Observable.just(mobResult)
                .compose(RxSchedulers.<MobResult<User>>io_main());
    }

}
