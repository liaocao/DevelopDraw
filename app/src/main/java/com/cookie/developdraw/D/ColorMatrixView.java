package com.cookie.developdraw.D;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ColorMatrixView extends View {

    private Paint mPaint = new Paint();
    private Bitmap bitmap;// 位图

    public ColorMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        mPaint.setARGB(255,200,100,100);
        // 绘制原始位图
        canvas.drawRect(0,0,500,600,mPaint);

        canvas.translate(550,0);//画布的坐标点往右移动了550
        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });//去掉了红色和绿色值，只留下蓝色通道
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawRect(0,0,500,600,mPaint);
    }
}
