package com.cookie.developdraw.H;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class LinearGradientView extends View {

    private Paint mPaint;

    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientView(Context context, AttributeSet attrs, int defStyle) {
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

        int[] colors = {0xffff0000,0xff00ff00,0xff0000ff,0xffffff00,0xff00ffff};
        float[]  pos = {0f,0.2f,0.4f,0.6f,1.0f};
        LinearGradient multiGradient = new LinearGradient(0,getHeight()/2,getWidth(),getHeight()/2,colors,pos, Shader.TileMode.CLAMP);
        mPaint.setShader(multiGradient);
//        mPaint.setShader(new LinearGradient(0,getHeight()/2, getWidth(),getHeight()/2,0xffff0000,0xff00ff00, Shader.TileMode.CLAMP));
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
    }
}
