package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Membership extends AppCompatActivity implements View.OnClickListener {
CardView cardView1, cardView2, cardView3,  cardView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        setTitle("Our Membership");
        cardView1 = findViewById(R.id.mpatrons);
        cardView2 = findViewById(R.id.mofficer);
        cardView3 = findViewById(R.id.msenior);
        cardView4 = findViewById(R.id.mcompany);


        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mpatrons:
                startActivity(new Intent((Membership.this),PatronsView.class));
                break;

            case R.id.mofficer:
                startActivity(new Intent((Membership.this), Chaplainweb.class));
                break;

            case R.id.msenior:
                startActivity(new Intent((Membership.this),Officersweb.class));
                break;

            case R.id.mcompany:
                startActivity(new Intent((Membership.this), BoysandGirls.class));
        }

    }
}
