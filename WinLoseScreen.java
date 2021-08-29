package com.nicc.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinLoseScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose_screen);
        int userChoice = (RockPaperScissors.getValue());
        int computerChoice = (ProgramChoice.getValue());
        TextView results = (TextView)findViewById(R.id.ResultsTB);

        Button playAgain = (Button)findViewById(R.id.btnPlayAgain);
        Button homeBTN = (Button)findViewById(R.id.btnHome);


/*
        if(computerChoice ==1){results.setText("1");}
        else if(computerChoice==2){results.setText("2");}
        else if(computerChoice ==3){ results.setText("3");}
        else {results.setText("OTHER");} */

        switch (computerChoice)
        {
            case 1:
                if(userChoice == 2){ results.setText(" YOU WON!! \n PAPER BEATS ROCK!!");}
                else if( userChoice ==3) {results.setText(" YOU LOSE :( \n SCISSORS BEAT ROCK!! ");}
                else if( userChoice == 1){results.setText(" TIE!!\n ROCK AND ROCK");}
                else{ results.setText("You didn't select Rock, Paper, or Scissors");}
                break;
            case 2:
                if(userChoice == 1){ results.setText(" YOU LOSE :( \n PAPER BEATS ROCK!!");}
                else if( userChoice ==2) {results.setText(" TIE!!\n PAPER AND PAPER!!");}
                else if( userChoice == 3){results.setText(" YOU WIN!!\n SCISSORS BEATS PAPER!!");}
                else{ results.setText("You didn't select Rock, Paper, or Scissors");}
                break;
            case 3:
                if(userChoice == 1){ results.setText(" YOU WON!!\n ROCK BEATS SCISSORS!!");}
                else if( userChoice ==2) {results.setText(" YOU LOSE :( \n SCISSORS BEAT PAPER!!");}
                else if( userChoice == 3){results.setText(" TIE!!\n SCISSORS  AND SCISSORS!!");}
                else{ results.setText("You didn't select Rock, Paper, or Scissors");}
                 break;


        }

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WinLoseScreen.this, RockPaperScissors.class));
            }
        });

        homeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                startActivity(new Intent(WinLoseScreen.this, MainActivity.class));
            }
        });

    }
}