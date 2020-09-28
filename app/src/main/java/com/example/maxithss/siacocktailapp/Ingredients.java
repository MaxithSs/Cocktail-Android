package com.example.maxithss.siacocktailapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Ingredients extends AppCompatActivity {


    protected TextView sunset;
    protected TextView summerBeach;
    protected TextView bananaBoat;
    protected TextView summerDream;
    //protected TextView[] textViews = new TextView[] {sunset, summerBeach, summerDream, bananaBoat};
    protected String ingredients[] = {
            "Osaft • Ananas • Kirsch",
            "Osaft • Kirsch",
            "Osaft • Banane • Kirsch" ,
            "Osaft • Banane • Ananas"};

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zutaten);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        LinearLayout linearLayout = findViewById(R.id.zutaten_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable)linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        sunset = findViewById(R.id.SunsetZutate);
        summerBeach = findViewById(R.id.SummerBeachZutate);
        bananaBoat = findViewById(R.id.bananaBoatZutate);
        summerDream = findViewById(R.id.SummerDreamZutate);

//        for (TextView textView : textViews) {
//            for (String ingredient : ingredients) {
//                textView.setText(ingredient);
//            }
//        }

        String sunsetZutate = ingredients[0];
        String summerBeachZutate = ingredients[1];
        String bananaBoatZutate = ingredients[2];
        String summerDreamZutate = ingredients[3];
        sunset.setText(sunsetZutate);
        summerBeach.setText(summerBeachZutate);
        bananaBoat.setText(bananaBoatZutate);
        summerDream.setText(summerDreamZutate);
    }
}
