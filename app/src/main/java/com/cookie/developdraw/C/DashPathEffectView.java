package com.cookie.developdraw.C;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class DashPathEffectView extends View {

    private int dx;

    public DashPathEffectView(Context context) {
        super(context);
    }

    public DashPathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = getPaint();
        Path path = new Path();
        path.moveTo(100,600);
        path.lineTo(400,100);
        path.lineTo(700,900);

        canvas.drawPath(path, paint);
        paint.setColor(Color.RED);

        //使用DashPathEffect画线段
        paint.setPathEffect(new DashPathEffect(new float[]{20,10,100,100},0));
        canvas.translate(0,100);
        canvas.drawPath(path,paint);

        //画同一条线段,偏移值为15
        paint.setPathEffect(new DashPathEffect(new float[]{20,10,100,100},dx));
        paint.setColor(Color.YELLOW);
        canvas.translate(0,100);
        canvas.drawPath(path,paint);
    }

    private Paint getPaint(){
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public void startAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0,230);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
