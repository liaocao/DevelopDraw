package com.cookie.developdraw.C;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DiscretePathEffectView extends View{

    public DiscretePathEffectView(Context context) {
        super(context);
    }

    public DiscretePathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = getPaint();
        Path path = getPath();
        //第一条原生Path
        canvas.drawPath(path,paint);
        //第二条Path
        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(2,5));
        canvas.drawPath(path,paint);
        //第三条Path
        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(6,5));
        canvas.drawPath(path,paint);
        //第三条Path
        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(16,5));
        canvas.drawPath(path,paint);
        //第四条Path
        canvas.translate(0,200);
        paint.setPathEffect(new DiscretePathEffect(6,15));
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
}
