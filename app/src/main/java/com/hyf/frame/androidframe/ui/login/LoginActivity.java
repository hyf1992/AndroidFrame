package com.hyf.frame.androidframe.ui.login;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.hyf.frame.androidframe.R;
import com.hyf.frame.androidframe.databinding.ActivityLoginBinding;
import com.hyf.frame.androidframe.rxjava.RxSchedulers;
import com.hyf.frame.androidframe.ui.BaseActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {
    @Inject
    LoginViewModel loginViewModel;

    private static void onChanged(Integer code) {
        switch (code) {
            case 0:
                ToastUtils.showShort("错误码是" + code);
                break;
        }
    }

    @Override
    protected void setContentView() {
        ActivityLoginBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        dataBinding.setLoginViewModel(loginViewModel);
        loginViewModel.getErrorData().observe(this, LoginActivity::onChanged);
    }

    @Override
    protected void initData() {
        loginViewModel.getCookCategory();
    }

    public void hyf(View view) {
        getSupportLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<String>() {
            @Override
            public Loader<String> onCreateLoader(int id, Bundle args) {

                return new StringLoader(LoginActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<String> loader, final String data) {
                ToastUtils.showShort(data);
            }

            @Override
            public void onLoaderReset(Loader<String> loader) {

            }
        });
    }

    static class StringLoader extends AsyncTaskLoader<String> {

        private StringLoader(Context context) {
            super(context);
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        public String loadInBackground() {
            return "hyf";
        }
    }
}
