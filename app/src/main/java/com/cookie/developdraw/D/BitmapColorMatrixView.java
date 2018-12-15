package com.cookie.developdraw.D;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.cookie.developdraw.R;

public class BitmapColorMatrixView extends View {

    private Paint mPaint = new Paint();
    private Bitmap bitmap;// 位图

    public BitmapColorMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint.setAntiAlias(true);
        // 获取位图
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制原始位图
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()), mPaint);
        //高宽比乘以500就得到了宽度为500时对应的高度

        canvas.translate(510, 0);
        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()), mPaint);
    }
}
