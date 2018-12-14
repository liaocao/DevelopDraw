package com.cookie.developdraw.B;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class BezierView extends View {

    public BezierView(Context context) {
        super(context);
    }

    public BezierView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);

        Path path = new Path();
        path.moveTo(100,300);//起点坐标
        path.quadTo(200,200,300,300);//控制点坐标 中间点坐标
        path.quadTo(400,400,500,300);//控制点坐标 终点坐标

        canvas.drawPath(path,paint);
    }
}
