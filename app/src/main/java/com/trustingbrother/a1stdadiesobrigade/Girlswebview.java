package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Girlswebview extends AppCompatActivity implements View.OnClickListener {
CardView cardView1, cardView2, cardView3, cardView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girlswebview);
        setTitle("Girls");
        cardView1 = findViewById(R.id.gsc1);
        cardView2 = findViewById(R.id.gsc2);
        cardView3 = findViewById(R.id.gsc3);
        cardView4 = findViewById(R.id.gsc4);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gsc1:
                startActivity(new Intent((Girlswebview.this), BrigaderWebview.class));
                break;

            case R.id.gsc2:
                startActivity(new Intent((Girlswebview.this), seniorgirlwebview.class));
                break;

            case R.id.gsc3:
                startActivity(new Intent((Girlswebview.this), juniorgirlwebview.class));
                break;

            case R.id.gsc4:
                startActivity(new Intent((Girlswebview.this), explorerwebview.class));
                break;
        }
    }
}
