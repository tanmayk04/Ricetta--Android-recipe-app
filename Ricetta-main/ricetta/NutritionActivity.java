package com.app.ricetta;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class NutritionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition_layout);

        Bundle bundle = getIntent().getExtras();
        String chartName = bundle.getString("chartId");
        ImageView imgView =(ImageView) findViewById(R.id.nutrition_chart);
        try {
            InputStream inp = getAssets().open(chartName);
            Drawable d = Drawable.createFromStream(inp, null);
            imgView.setImageDrawable(d);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
