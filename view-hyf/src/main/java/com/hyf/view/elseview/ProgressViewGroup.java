package com.hyf.view.elseview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyf.view.R;


public class ProgressViewGroup extends LinearLayout {
    private float progress = 0.25f;
    private Path path;
    private Paint paint;
    private RectF rect;

    public ProgressViewGroup(Context context) {
        this(context, null);
    }

    public ProgressViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rect = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        rect.inset(3, 3);
        setWillNotDraw(false);
    }

    public ProgressViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        path = new Path();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(ContextCompat.getColor(getContext(), R.color.orange_light));
        path.addOval(rect, Path.Direction.CCW);
        canvas.drawPath(path, paint);
        path.reset();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.orange));
        path.addArc(rect, -90, 360 * progress);
        canvas.drawPath(path, paint);
        super.onDraw(canvas);
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }
}
