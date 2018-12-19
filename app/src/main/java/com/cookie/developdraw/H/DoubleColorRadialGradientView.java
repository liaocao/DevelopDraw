package com.cookie.developdraw.H;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class DoubleColorRadialGradientView extends View {

    private Paint mPaint;
    private RadialGradient mRadialGradient;
    private int mRadius = 100;

    public DoubleColorRadialGradientView(Context context) {
        super(context);
        init();
    }

    public DoubleColorRadialGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DoubleColorRadialGradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mRadialGradient = new RadialGradient(w/2,h/2,mRadius,0xffff0000,0xff00ff00, Shader.TileMode.REPEAT);
        mPaint.setShader(mRadialGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(getWidth()/2,getHeight()/2,mRadius,mPaint);
    }
}