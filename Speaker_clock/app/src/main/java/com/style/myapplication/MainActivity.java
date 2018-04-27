package com.style.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{

    private Button button,btn_voice;
    private RadioGroup format_clock;
    private TextView hours;
    private TextView minute;
    private TextView secound;
    private TextView AM_PM;
    private int selected_show=R.id.twenty_four;
    private int result_selected_voice;
    private SharedPreferences sp;
    private int sound[]={R.raw.eight,R.raw.fourty_o,R.raw.minute ,0};
    private MediaPlayer Minute;

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
        sound1[i++]= M==0 ? sound2[H]:sound3[H];

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
            else if(H>10&& H<=12)
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sp.getInt("selected_show", this.selected_show);

        hours=(TextView)findViewById(R.id.H);
        minute=(TextView)findViewById(R.id.M);
        secound=(TextView)findViewById(R.id.second);
        AM_PM=(TextView)findViewById(R.id.AM_PM);
        button=(Button)findViewById(R.id.hour_show_and_expression);
        btn_voice=(Button)findViewById(R.id.select_speaker);

        btn_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SecoundActivity.class);
                startActivity(intent);
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

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
            result_selected_voice=extras.getInt("result_voice");

        MediaPlayer mp;
        switch (result_selected_voice)
        {
            case 0:
                 mp = MediaPlayer.create(MainActivity.this,R.raw.saat);
                mp.setOnCompletionListener(MainActivity.this);
                mp.start();

                Minute=MediaPlayer.create(MainActivity.this,R.raw.minute);
                clock_voic(sound,sound_round_defult,sound_o_defult,sound_minute_round_defult,sound_minute_defult,R.raw.daghigheh,H,M,S);
                break;
            case 1:
                 mp = MediaPlayer.create(MainActivity.this,R.raw.clock);
                mp.setOnCompletionListener(MainActivity.this);
                mp.start();

                Minute=MediaPlayer.create(MainActivity.this,R.raw.minute);
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

    public void onStop(){
        super.onStop();
        sp=getSharedPreferences("Mypref",MODE_PRIVATE);
        sp.edit().putInt("format",selected_show).apply();
    }
}
