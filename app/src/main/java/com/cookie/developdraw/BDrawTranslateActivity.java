package com.cookie.developdraw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class BDrawTranslateActivity extends AppCompatActivity {

    private FrameLayout root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        root=(FrameLayout)findViewById(R.id.root);
        root.addView(new CanvasTranslateView(this));
    }


    public void withTranslate(View view) {
        root.removeAllViews();
        root.addView(new CanvasTranslateView(this));
    }

    public void noTranslate(View view) {
        root.removeAllViews();
        root.addView(new CanvasNoTranslateView(this));
    }
}