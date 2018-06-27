package com.style.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{

    private Button button ;
    private RadioGroup format_clock;
    private TextView hours;
    Intent i;
    private  Toolbar toolbar;
    private TextView minute;
    private TextView secound;
    private TextView AM_PM;
    private int selected_show;
    private int result;
    private SharedPreferences sp;
    SharedPreferences.Editor Editor;
    private int sound[]={R.raw.eight,R.raw.fourty_o,R.raw.minute ,0};
    private MediaPlayer Minute;
    private SharedPreferences state;
    private SharedPreferences.Editor editor;
    private boolean flager=true;

    private int sound_round_defult[]=
            {
                    0,R.raw.one_d, R.raw.two_d, R.raw.three_d,R.raw.four_d,R.raw.five_d,R.raw.six_d,R.raw.seven_d,R.raw.eight_d,
                    R.raw.nine_d,R.raw.ten_d,R.raw.eleven_d,R.raw.twelve_d,R.raw.thirteen_d,R.raw.fourteen_d,R.raw.fifteen_d,
                    R.raw.sixteen_d,R.raw.seventeen_d,R.raw.eighteen_d,R.raw.nineteen_d,R.raw.twenty_d
            };
    private int sound_round[]=
            {
                     0,R.raw.one, R.raw.two, R.raw.three,R.raw.four,R.raw.five,R.raw.six,R.raw.seven,R.raw.eight,
                     R.raw.nine,R.raw.ten,R.raw.eleven,R.raw.twelve,R.raw.thirteen,R.raw.fourteen,R.raw.fifteen,
                     R.raw.sixteen,R.raw.seventeen,R.raw.eighteen,R.raw.nineteen,R.raw.twenty
            };

    private int sound_o_defult[]=
            {
                    0,R.raw.one_o_d, R.raw.two_o_d, R.raw.three_o_d,R.raw.four_o_d,R.raw.five_o_d,R.raw.six_o_d,R.raw.seven_o_d,R.raw.eight_o_d,
                    R.raw.nine_o_d,R.raw.ten_o_d,R.raw.eleven_o_d,R.raw.twelve_o_d,R.raw.thirteen_o_d,R.raw.fourteen_o_d,R.raw.fifteen_o_d,
                    R.raw.sixteen_o_d,R.raw.seventeen_o_d,R.raw.eighteen_o_d,R.raw.nineteen_o_d,R.raw.twenty_o_d};
    private int sound_o[]=
            {
                    0,R.raw.one_o, R.raw.two_o, R.raw.three_o,R.raw.four_o,R.raw.five_o,R.raw.six_o,R.raw.seven_o,R.raw.eight_o,
                    R.raw.nine_o,R.raw.ten_o,R.raw.eleven_o,R.raw.twelve_o,R.raw.thirteen_o,R.raw.fourteen_o,R.raw.fifteen_o,
                    R.raw.sixteen_o,R.raw.seventeen_o,R.raw.eighteen_o,R.raw.nineteen_o,R.raw.twenty_o
            };

    private int sound_minute_round_defult[]=
            {
                    0,R.raw.ten_d, R.raw.twenty_d, R.raw.thirty_d,R.raw.fourty_d,R.raw.fifty_d
            };
    private int sound_minute_round[]=
            {
                    0,R.raw.ten, R.raw.twenty, R.raw.thirty,R.raw.fourty,R.raw.fifty
            };

    private int sound_minute_defult[]={ 0,R.raw.ten_o_d, R.raw.twenty_o_d, R.raw.thirty_o_d,R.raw.fourty_o_d,R.raw.fifty_o_d};
    private int sound_minute[]={ 0,R.raw.ten, R.raw.twenty_o, R.raw.thirty_o,R.raw.fourty_o,R.raw.fifty_o};
    private int location=0;



    public void clock_voic(int sound1[],int sound2[],int sound3[],int sound4[],int sound5[],int m,int H,int M,int S)
    {
        int i=0;
        if(flager==true || H<=12)
        {
            sound1[i++]= M==0 ? sound2[H]:sound3[H];
        }
        if(flager==false && H>12)
        {
            sound1[i++]= M==0 ? sound2[H-12]:sound3[H-12];
        }


        if(M<20)
            sound1[i++]=sound2[M];
        else
        {
            int kasr_minute=M/10;
            int ranaim_minute=M%10;

            sound1[i++]= ranaim_minute==0 ? sound4[kasr_minute]:sound5[kasr_minute];
            if(ranaim_minute!=0)
                sound1[i++]=sound2[ranaim_minute];
        }
        if(M!=0)
            sound1[i++]=m;


    }
    public void show_clock(int H,int M,int S)
    {
        hours.setText(String.valueOf(H));
        minute.setText(String.valueOf(M));
        secound.setText(String.valueOf(S));
        format_clock=(RadioGroup)findViewById(R.id.format_clock);


        selected_show=format_clock.getCheckedRadioButtonId();

        if(selected_show==R.id.twelve)
        {
            int h_h=H-12;
            if(H<10)
                hours.setText("0"+String.valueOf(H));
            else if(H>10&& H<12)
                hours.setText(String.valueOf(H));
            else if(H==0)
                hours.setText(String.valueOf(12));
            else if(h_h<10 && h_h>0)
                hours.setText("0"+String.valueOf(h_h));
            else if(h_h>10)
                hours.setText(String.valueOf(h_h));
        }
        else if(selected_show==R.id.twenty_four)
            if(H>10)
                hours.setText(String.valueOf(H));
            else
                hours.setText("0"+String.valueOf(H));

        if(M<10)
            minute.setText("0" + String.valueOf(M));
        else if(M>10)
            minute.setText(String.valueOf(M));
        if(S<10)
            secound.setText("0" + String.valueOf(S));
        else if(S>10)
            secound.setText(String.valueOf(S));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.settings)
            i=new Intent(MainActivity.this,SecoundActivity.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location=0;
        sp=getApplicationContext().getSharedPreferences("myprif", Context.MODE_PRIVATE);
        Editor=sp.edit();

        state=getApplicationContext().getSharedPreferences("mystate", Context.MODE_PRIVATE);
        editor = state.edit();


        result=sp.getInt("key",0);

        hours=(TextView)findViewById(R.id.H);
        minute=(TextView)findViewById(R.id.M);
        secound=(TextView)findViewById(R.id.second);
        AM_PM=(TextView)findViewById(R.id.AM_PM);
        button=(Button)findViewById(R.id.hour_show_and_expression);
        format_clock=(RadioGroup)findViewById(R.id.format_clock) ;


        toolbar = (Toolbar) findViewById(R.id.tol);
        setSupportActionBar(toolbar);

        flager = state.getBoolean("state", true);
        if (flager)
            format_clock.check(R.id.twenty_four);
        else
            format_clock.check(R.id.twelve);


        format_clock.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.twenty_four: {
                        flager=true;
                        editor.putBoolean("state", flager).apply();
                        break;
                    }
                    case R.id.twelve: {
                        flager=false;
                        editor.putBoolean("state", flager).apply();
                        break;
                    }
                }
            }
        });
    button.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {


        Date watch = new Date();
       int H= watch.getHours();
       int M =watch.getMinutes();
       int  S =watch.getSeconds();
        location =0;

        if(H<=12)
            AM_PM.setText("AM");
        else if(H>12)
            AM_PM.setText("PM");
        show_clock(H,M,S);

       MediaPlayer mp;
        switch (result)
        {
            case 1:

                 mp = MediaPlayer.create(MainActivity.this,R.raw.saat);
                mp.setOnCompletionListener(MainActivity.this);
                mp.start();

                clock_voic(sound,sound_round_defult,sound_o_defult,sound_minute_round_defult,sound_minute_defult,R.raw.daghigheh,H,M,S);
                break;
            case 2:
                 mp = MediaPlayer.create(MainActivity.this,R.raw.clock);
                mp.setOnCompletionListener(MainActivity.this);
                mp.start();

                clock_voic(sound,sound_round,sound_o,sound_minute_round,sound_minute,R.raw.minute,H,M,S);
                break;
        }

    }
});

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (sound[location] != 0) {
            MediaPlayer m = MediaPlayer.create(this, sound[location]);
            location++;
            m.setOnCompletionListener(this);
            m.start();
        }
    }


}
