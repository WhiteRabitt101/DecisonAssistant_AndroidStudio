package com.nicc.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomOptionWinner extends AppCompatActivity {

/*
    public  EditText[] choiceArray= new EditText[]{
            (EditText) findViewById(R.id.txtTB1),
                       (EditText) findViewById(R.id.txtTB2),
            (EditText) findViewById(R.id.txtTB3),
            (EditText) findViewById(R.id.txtTB4),
            (EditText) findViewById(R.id.txtTB5)
    };

 */

    public EditText[] choiceArray=(RandomChoice.getArray());
    public TextView winnerTV;
    public  TextView winnerChoice;
    public TextView notHappyTV;
    public static int randNum;

    public static int count = 0;
    public static int i =0;
    public Random rand = new Random();


  //  public static String[] createArray;

    public String[] removeNull(String[] a)
    {
        for(int i=0; i<a.length; i++)
        {
            if(a[i] == null)
            {
                a = fillArray(a, i);
            }
        }
        return a;
    }

    public String[] fillArray(String[] a, int i)
    {
        String[] a2 = new String[a.length-1];

        for(int j=0; j<a2.length; j++)
        {
            if(j<i)
            {
                a2[j] = a[j];
            }
            else if(j>i)
            {
                a2[j]= a[j + 1];
            }
        }

        return a2;
    }

    /*
    public EditText[] removeNull(EditText[] a)
    {
        for(int i=0; i<a.length; i++)
        {
            if(a[i] == null)
            {
                a = fillArray(a, i);
            }
        }
        return a;
    }

    public EditText[] fillArray(EditText[] a, int i)
    {
        EditText[] a2 = new EditText[a.length-1];

        for(int j=0; j<a2.length; j++)
        {
            if(j<i)
            {
                a2[j] = a[j];
            }
            else if(j>i)
            {
                a2[j]= a[j + 1];
            }
        }

        return a2;
    }

     */
   // ArrayList<String> choiceArray= (ArrayList<String>) getIntent().getSerializableExtra("key");

    /*
    public ArrayList<String> removeNull(ArrayList<String> a)
    {
        for(int i=0; i<a.size(); i++)
        {
            if(a.get(i) == null)
            {
                a = fillArray(a, i);
            }
        }
 return a;
    }

    public ArrayList<String> fillArray(ArrayList<String> a, int i)
    {
        ArrayList<String> a2 = new ArrayList<String>(a.size()-1);

        for(int j=0; j<a2.size(); j++)
        {
            if(j<i)
            {
                a2.set(j, a.get(j));
            }
            else if(j>i)
            {
                a2.set(j, a.get(j + 1));
            }
        }

        return a2;
    }
    */

    @Override
    protected void onResume() {
        super.onResume();

        setContentView(R.layout.activity_random_option_winner);

        Button home = (Button) findViewById(R.id.homeBtn);
        Button happy = (Button) findViewById(R.id.happyBTN);
        Button notHappy = (Button) findViewById(R.id.notHappyBTN);

        Bundle b = this.getIntent().getExtras();
//        String[] array=b.getStringArray("key");

        winnerTV = (TextView) findViewById(R.id.randOptWinner);
        winnerChoice = (RandomChoice.getValue());
        winnerTV.setText(winnerChoice.getText().toString());

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RandomOptionWinner.this, MainActivity.class));
            }
        });
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RandomOptionWinner.this, MainActivity.class));
            }
        });

        notHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // choiceArray= (EditText[])RandomChoice.getArray();


                notHappyTV = (TextView)findViewById(R.id.notHappyTV);
                notHappyTV.setVisibility(View.VISIBLE);
                String WhyEnterIt = "Then why did you put it as an option?!?";
                notHappyTV.setText(WhyEnterIt);
               // startActivity(new Intent(RandomOptionWinner.this, RandomChoice.class));
            }
        });

    }

/*
    protected void onResume() {
        super.onResume();
       // setContentView(R.layout.activity_random_option_winner);

        count++;
        int x;
        choiceArray=RandomChoice.getArray();

        choiceArray= new EditText[]{
                (EditText) findViewById(R.id.txtTB1),
                (EditText) findViewById(R.id.txtTB2),
                (EditText) findViewById(R.id.txtTB3),
                (EditText) findViewById(R.id.txtTB4),
                (EditText) findViewById(R.id.txtTB5)};

        for ( x = 0; x <choiceArray.length; x++) {
            int finalX = x;
            if(winnerTV.toString().equals(choiceArray[x])) {
                // Arrays.asList(choiceArray).indexOf(winnerTV);
                Arrays.asList(choiceArray[x]).remove(x);
                removeNull(choiceArray);
            }
        }//end for
        randNum = rand.nextInt(4-count);
        winnerTV.setText(choiceArray[randNum].toString());

    } */
}