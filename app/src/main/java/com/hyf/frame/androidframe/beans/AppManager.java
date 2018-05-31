package com.hyf.frame.androidframe.beans;

import android.app.Activity;

import java.util.Stack;

public class AppManager {

    private static volatile AppManager appManager;
    private Stack<Activity> activityStack;

    public static AppManager getInstance() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    private AppManager() {
        activityStack = new Stack<>();
    }


    public boolean addActivity(Activity activity) {
        return activityStack.add(activity);
    }

    public boolean removeActivity(Activity activity) {
        return activityStack.remove(activity);
    }

    //结束所有
    public void finishAllActivity() {
        for (Activity activity : activityStack) {
            activity.finish();
        }
        activityStack.clear();
    }

    //返回数量
    public int getActivitySize() {
        if (activityStack != null) {
            return activityStack.size();
        }
        return 0;
    }

}
