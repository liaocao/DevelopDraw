package com.cookie.developdraw.A;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.cookie.developdraw.R;

public class ADrawRegionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout root=(FrameLayout)findViewById(R.id.root);
        root.addView(new MyRegionView(this));
    }
}