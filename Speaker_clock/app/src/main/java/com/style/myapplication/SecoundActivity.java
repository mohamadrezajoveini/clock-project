package com.style.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SecoundActivity extends AppCompatActivity {

    private RadioGroup selected_voice;
    private int select_voice;
    private int result;
    private Button forward_selected_vice;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);
        forward_selected_vice =(Button)findViewById(R.id.forward_selected_vice) ;
        select_voice= selected_voice.getCheckedRadioButtonId();
        result= select();
        selected_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("result_voice",result);
                startActivity(intent);
            }
        });


    }
    public int select()
    {
        if(select_voice==R.id.defult)
            return 0;
        else if(select_voice==R.id.voice_me)
            return 1;
        return -1;
    }
}
