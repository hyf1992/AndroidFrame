package com.hyf.frame.androidframe.ui.main;


import android.databinding.BindingAdapter;
import android.view.View;

public class MainViewModel {
    private int padding = 16;

    public int getPadding() {
        return padding;
    }

    @BindingAdapter("android:hyf")
    public static void setPaddingLeft(View view, int padding) {
        view.setPadding(padding,
                view.getPaddingTop(),
                view.getPaddingRight(),
                view.getPaddingBottom());
    }
}
