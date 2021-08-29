package com.nicc.android.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomChoice extends AppCompatActivity {

    public static EditText[] getArray(){return editTextArray;}
    public static TextView getValue(){
        return winner;
    }
    public static TextView winner;
    public static int randNum;
    public static EditText[] editTextArray;
    public  String[] str;
    public  String key;
    ArrayList<String> str1 = new ArrayList<>();
    @SuppressLint("StaticFieldLeak")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_choice);
        Intent i = new Intent( );
        i.putExtras(new Bundle());
        Bundle bundle = i.getExtras();
      //  Bundle b = new Bundle();


      //  final SharedPreferences sharedPref= PreferenceManager.getDefaultSharedPreferences(this);

/*
        TextView opt1 =(TextView)findViewById(R.id.txtTB1);
        TextView opt2 =(TextView)findViewById(R.id.txtTB2);
        TextView opt3 =(TextView)findViewById(R.id.txtTB3);
        TextView opt4 =(TextView)findViewById(R.id.txtTB4);
        TextView opt5 =(TextView)findViewById(R.id.txtTB5);
*/
        TextView txtBox1 = (TextView)findViewById(R.id.txtTB1);
        TextView txtBox2 = (TextView)findViewById(R.id.txtTB2);
        TextView txtBox3 = (TextView)findViewById(R.id.txtTB3);
        TextView txtBox4 = (TextView)findViewById(R.id.txtTB4);
        TextView txtBox5 = (TextView)findViewById(R.id.txtTB5);
        RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup2);
        RadioButton three = (RadioButton)findViewById(R.id.threeRB);
        RadioButton four = (RadioButton)findViewById(R.id.fourRB);
        RadioButton five = (RadioButton)findViewById(R.id.fiveRB);

        Button button = (Button)findViewById(R.id.homeBtn);
        Random rand = new Random();
        randNum = rand.nextInt(4+1);

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBox1.setVisibility(View.VISIBLE);
                txtBox2.setVisibility(View.VISIBLE);
                txtBox3.setVisibility(View.VISIBLE);
                txtBox4.setVisibility(View.INVISIBLE);
                txtBox5.setVisibility(View.INVISIBLE);
                randNum =rand.nextInt(2+1);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBox1.setVisibility(View.VISIBLE);
                txtBox2.setVisibility(View.VISIBLE);
                txtBox3.setVisibility(View.VISIBLE);
                txtBox4.setVisibility(View.VISIBLE);
                txtBox5.setVisibility(View.INVISIBLE);
                randNum =rand.nextInt(3+1);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBox1.setVisibility(View.VISIBLE);
                txtBox2.setVisibility(View.VISIBLE);
                txtBox3.setVisibility(View.VISIBLE);
                txtBox4.setVisibility(View.VISIBLE);
                txtBox5.setVisibility(View.VISIBLE);
                randNum =rand.nextInt(4+1);
            }
        });





        if(randNum >0) {

            str1.add((findViewById(R.id.txtTB1).toString()));
            str1.add((findViewById(R.id.txtTB2).toString()));
            str1.add((findViewById(R.id.txtTB3).toString()));
            str1.add((findViewById(R.id.txtTB4).toString()));
            str1.add((findViewById(R.id.txtTB5).toString()));



        }//end of if

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText[] editTextArray = new EditText[]{
                        (EditText) (findViewById(R.id.txtTB1)),
                        (EditText) findViewById(R.id.txtTB2),
                        (EditText) findViewById(R.id.txtTB3),
                        (EditText) findViewById(R.id.txtTB4),
                        (EditText) findViewById(R.id.txtTB5),
                };
                str = new String[]{(findViewById(R.id.txtTB1).toString()),
                        (findViewById(R.id.txtTB2).toString()),
                        (findViewById(R.id.txtTB3).toString()),
                        (findViewById(R.id.txtTB4).toString()),
                        (findViewById(R.id.txtTB5).toString())};

               // Intent intent = new Intent(RandomChoice.this, OptionWinner.class);
              //  intent.putExtra("string-array", str );
                bundle.putStringArray( "ary", new String[]{(findViewById(R.id.txtTB1).toString()),
                        (findViewById(R.id.txtTB2).toString()),
                        (findViewById(R.id.txtTB3).toString()),
                        (findViewById(R.id.txtTB4).toString()),
                        (findViewById(R.id.txtTB5).toString())});

                /*
                b.putSerializable("b", editTextArray);
                b.putStringArray( "ary", new String[]{(findViewById(R.id.txtTB1).toString()),
                                                    (findViewById(R.id.txtTB2).toString()),
                                                    (findViewById(R.id.txtTB3).toString()),
                                                    (findViewById(R.id.txtTB4).toString()),
                                                     (findViewById(R.id.txtTB5).toString())}.toString());
                Intent intent = new Intent();
                intent.putExtra( key,  str);
                intent.putExtras(b);
                //Intent i=new Intent(RandomChoice.this, OptionWinner.class);
                //i.putExtras(b);

                 */
                if(editTextArray[randNum].equals(null))
                {
                    winner = editTextArray[randNum-1];
                }
                else{winner= editTextArray[randNum];}


                /*
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("key1", String.valueOf(opt1));
                editor.putString("key1", String.valueOf(opt2));
                editor.putString("key1", String.valueOf(opt3));
                editor.putString("key1", String.valueOf(opt4));
                editor.putString("key1", String.valueOf(opt5));
                editor.commit(); */


                   // startActivity(new Intent(RandomChoice.this, OptionWinner.class));
                      startActivity(new Intent(RandomChoice.this, optionWheel.class  ));
            }
        });

    }

}