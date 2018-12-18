package com.cookie.developdraw.G;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.cookie.developdraw.R;

public class BitmapShaderTileModeView extends View {

    private Paint mPaint;
    private Bitmap mBmp;
    public BitmapShaderTileModeView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderTileModeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaderTileModeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_edge);
        mPaint.setShader(new BitmapShader(mBmp, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //getWidth()用于获取控件宽度，getHeight()用于获取控件高度
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
    }
}
