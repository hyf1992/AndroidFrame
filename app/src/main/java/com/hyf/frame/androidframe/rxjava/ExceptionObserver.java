package com.hyf.frame.androidframe.rxjava;

import com.hyf.frame.androidframe.ui.BaseActivity;
import com.hyf.frame.androidframe.ui.BasePresenter;
import com.hyf.frame.androidframe.ui.BaseView;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DefaultObserver;

/**
 * Created by hyf on 2018/3/27.
 */

public abstract class ExceptionObserver<T> extends DefaultObserver<T> {
    private BasePresenter presenter;

    protected ExceptionObserver(BasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof CustomException) {
            presenter.onError(((CustomException) e).getErrCode());
        } else {
            //TODO

        }
    }

    @Override
    public void onComplete() {

    }
}


