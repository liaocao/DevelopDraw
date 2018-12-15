package com.cookie.developdraw.D;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.cookie.developdraw.R;

public class LightingColorFilterView extends View{

    private Paint mPaint;
    private Bitmap mBmp;
    
    public LightingColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

        mBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.btn);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);

        int width  = 500;
        int height = width * mBmp.getHeight()/mBmp.getWidth();

        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);

        canvas.translate(0,550);
        mPaint.setColorFilter(new LightingColorFilter(0x00ff00,0x000000));
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
    }
}
