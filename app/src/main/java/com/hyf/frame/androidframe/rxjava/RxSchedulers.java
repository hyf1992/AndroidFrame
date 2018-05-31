package com.hyf.frame.androidframe.rxjava;



import com.hyf.frame.androidframe.beans.HttpResult;
import com.hyf.frame.androidframe.ui.BaseActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static com.hyf.frame.androidframe.rxjava.ExceptionObserver.CAST_CODE;


/**
 * Created by hyf on 2017/6/13.
 */

public class RxSchedulers {
    private static CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    /**
     * 线程统一管理(自带加载中)
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> io_main() {
        return io_main(null);
    }

    public static <T> ObservableTransformer<T, T> io_main(BaseActivity activity) {
        return upstream -> upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap((Function<T, ObservableSource<T>>) t -> {
                    if (t instanceof HttpResult) {
                        if (((HttpResult) t).getCode() == 200) {
                            return Observable.just(t);
                        } else {
                            return Observable.error(new HttpResultException((HttpResult) t));
                        }
                    }
                    return Observable.error(new HttpResultException(CAST_CODE));
                }).doOnSubscribe(disposable -> {
                    if (activity != null) {
                        activity.startProgressDialog();
                    }
                    mCompositeDisposable.add(disposable);
                }).doFinally(() -> {
                    if (activity != null) {
                        activity.stopProgressDialog();
                    }
                });
    }

    //取消订阅
    public static void clear() {
        mCompositeDisposable.clear();
    }

}
