package com.hyf.frame.androidframe.dagger;

import android.app.Application;

import com.hyf.frame.androidframe.app.CustomApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by hyf on 2018/3/26.
 */
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<CustomApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();

    }
}
