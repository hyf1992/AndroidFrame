package com.hyf.frame.androidframe.ui.main;

import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.dagger.ActivityScope;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.rxjava.ExceptionObserver;

import javax.inject.Inject;

/**
 * Created by hyf on 2018/3/26.
 */
@ActivityScope
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainModel model;

    @Inject
    MainPresenter(MainModel model, MainContract.View view) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void getCookCategory() {
        model.getCookCategory().subscribe(new ExceptionObserver<MobResult<CookResult>>(this) {
            @Override
            public void onNext(MobResult<CookResult> cookResultMobResult) {
                view.getCookCategory(cookResultMobResult.getResult());
            }
        });
    }

    @Override
    public void onError(int code) {

    }
}
