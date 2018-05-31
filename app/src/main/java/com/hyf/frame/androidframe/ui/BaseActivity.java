package com.hyf.frame.androidframe.ui;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.hyf.frame.androidframe.R;
import com.hyf.frame.androidframe.rxjava.RxSchedulers;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by hyf on 2018/3/26.
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends ViewModel> extends DaggerAppCompatActivity {
    protected ImmersionBar mImmersionBar;
    private Unbinder unbinder;
    protected T dataBinding;
    @Inject
    protected V viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        doBeforeContentView();
        initData();
        initView(savedInstanceState);
    }

    private void doBeforeContentView() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mImmersionBar = ImmersionBar.with(this);
        int layoutId = getLayout();
        if (layoutId != 0) {
            dataBinding = DataBindingUtil.setContentView(this, getLayout());
        }
        unbinder = ButterKnife.bind(this);
    }


    protected void skipActivity(Class<?> cls) {
        skipActivity(cls, null);
    }

    protected void skipActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) intent.putExtras(bundle);
        startActivity(intent);
    }

    protected abstract int getLayout();

    protected abstract void initData();

    protected void initView(Bundle savedInstanceState) {
        Toolbar toolbar = findViewById(R.id.tool_bar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(this::navigationOnClick);
            TextView titleView = findViewById(R.id.toolbar_title);
            if (!AppUtils.getAppName().contentEquals(getTitle())) {
                titleView.setText(getTitle());
            }
        }
        mImmersionBar.statusBarDarkFont(true).statusBarColor(R.color.colorPrimary).init();
    }

    protected void navigationOnClick(View view) {
        onBackPressed();
    }


    /**
     * 开启加载进度条
     */
    public void startProgressDialog() {

    }

    /**
     * 停止加载默认进度条
     */
    public void stopProgressDialog() {

    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        RxSchedulers.clear();
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }
}
