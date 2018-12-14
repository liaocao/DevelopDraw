package com.cookie.developdraw.A;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.view.View;

public class MyRegionView extends View {

    public MyRegionView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        //初始化画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);

        Region rgn = new Region(10,10,100,100);

//	rgn.set(100, 100, 200, 200);
        drawRegion(canvas, rgn, paint);
    }

    //这个函数不懂没关系，下面会细讲
    private void drawRegion(Canvas canvas, Region rgn, Paint paint)
    {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }

}
