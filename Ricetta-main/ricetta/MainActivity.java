package com.app.ricetta;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBaseObject.connectToFiireBase();
        setContentView(R.layout.main_activity);
        TextView headerTextView=(TextView) findViewById(R.id.header_text);
        TextView breakfastView =(TextView) findViewById(R.id.breakfast_recipes_img);
        TextView soupView =(TextView) findViewById(R.id.soup_recipes_img);
        TextView saladView =(TextView) findViewById(R.id.salad_recipes_img);

        //setImageSource(breakfastView, "brec.jpg");
      //  setImageSource(soupView, "srec.jpg");
      //  setImageSource(saladView, "sarec.jpg");

        setListener(breakfastView, BreakfastRecipesActivity.class);
        setListener(saladView, SaladRecipesActivity.class);
        setListener(soupView, SoupRecipesActivity.class);
    }

    private void setImageSource(TextView imgView, String imgUrl) {
        try {
            InputStream inp = getAssets().open(imgUrl);
            Drawable d = Drawable.createFromStream(inp, null);
            //imgView.setImageDrawable(d);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void setListener(TextView imgView, Class navigateActivity) {
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, navigateActivity);
                startActivity(intent);
            }
        });
    }
}
