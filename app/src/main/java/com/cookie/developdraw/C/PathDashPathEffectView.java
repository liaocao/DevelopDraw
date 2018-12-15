package com.cookie.developdraw.C;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class PathDashPathEffectView extends View{

    private int dx = 0;

    public PathDashPathEffectView(Context context) {
        super(context);
    }

    public PathDashPathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawPathDashPathEffect(canvas);
        dx++;
        invalidate();//之所以会无限循环就是因为这里又调用了onDraw
    }

    private Paint getPaint(){
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private Path getPath(){
        Path path = new Path();
        // 定义路径的起点
        path.moveTo(0, 0);

        // 定义路径的各个点
        for (int i = 0; i <= 40; i++) {
            path.lineTo(i*35, (float) (Math.random() * 150));
        }
        return path;
    }

    private void drawPathDashPathEffect(Canvas canvas){
        Paint paint = getPaint();
        Path path = getPath();
        canvas.drawPath(path,paint);

        canvas.translate(0,200);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(),35,0, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(path,paint);

        canvas.translate(0,200);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(),35,0, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path,paint);

        canvas.translate(0,200);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(),35,dx, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawPath(path,paint);
    }

    private Path getStampPath(){
        Path path  = new Path();
        path.moveTo(0,20);
        path.lineTo(10,0);
        path.lineTo(20,20);
        path.close();

        path.addCircle(0,0,3, Path.Direction.CCW);
        return path;
    }

    public void startAnim(){
        ValueAnimator animator = ValueAnimator.ofInt(0, 1030);
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
