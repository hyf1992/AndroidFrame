package com.hyf.frame.androidframe.entities;

/**
 * Created by hyf on 2017/9/30.
 */

public final class CategoryInfo {
    private String parentId;
    private String ctgId;
    private String name;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCtgId() {
        return ctgId;
    }

    public void setCtgId(String ctgId) {
        this.ctgId = ctgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
