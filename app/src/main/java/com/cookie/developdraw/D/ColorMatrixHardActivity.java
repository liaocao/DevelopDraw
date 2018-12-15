package com.cookie.developdraw.D;

import android.graphics.ColorMatrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cookie.developdraw.R;

public class ColorMatrixHardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix_hard);

        ColorMatrix colorMatrix1 = new ColorMatrix(new float[]{
                0.1f, 0.2f, 0.3f, 0.4f, 0.5f,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });

        ColorMatrix colorMatrix2 = new ColorMatrix(new float[]{
                0.11f, 0, 0, 0, 0,
                0, 0.22f, 0, 0, 0,
                0, 0, 0.33f, 0, 0,
                0, 0, 0, 0.44f, 0,
        });

        ColorMatrix resultMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
        });
        resultMatrix.setConcat(colorMatrix1,colorMatrix2);

        Log.e("qijian",printArray(colorMatrix1.getArray()));
        Log.e("qijian",printArray(colorMatrix2.getArray()));
        Log.e("qijian",printArray(resultMatrix.getArray()));
    }

    private String printArray(float[] array){
        StringBuilder builder = new StringBuilder("array dump:\n");
        for (int i=0;i<array.length;i++){
            if (i%5==0){
                builder.append("\n");
            }
            builder.append(array[i]+" ");
        }
        return builder.toString();
    }
}
