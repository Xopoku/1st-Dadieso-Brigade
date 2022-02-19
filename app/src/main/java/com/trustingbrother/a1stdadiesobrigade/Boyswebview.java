package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Boyswebview extends AppCompatActivity implements View.OnClickListener {
CardView cardView1, cardView2, cardView3, cardView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boyswebview);
        setTitle("Boys'");

        cardView1 = findViewById(R.id.bsc1);
        cardView2 = findViewById(R.id.bsc2);
        cardView3 = findViewById(R.id.bsc3);
        cardView4 = findViewById(R.id.bsc4);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bsc1:
                startActivity(new Intent((Boyswebview.this), snrboyswebview.class));
                break;

            case R.id.bsc3:
                //Toast.makeText(getApplicationContext(),"Opens the Junior section", Toast.LENGTH_SHORT).show();
                startActivity(new Intent((Boyswebview.this), jnrboyswebview.class));
                break;

            case R.id.bsc4:
                //Toast.makeText(getApplicationContext(),"Opens the Anchor section", Toast.LENGTH_SHORT).show();
                startActivity(new Intent((Boyswebview.this), AnchorWebview.class));
                break;

        }
    }
}
