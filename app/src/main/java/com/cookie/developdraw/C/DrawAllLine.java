package com.cookie.developdraw.C;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawAllLine extends View {

    public DrawAllLine(Context context) {
        super(context);
    }

    public DrawAllLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStrokeWidth(80);
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100,200,400,200,paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100,400,400,400,paint);

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100,600,400,600,paint);

        //垂直画出x=100这条线
        paint.reset();
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        canvas.drawLine(100,50,100,750,paint);
    }
}
