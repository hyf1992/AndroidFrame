package com.hyf.frame.androidframe.ui.main;

import android.app.Activity;

import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.dagger.ActivityScope;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.network.HttpClient;
import com.hyf.frame.androidframe.rxjava.RxSchedulers;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by hyf on 2018/3/26.
 */
@ActivityScope
public class MainModel implements MainContract.Model {

    @Inject
    MainModel() {
    }

    @Override
    public Observable<MobResult<CookResult>> getCookCategory() {
        return HttpClient.getInstance().getDefaultService().getCookCategory()
                .compose(RxSchedulers.<MobResult<CookResult>>io_main());
    }
}
