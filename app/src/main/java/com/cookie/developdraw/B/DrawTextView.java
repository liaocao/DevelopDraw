package com.cookie.developdraw.B;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawTextView extends View {

    public DrawTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int baseLineX = 0 ;
        int baseLineY = 200;

        //画基线
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);

        //写文字
        paint.setColor(Color.GREEN);
        paint.setTextSize(120); //以px为单位
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("harvic\'s blog", baseLineX, baseLineY, paint);
    }
}