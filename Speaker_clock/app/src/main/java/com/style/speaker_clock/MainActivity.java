package com.style.speaker_clock;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




import java.util.Date;

import static android.media.MediaPlayer.create;

public class MainActivity extends AppCompatActivity{
    private SharedPreferences sp;
    private MediaPlayer player=null ;
    private int selectedid;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button;
        final TextView AM_PM;
        Date d=new Date();
        final int h=d.getHours();
        final int m=d.getMinutes();
        final int s=d.getSeconds();
        final int h_h=h-12;
        int M = 0;
       sp.getInt("selectedid",selectedid);


        final TextView h1=(TextView)findViewById(R.id.H);
        final TextView m1=(TextView)findViewById(R.id.M);
        final TextView s1=(TextView)findViewById(R.id.second);
        final TextView Am_Pm =(TextView)findViewById(R.id.AM_PM) ;
        button=(Button)findViewById(R.id.button);
        final MediaPlayer mp1= create(this, R.raw.one);
        final MediaPlayer mp2= create(this, R.raw.two);
        final MediaPlayer mp3= create(this, R.raw.three);
        final MediaPlayer mp4= create(this, R.raw.four);
        final MediaPlayer mp5= create(this, R.raw.five);
        final MediaPlayer mp6= create(this, R.raw.six);
        final MediaPlayer mp7= create(this, R.raw.seven);
        final MediaPlayer mp8= create(this, R.raw.eight);
        final MediaPlayer mp9= create(this, R.raw.nine);
        final MediaPlayer mp10= create(this, R.raw.ten);
        final MediaPlayer mp11= create(this, R.raw.eleven);
        final MediaPlayer mp12= create(this, R.raw.twelve);
        final MediaPlayer mp13= create(this, R.raw.thirteen);
        final MediaPlayer mp14= create(this, R.raw.fourteen);
        final MediaPlayer mp15= create(this, R.raw.fifteen);
        final MediaPlayer mp16= create(this, R.raw.sixteen);
        final MediaPlayer mp17= create(this, R.raw.seventeen);
        final MediaPlayer mp18= create(this, R.raw.eighteen);
        final MediaPlayer mp19= create(this, R.raw.nineteen);
        final MediaPlayer mp20= create(this, R.raw.twenty);
        final MediaPlayer mp20_0= create(this, R.raw.twenty_o);
        final MediaPlayer mp30= create(this, R.raw.thirty);
        final MediaPlayer mp30_0= create(this, R.raw.thirty_o);
        final MediaPlayer mp40= create(this, R.raw.fourty);
        final MediaPlayer mp40_0= create(this, R.raw.fourty_o);
        final MediaPlayer mp50= create(this, R.raw.fifty);
        final MediaPlayer mp50_0= create(this, R.raw.fifty_o);
        final MediaPlayer clock= create(this, R.raw.clock);
        final MediaPlayer morning= create(this, R.raw.morning);
        final MediaPlayer minute= create(this, R.raw.minute);
        final MediaPlayer o= create(this, R.raw.o);
        final RadioGroup format_clock=(RadioGroup)findViewById(R.id.format_clock);
        final RadioButton davazdah=(RadioButton)findViewById(R.id.davazdah);
        final RadioButton bistochar=(RadioButton)findViewById(R.id.bistochar);





        for(int i=20;i<m;i+=10)
        {
            if(m>20 && m<30)
                M = m - i;
            else if(m>30 && m<40)
                M = m - i;
            else if (m>40 && m<50)
                M = m - i;
            else if(m>50)
                M = m - i;
        }

        final int M_M=M;


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if(h<12)
                    Am_Pm.setText("AM");
                if(h>=12)
                    Am_Pm.setText("PM");


                selectedid=format_clock.getCheckedRadioButtonId();

                if(selectedid==R.id.davazdah)
                {
                    if(h<10)
                        h1.setText("0"+String.valueOf(h));
                    else if(h>10&& h<=12)
                        h1.setText(String.valueOf(h));
                    else if(h==0)
                        h1.setText(String.valueOf(12));
                    else if(h_h<10 && h_h>0)
                        h1.setText("0"+String.valueOf(h_h));
                    else if(h_h>10)
                        h1.setText(String.valueOf(h_h));
                }
                else if(selectedid==R.id.bistochar)
                    h1.setText(String.valueOf(h));

                if(m<10)
                    m1.setText("0" + String.valueOf(m));
                else if(m>10)
                    m1.setText(String.valueOf(m));
                if(s<10)
                    s1.setText("0" + String.valueOf(s));
                else if(s>10)
                    s1.setText(String.valueOf(h));
                clock.start();
                if (h <= 12) {
                    switch (h) {
                        case 1:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp1.start();
                                    mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 2:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp2.start();
                                    mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 3:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp3.start();
                                    mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 4:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp4.start();
                                    mp4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 5:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp5.start();
                                    mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 6:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp6.start();
                                    mp6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 7:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp7.start();
                                    mp7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 8:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp8.start();
                                    mp8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 9:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp9.start();
                                    mp9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 10:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp10.start();
                                    mp10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 11:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp11.start();
                                    mp11.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 12:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp12.start();
                                    mp12.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;

                    }
                }
                if (h > 12) {
                    switch (h_h) {
                        case 1:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp1.start();
                                    mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 2:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp2.start();
                                    mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 3:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp3.start();
                                    mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 4:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp4.start();
                                    mp4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 5:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp5.start();
                                    mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 6:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp6.start();
                                    mp6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });

                            break;
                        case 7:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp7.start();
                                    mp7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 8:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp8.start();
                                    mp8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 9:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp9.start();
                                    mp9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 10:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp10.start();
                                    mp10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 11:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp11.start();
                                    mp11.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                        case 12:
                            clock.start();
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp12.start();
                                    mp12.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            o.start();
                                        }
                                    });}
                            });
                            break;
                    }
                }

                switch (m) {
                    case 1:
                        if(h!=0)
                        {o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp1.start();
                                mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        }

                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp1.start();
                                    mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;

                    case 2:
                        if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp2.start();
                                mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        }

                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp2.start();
                                    mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;

                    case 3:
                        if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp3.start();
                                mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        }

                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp3.start();
                                    mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                            break;
                    case 4:
                        if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp4.start();
                                mp4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        }

                        else if(h==0){
                        clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp4.start();
                                mp4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        }
                            break;
                    case 5:
                        if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp5.start();
                                mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                       else if(h==0){
                        clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp5.start();
                                mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        break;
                    case 6:
                        if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp6.start();
                                mp6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        else if(h==0){
                        clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp6.start();
                                mp6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        break;
                    case 7:
                      if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp7.start();
                                mp7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        else if(h==0){
                        clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp7.start();
                                mp7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        break;
                    case 8:
                     if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp8.start();
                                mp8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        else if(h==0){
                        clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp8.start();
                                mp8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        break;
                    case 9:
                        if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp9.start();
                                mp9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                       else if(h==0){
                        clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp9.start();
                                mp9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                    case 10:
                       if(h!=0){
                        o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp10.start();
                                mp10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                       else if(h==0){
                        clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp10.start();
                                mp10.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                    }
                        break;
                    case 11:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp11.start();
                                    mp11.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp11.start();
                                    mp11.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 12:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp12.start();
                                    mp12.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp12.start();
                                    mp12.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 13:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp13.start();
                                    mp13.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp13.start();
                                    mp13.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 14:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp14.start();
                                    mp14.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp14.start();
                                    mp14.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 15:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp15.start();
                                    mp15.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp15.start();
                                    mp15.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 16:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp16.start();
                                    mp16.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp16.start();
                                    mp16.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 17:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp17.start();
                                    mp17.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp17.start();
                                    mp17.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 18:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp18.start();
                                    mp18.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp18.start();
                                    mp18.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 19:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp19.start();
                                    mp19.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp19.start();
                                    mp19.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 20:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp20.start();
                                    mp20.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp20.start();
                                    mp20.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 30:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp30.start();
                                    mp30.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp30.start();
                                    mp30.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 40:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp40.start();
                                    mp40.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp40.start();
                                    mp40.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;
                    case 50:
                        if(h!=0){
                            o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp50.start();
                                    mp50.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        else if(h==0){
                            clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp50.start();
                                    mp50.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            minute.start();
                                        }
                                    });}
                            });
                        }
                        break;

                }

                if(m>20&&m<30)
                {
                    player=mp20_0;}
               else if(m>30&&m<40)
                {
                player=mp30_0;}
                else if(m>40 && m<50)
                {
                player=mp40_0;}
                else if(m>50)
                {
           player=mp50_0;}
                final MediaPlayer player1=player;
                o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player1.start();

                    }
                });

                switch (M_M) {
                    case 1:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp1.start();
                                mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 2:

                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp2.start();
                                mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 3:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp3.start();
                                mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 4:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp4.start();
                                mp4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 5:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp5.start();
                                mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 6:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp6.start();
                                mp6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 7:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp7.start();
                                mp7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 8:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp8.start();
                                mp8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                    case 9:
                        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp9.start();
                                mp9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        minute.start();
                                    }
                                });}
                        });
                        break;
                }
                if(h==0 && m==0)
                    clock.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            morning.start();
                        }
                    });
                else if(h==0 && m!=0)
                    minute.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            morning.start();
                        }
                    });



            }

        });


    }
    protected void onStop(){
        super.onStop();
        sp=getSharedPreferences("Mypref",MODE_PRIVATE);
        sp.edit().putInt("format",selectedid).apply();
    }

}
