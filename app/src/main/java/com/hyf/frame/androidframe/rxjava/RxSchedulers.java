package com.hyf.frame.androidframe.rxjava;

import android.app.Activity;

import com.hyf.frame.androidframe.beans.MobResult;

import cn.nekocode.rxlifecycle.LifecycleEvent;
import cn.nekocode.rxlifecycle.RxLifecycle;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hyf on 2018/3/27.
 */

public class RxSchedulers {
    private static CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public static <T> ObservableTransformer<T, T> io_main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .flatMap(new Function<T, ObservableSource<T>>() {
                            @Override
                            public ObservableSource<T> apply(T t) throws Exception {
                                if (t instanceof MobResult) {
                                    MobResult mobResult = (MobResult) t;
                                    if ("success".equals(mobResult.getMsg())) {
                                        return Observable.just(t);
                                    } else {
                                        return Observable.error(new CustomException(mobResult.getRetCode()));
                                    }
                                }
                                return Observable.empty();
                            }
                        })
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                mCompositeDisposable.add(disposable);
                            }
                        })
                        .doFinally(new Action() {
                            @Override
                            public void run() throws Exception {

                            }
                        });
            }
        };
    }

    //取消订阅
    public static void clear() {
        mCompositeDisposable.clear();
    }
}
