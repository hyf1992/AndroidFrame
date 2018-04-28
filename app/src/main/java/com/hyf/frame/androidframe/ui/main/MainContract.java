package com.hyf.frame.androidframe.ui.main;

import com.hyf.frame.androidframe.beans.MobResult;
import com.hyf.frame.androidframe.entities.CookResult;
import com.hyf.frame.androidframe.ui.BaseModel;
import com.hyf.frame.androidframe.ui.BasePresenter;
import com.hyf.frame.androidframe.ui.BaseView;

import io.reactivex.Observable;

/**
 * Created by hyf on 2018/3/26.
 */

public interface MainContract {

    interface Model extends BaseModel {
        Observable<MobResult<CookResult>> getCookCategory();
    }

    interface Presenter extends BasePresenter {
        void getCookCategory();
    }

    interface View extends BaseView {
        void getCookCategory(CookResult cookResult);
    }
}
