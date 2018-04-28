package com.hyf.frame.androidframe.entities;

import java.util.List;

/**
 * Created by hyf on 2017/9/30.
 */

public final class CookResult {
    private CategoryInfo categoryInfo;
    private List<Child> childs;

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }
}
