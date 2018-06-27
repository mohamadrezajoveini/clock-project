package com.style.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecoundActivity extends AppCompatActivity {

    private RadioGroup selected_voice;
    private int result ;
    SharedPreferences Sp;
    SharedPreferences.Editor edit;
    boolean flag=true;


    private SharedPreferences prif;
    SharedPreferences.Editor editor;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);

        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        selected_voice = (RadioGroup) findViewById(R.id.selecte);
        Sp = getApplicationContext().getSharedPreferences("Myprif", Context.MODE_PRIVATE);
        edit = Sp.edit();


        prif=getApplicationContext().getSharedPreferences("myprif", Context.MODE_PRIVATE);
        editor = prif.edit();

        flag = Sp.getBoolean("ke", true);
        if (flag)
            selected_voice.check(R.id.defult);
        else
            selected_voice.check(R.id.voice_me);



        selected_voice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.defult: {
                        flag=true;
                        result = 1;
                        editor.putInt("key", result).apply();
                        edit.putBoolean("ke", flag).apply();
                        break;
                    }
                    case R.id.voice_me: {
                        flag=false;
                        result = 2;
                        editor.putInt("key", result).apply();
                        edit.putBoolean("ke", flag).apply();
                        break;
                    }
                    default:
                        result = 0;
                }
            }
        });



    }
}

