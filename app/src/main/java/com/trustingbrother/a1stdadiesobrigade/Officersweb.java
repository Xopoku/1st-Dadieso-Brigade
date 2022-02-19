package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Officersweb extends AppCompatActivity implements View.OnClickListener {
CardView cardView1, cardView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officersweb);

        setTitle("Officers");

        cardView1 =findViewById(R.id.ffo);
        cardView2 = findViewById(R.id.ffy);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ffo:
                startActivity(new Intent((Officersweb.this),Boyswebviewofficers.class));
                break;

            case R.id.ffy:
                startActivity(new Intent((Officersweb.this),Girlswebviewofficers.class));
                break;

        }
    }
}
