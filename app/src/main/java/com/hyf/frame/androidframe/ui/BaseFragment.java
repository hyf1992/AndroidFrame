package com.hyf.frame.androidframe.ui;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by hyf on 2018/5/10
 */
public abstract class BaseFragment<T extends ViewDataBinding, V extends ViewModel> extends DaggerFragment {
    protected T dataBinding;
    protected V viewModel;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        View rootView = dataBinding.getRoot();
        unbinder = ButterKnife.bind(this, rootView);
        //noinspection unchecked
        viewModel = (V) ((BaseActivity) Objects.requireNonNull(getActivity())).viewModel;
        initData();
        initView();
        return rootView;
    }

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
