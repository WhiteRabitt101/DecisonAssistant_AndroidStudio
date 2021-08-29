package com.nicc.android.rockpaperscissors;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class OptionWinner extends AppCompatActivity {

    public TextView winnerTV;
    public TextView winnerChoice;
    public TextView notHappyTV;
    public static int randNum;
    public static int count = 0;
    public static int i = 0;
    public Random rand = new Random();


    public String[] removeNull(String[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                a = fillArray(a, i);
            }
        }
        return a;
    }

    public String[] fillArray(String[] a, int i) {
        String[] a2 = new String[a.length - 1];
        for (int j = 0; j < a2.length; j++) {
            if (j < i) {
                a2[j] = a[j];
            } else if (j > i) {
                a2[j] = a[j + 1];
            }
        }
        return a2;
    }

    public void setForeground() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_option_winner);


        Button home = (Button) findViewById(R.id.homeBtn);
        Button happy = (Button) findViewById(R.id.happyBTN);
        Button notHappy = (Button) findViewById(R.id.notHappyBTN);
        //Intent[] intent = {getIntent()};
        //String[][] array = {intent[0].getStringArrayExtra("ary")};


        winnerTV = (TextView) findViewById(R.id.randOptWinner);
        winnerChoice = (RandomChoice.getValue());
        winnerTV.setText(winnerChoice.getText().toString());
        /*
        Bundle b = this.getIntent().getExtras();
        String[] array = b.getStringArray(key);
        */
    //    intent[0] = getIntent();
     //   array[0] = intent[0].getStringArrayExtra("string-array");

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptionWinner.this, MainActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OptionWinner.this, MainActivity.class));
            }
        });
        notHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notHappyTV.setVisibility(View.VISIBLE);
                notHappyTV = (TextView)findViewById(R.id.notHappyTV);
                String WhyEnterIt = "Then why did you put it as an option?!?";
                notHappyTV.setText(WhyEnterIt);
/*
                // choiceArray= (EditText[])RandomChoice.getArray();
                intent[0] = getIntent();
                array[0] = intent[0].getStringArrayExtra("ary");

                count++;
                int x;

                for (x = 0; x < array[0].length; x++) {
                    int finalX = x;
                    if (winnerTV.toString().equals(array[0][x])) {
                        // Arrays.asList(choiceArray).indexOf(winnerTV);
                        Arrays.asList(array[0][x]).remove(x);
                        removeNull(array[0]);
                    }
                }//end for
                randNum = rand.nextInt(5 - count) - 1;
                winnerTV.setText(array[0][randNum].toString());

*/

                startActivity(new Intent(OptionWinner.this, RandomChoice.class));

            }
        });

    }
}