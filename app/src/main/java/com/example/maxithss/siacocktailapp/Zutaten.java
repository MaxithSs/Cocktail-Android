package com.example.maxithss.siacocktailapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Zutaten extends AppCompatActivity {

    private TextView sunset;
    private TextView summerBeach;
    private TextView bananaBoat;
    private TextView summerDream;
    private String zutaten[] = {
            "Osaft • Ananas • Kirsch",
            "Osaft • Kirsch",
            "Osaft • Banane • Kirsch" ,
            "Osaft • Banane • Ananas"};

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

        String sunsetZutate = zutaten[0];
        String summerBeachZutate = zutaten[1];
        String bananaBoatZutate = zutaten[2];
        String summerDreamZutate = zutaten[3];
        sunset.setText(sunsetZutate);
        summerBeach.setText(summerBeachZutate);
        bananaBoat.setText(bananaBoatZutate);
        summerDream.setText(summerDreamZutate);
    }
}
