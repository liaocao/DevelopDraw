package com.cookie.developdraw.B;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cookie.developdraw.R;

public class BBezierAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbezier_animation);

        final BezierAnimationView myView = (BezierAnimationView)findViewById(R.id.myview);
        myView.startAnim();
    }
}
