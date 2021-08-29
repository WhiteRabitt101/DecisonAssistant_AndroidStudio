package com.nicc.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ProgramChoice extends AppCompatActivity {

    public static int ranNum;
    public static int getValue(){
        return ranNum;
    }
    AnimationDrawable imgAnimation;
    Drawable computerChoice;
   public static int imageChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random rand = new Random();
         ranNum= rand.nextInt(3- 0) +1;

        setContentView(R.layout.activity_program_choice);
        ImageView imgFrame= (ImageView)findViewById(R.id.imageView);

        imgFrame.setBackgroundResource(R.drawable.animation);
        imgAnimation=(AnimationDrawable)imgFrame.getBackground();
        Button button =(Button)findViewById(R.id.btnGO);
        imgAnimation.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAnimation.stop();
                startActivity(new Intent(ProgramChoice.this, WinLoseScreen.class));
            }
        });


    }
}