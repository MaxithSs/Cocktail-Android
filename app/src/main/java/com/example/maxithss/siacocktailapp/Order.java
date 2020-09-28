package com.example.maxithss.siacocktailapp;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Order extends AppCompatActivity {

    private Button cocktail_sunset;
    private Button cocktail_summerbeach;
    private Button cocktail_summerdream;
    private Button cocktail_bananaboat;
    cocktailDialog1 cocktailDialog1 = new cocktailDialog1();
    cocktailDialog2 cocktailDialog2 = new cocktailDialog2();
    cocktailDialog3 cocktailDialog3 = new cocktailDialog3();
    cocktailDialog4 cocktailDialog4 = new cocktailDialog4();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bestellen);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final LinearLayout linearLayout = findViewById(R.id.bestellen_layout);
                AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
                animationDrawable.setEnterFadeDuration(2000);
                animationDrawable.setExitFadeDuration(4000);
                animationDrawable.start();
            }
        }).start();

        new Thread(new ButtonThread()).start();
        cocktail_sunset = findViewById(R.id.cocktail_1);
        cocktail_summerbeach = findViewById(R.id.cocktail_2);
        cocktail_summerdream = findViewById(R.id.cocktail_3);
        cocktail_bananaboat = findViewById(R.id.cocktail_4);
    }

    private class ButtonThread implements Runnable {
        @Override
        public void run() {

            cocktail_sunset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    cocktailDialog1.show(getSupportFragmentManager(),"my_Dialog");
                }
            });
            cocktail_summerbeach.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cocktailDialog2.show(getSupportFragmentManager(),"my_Dialog");
                }
            });
            cocktail_summerdream.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cocktailDialog3.show(getSupportFragmentManager(),"my_Dialog");
                }
            });
            cocktail_bananaboat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cocktailDialog4.show(getSupportFragmentManager(),"my_Dialog");
                }
            });
        }
    }
}
