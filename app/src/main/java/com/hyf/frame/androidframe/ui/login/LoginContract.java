package com.hyf.frame.androidframe.ui.login;

import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.entities.User;
import com.hyf.frame.androidframe.ui.BaseModel;
import com.hyf.frame.androidframe.ui.BaseView;

import io.reactivex.Observable;

public interface LoginContract {
    interface Model extends BaseModel {
        Observable<MobResult<CookResult>> getCookCategory();
        Observable<MobResult<User>> getUser();
    }

    interface View extends BaseView {

    }
}
