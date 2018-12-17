package com.cookie.developdraw.F;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.cookie.developdraw.R;

public class SaveLayerUseExample_3_1 extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    public SaveLayerUseExample_3_1(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,0,0,mPaint);

        int layerID = canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);
        canvas.skew(1.732f,0);//倾斜60度
        canvas.drawRect(0,0,150,160,mPaint);
        canvas.restoreToCount(layerID);
    }
}
