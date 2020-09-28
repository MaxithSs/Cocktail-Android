package com.example.maxithss.siacocktailapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    protected Button btn_bestellen;
    protected Button btn_hilfe;
    protected Button btn_zutaten;
    protected Button btn_entwickler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new AnimationThread()).start();
        new Thread(new ButtonThread()).start();
    }

    private class AnimationThread implements Runnable {
        @Override
        public void run() {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

            LinearLayout linearLayout = findViewById(R.id.main_layout);
            AnimationDrawable animationDrawable = (AnimationDrawable)linearLayout.getBackground();
            animationDrawable.setEnterFadeDuration(2000);
            animationDrawable.setExitFadeDuration(4000);
            animationDrawable.start();

        }
    }

    private class ButtonThread implements Runnable {
        @Override
        public void run() {
            btn_bestellen = findViewById(R.id.button_bestellen);
            View.OnClickListener onClickListener_bestellen = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent bestellen_activity = new Intent(MainActivity.this, Order.class);
                    startActivity(bestellen_activity);
                }
            };
            btn_bestellen.setOnClickListener(onClickListener_bestellen);

            btn_hilfe = findViewById(R.id.button_hilfe);
            View.OnClickListener onClickListener_hilfe = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent hilfe_activity = new Intent(MainActivity.this, Hilfe.class);
                    startActivity(hilfe_activity);
                }
            };
            btn_hilfe.setOnClickListener(onClickListener_hilfe);

            btn_zutaten = findViewById(R.id.button_zutaten);
            View.OnClickListener onClickListener_zutaten = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent zutaten_activity = new Intent(MainActivity.this, Ingredients.class);
                    startActivity(zutaten_activity);

                }
            };
            btn_zutaten.setOnClickListener(onClickListener_zutaten);

            btn_entwickler = findViewById(R.id.button_entwickler);
            View.OnClickListener onClickListener_entwickler = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent entwickler_activity = new Intent(MainActivity.this, Entwickler.class);
                    startActivity(entwickler_activity);
                }
            };
            btn_entwickler.setOnClickListener(onClickListener_entwickler);
        }
    }
}
