package com.hyf.frame.androidframe.ui.search;


import com.hyf.frame.androidframe.dagger.ActivityScope;

import javax.inject.Inject;

/**
 * Created by hyf on 2018/3/26.
 */
@ActivityScope
public class SearchModel implements SearchContract.Model {
    private SearchActivity activity;

    @Inject
    SearchModel(SearchActivity activity) {
        this.activity = activity;
    }
}
