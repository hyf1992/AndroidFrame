package com.hyf.frame.androidframe.entities;

import java.util.List;

/**
 * Created by hyf on 2017/9/30.
 */

public final class Child {
    private CategoryInfo categoryInfo;
    private List<CategoryInfo> childs;

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public List<CategoryInfo> getChilds() {
        return childs;
    }

    public void setChilds(List<CategoryInfo> childs) {
        this.childs = childs;
    }
}
