package com.cookie.developdraw.H;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class LinearGradientText extends View {

    private Paint mPaint;

    public LinearGradientText(Context context) {
        super(context);
        init();
    }

    public LinearGradientText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //多色渐变
        int[] colors = {0xffff0000,0xff00ff00,0xff0000ff,0xffffff00,0xff00ffff};
        float[]  pos = {0f,0.2f,0.4f,0.6f,1.0f};
        LinearGradient multiGradient = new LinearGradient(0,0,getWidth()/2,getHeight()/2,colors,pos, Shader.TileMode.MIRROR);
        mPaint.setShader(multiGradient);
        mPaint.setTextSize(50);
        canvas.drawText("欢迎关注启舰的blog",0,200,mPaint);
    }
}
