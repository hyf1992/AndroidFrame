package com.hyf.frame.androidframe.ui.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.blankj.utilcode.util.ToastUtils;
import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.dagger.ActivityScope;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.entities.User;
import com.hyf.frame.androidframe.rxjava.ExceptionObserver;
import com.hyf.frame.androidframe.ui.BaseActivity;


@ActivityScope
public class LoginViewModel extends ViewModel implements LoginContract.Presenter {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<CookResult> cookResult = new ObservableField<>();
    private final MutableLiveData<Integer> errorData = new MutableLiveData<>();
    private LoginModel model;

    public LoginViewModel(LoginModel model) {
        this.model = model;
    }

    @Override
    public void getUser() {
        model.getUser().subscribe(new ExceptionObserver<MobResult<User>>(this) {
            @Override
            public void onNext(MobResult<User> userMobResult) {
                name.set(userMobResult.getResult().getUsername());
            }
        });
    }

    @Override
    public void getCookCategory() {
        model.getCookCategory().subscribe(new ExceptionObserver<MobResult<CookResult>>(this) {
            @Override
            public void onNext(MobResult<CookResult> cookResultMobResult) {
                cookResult.set(cookResultMobResult.getResult());
            }
        });
    }

    @Override
    public void onError(int code) {
        errorData.setValue(code);
    }

    public MutableLiveData<Integer> getErrorData() {
        return errorData;
    }
}
