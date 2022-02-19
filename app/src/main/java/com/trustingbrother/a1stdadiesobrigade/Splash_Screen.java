package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class Splash_Screen extends AppCompatActivity {


    Animation topanim;
    Animation bottomanim;
    ImageView imageView;
    TextView  textView1;
    TextView textView2;
    Context context = this;
    //MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

       // mp = MediaPlayer.create(context,R.raw.and);


        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.buttom_animation);

        imageView = findViewById(R.id.imgsplash);
        textView1 = findViewById(R.id.txtsplash1);
        textView2 = findViewById(R.id.txtsplash2);

        imageView.setAnimation(topanim);
        textView1.setAnimation(bottomanim);
        textView2.setAnimation(bottomanim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent((Splash_Screen.this), MainActivity.class));
                finish();
            }
        },5000);

       /* try{
            if (mp.isPlaying()){
                mp.stop();
                mp.release();
                mp = MediaPlayer.create(context, R.raw.and);
            }
            mp.start();
        }catch (Exception e){e.printStackTrace();}*/
    }

}
