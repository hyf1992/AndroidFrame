package com.hyf.frame.androidframe.ui.search;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.hyf.frame.androidframe.R;
import com.hyf.frame.androidframe.databinding.ActivitySearchBinding;
import com.hyf.frame.androidframe.ui.BaseActivity;


public class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchViewModel> implements SearchContract.View {


    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showError(int code) {

    }

    public void getNestedScrollView(View view) {
        ViewCompat.offsetTopAndBottom(view, 10);
    }
}
