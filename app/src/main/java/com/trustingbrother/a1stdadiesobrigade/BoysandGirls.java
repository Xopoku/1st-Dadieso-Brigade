package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BoysandGirls extends AppCompatActivity implements View.OnClickListener {
CardView cardView1, cardView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boysand_girls);
        setTitle("Brigade Boys' & Girls'");

        cardView1  = findViewById(R.id.bbbo);
        cardView2 = findViewById(R.id.bby);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bbbo:
                startActivity(new Intent((BoysandGirls.this),Boyswebview.class));
                break;

            case R.id.bby:
                startActivity(new Intent((BoysandGirls.this),Girlswebview.class));
                break;
        }
    }
}
