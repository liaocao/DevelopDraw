package com.cookie.developdraw.B;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class CanvasNoTranslateView extends View {

    Context m_context;

    public CanvasNoTranslateView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub

        m_context=context;
    }

    //重写OnDraw（）函数，在每次重绘时自主实现绘图
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        //translate 平移,即改变坐标系原点位置

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

//	canvas.translate(100, 100);
        Rect rect1 = new Rect(0,0,400,220);
        canvas.drawRect(rect1, paint);
    }
}
