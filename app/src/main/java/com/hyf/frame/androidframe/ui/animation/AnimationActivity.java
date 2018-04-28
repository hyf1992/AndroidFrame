package com.hyf.frame.androidframe.ui.animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.hyf.frame.androidframe.R;

public class AnimationActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

    }

    public void animation(View view) {
        float curTranslationX = button.getTranslationX();
        /*ObjectAnimator animator = ObjectAnimator.ofFloat(button, "translationX", curTranslationX, 300, curTranslationX);
        animator.setDuration(10000);
        animator.start();*/
        /*TranslateAnimation animation = new TranslateAnimation(curTranslationX, 150, 0, 0);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1,2,1,2);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(3000);
        animationSet.addAnimation(animation);
        animationSet.addAnimation(scaleAnimation);

        button.startAnimation(animationSet);*/

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
        valueAnimator.setDuration(3000);
        valueAnimator.setStartDelay(500);
        valueAnimator.addUpdateListener(animation -> {
            float currentValue = (float) animation.getAnimatedValue();
            //button.getLayoutParams().width = (int) currentValue;
            Log.d("hyf", "当前值为" + currentValue);
        });
        valueAnimator.start();

    }
}
