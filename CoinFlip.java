package com.nicc.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class CoinFlip extends AppCompatActivity {
    AnimationDrawable flip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);
        Button stop = (Button)findViewById(R.id.stopBTN);
        Button home = (Button)findViewById(R.id.homeBTN);
        Button start = (Button)findViewById(R.id.flipBTN);

        ImageView imgFrame = (ImageView)findViewById(R.id.coinIMG);
        imgFrame.setBackgroundResource(R.drawable.coinanimation);
        flip =(AnimationDrawable)imgFrame.getBackground();
        flip.start();

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flip.stop();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flip.start();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoinFlip.this, MainActivity.class));
            }
        });

    }
}