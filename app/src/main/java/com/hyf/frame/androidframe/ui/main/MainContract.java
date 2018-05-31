package com.hyf.frame.androidframe.ui.main;

import com.hyf.frame.androidframe.beans.DeviceList;
import com.hyf.frame.androidframe.beans.HttpResult;
import com.hyf.frame.androidframe.entities.DeviceInfo;
import com.hyf.frame.androidframe.ui.BaseModel;
import com.hyf.frame.androidframe.ui.BaseView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by hyf on 2018/3/26.
 */

public interface MainContract {

    interface Model extends BaseModel {
        Observable<HttpResult<List<DeviceInfo>>> getDevices(DeviceList deviceList);
    }

    interface View extends BaseView {

    }
}
