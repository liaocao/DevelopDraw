package com.cookie.developdraw.D;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.cookie.developdraw.R;

public class XfermodeView extends View{

    private Paint mPaint;
    private Bitmap mBmp;

    public XfermodeView(Context context) {
        super(context);
        mPaint = new Paint();
        mBmp = BitmapFactory.decodeResource(getResources(),R.mipmap.dog);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);//禁用硬件加速：view级别以下
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width  = 500;
        int height = width * mBmp.getHeight()/mBmp.getWidth();
        mPaint.setColor(Color.RED);

        int layerID = canvas.saveLayer(0,0,width,height,mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
//        mPaint.setXfermode(new AvoidXfermode(Color.WHITE,100, AvoidXfermode.Mode.TARGET));
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.flower),null,new Rect(0,0,width,height),mPaint);

        canvas.restoreToCount(layerID);
    }
}
