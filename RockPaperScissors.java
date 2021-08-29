package com.nicc.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RockPaperScissors extends AppCompatActivity {


    public static int getValue(){
        return UserChoice;
    }
    public static int UserChoice;
    AnimationDrawable imgAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
        Button button = (Button)findViewById(R.id.BeginBTN);
        final RadioButton rock = (RadioButton)findViewById(R.id.RockRB);
        final   RadioButton paper = (RadioButton)findViewById(R.id.PaperRB);
        final RadioButton scissor= (RadioButton)findViewById(R.id.ScissorsRB);

        ImageView rockImg = (ImageView)findViewById(R.id.rockImg);
        ImageView paperImg = (ImageView)findViewById(R.id.paperImg);
        ImageView scissorsImg = (ImageView)findViewById(R.id.scissorsImg);

        rockImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rock.setChecked(true);
                paper.setChecked(false);
                scissor.setChecked(false);
            }
        });
        paperImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rock.setChecked(false);
                paper.setChecked(true);
                scissor.setChecked(false);
            }
        });
        scissorsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rock.setChecked(false);
                paper.setChecked(false);
                scissor.setChecked(true);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(rock.isChecked()){ UserChoice=1; }
                else if(paper.isChecked()){ UserChoice =2; }
                else if(scissor.isChecked()){ UserChoice=3; }
                startActivity(new Intent(RockPaperScissors.this, ProgramChoice.class));

            }
        });


    }
}