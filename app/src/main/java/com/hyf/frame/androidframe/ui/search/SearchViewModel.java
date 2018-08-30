package com.hyf.frame.androidframe.ui.search;


import android.arch.lifecycle.ViewModel;

import com.hyf.frame.androidframe.dagger.ActivityScope;

@ActivityScope
public class SearchViewModel extends ViewModel implements SearchContract.View {
    private SearchModel model;

    public SearchViewModel(SearchModel model) {
        this.model = model;
    }

    @Override
    public void showError(int code) {

    }
}
