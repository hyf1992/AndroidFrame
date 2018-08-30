package com.hyf.frame.androidframe.ui.behavior;


import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.hyf.frame.androidframe.R;
import com.hyf.frame.androidframe.databinding.ActivityBehaviorBinding;
import com.hyf.frame.androidframe.ui.BaseActivity;


public class BehaviorActivity extends BaseActivity<ActivityBehaviorBinding, BehaviorViewModel> implements BehaviorContract.View {


    @Override
    protected int getLayout() {
        return R.layout.activity_behavior;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showError(int code) {

    }
    public void onViewClicked(View view) {
        Snackbar.make(view,"hyf",Snackbar.LENGTH_SHORT).show();
    }
    public void getNestedScrollView(View view) {
        ViewCompat.offsetTopAndBottom(view, 10);
    }
}
