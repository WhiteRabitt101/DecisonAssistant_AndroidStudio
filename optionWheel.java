package com.nicc.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class optionWheel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_wheel);
       // 1st Animation
        ImageView wheelImg = (ImageView)findViewById(R.id.wheelAnimatiion);
        wheelImg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

        Button button = (Button)findViewById(R.id.SpinWheelBTN);
        //wheelImg.getAnimation().getDuration();
        Handler handler = new Handler();
        Timer timer = new Timer(false);

        int loops = 1000000;
        int degreesPerSecond = 360;
        wheelImg.animate().rotationBy(degreesPerSecond * loops).setDuration(loops * 1000)
                .setInterpolator(new LinearInterpolator());

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(optionWheel.this, RandomOptionWinner.class));
                    }
                });
            }
        };


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setClickable(false);
                wheelImg.clearAnimation();
               wheelImg.startAnimation((AnimationUtils.loadAnimation(optionWheel.this, R.anim.rotate2)));
                wheelImg.animate().rotationBy(degreesPerSecond/2).setDuration(1000)
                        .setInterpolator(new DecelerateInterpolator());
              timer.schedule(timerTask, 2000);
               // startActivity(new Intent(optionWheel.this, RandomOptionWinner.class));
            }
        });
    }
}