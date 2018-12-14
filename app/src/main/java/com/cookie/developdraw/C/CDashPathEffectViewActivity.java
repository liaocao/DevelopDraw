package com.cookie.developdraw.C;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cookie.developdraw.R;

public class CDashPathEffectViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_path_effect_view);
        DashPathEffectView dashView = findViewById(R.id.dashView);
        dashView.startAnim();
    }
}
