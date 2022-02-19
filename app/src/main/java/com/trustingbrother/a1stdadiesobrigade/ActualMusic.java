package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActualMusic extends AppCompatActivity implements View.OnClickListener {
CardView cardView1, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_music);
        setTitle("Band Music Library");

        cardView1 = findViewById(R.id.libstaff);
        cardView2 = findViewById(R.id.libmore);
        cardView3 = findViewById(R.id.libtonic);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.libstaff:
                startActivity(new Intent((ActualMusic.this), Music.class));
                break;


            case R.id.libmore:
                startActivity(new Intent((ActualMusic.this),MusicMore.class));
                break;

            case R.id.libtonic:
                startActivity(new Intent((ActualMusic.this), MusicMoreRight.class));
                break;
        }

    }
}
