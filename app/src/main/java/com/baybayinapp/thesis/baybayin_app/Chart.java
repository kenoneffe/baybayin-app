package com.baybayinapp.thesis.baybayin_app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Chart extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_TEXT = "com.baybayinapp.thesis.baybayin_app.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Button aBTN = findViewById(R.id.btnA);
        Button baBTN = findViewById(R.id.btnBA);
        Button kaBTN = findViewById(R.id.btnKA);
        Button daBTN = findViewById(R.id.btnDA);
        Button eBTN = findViewById(R.id.btnE);
        Button gaBTN = findViewById(R.id.btnGA);
        Button haBTN = findViewById(R.id.btnHA);
        Button iBTN = findViewById(R.id.btnI);
        Button laBTN = findViewById(R.id.btnLA);
        Button maBTN = findViewById(R.id.btnMA);
        Button naBTN = findViewById(R.id.btnNA);
        Button ngaBTN = findViewById(R.id.btnNGA);
        Button oBTN = findViewById(R.id.btnO);
        Button paBTN = findViewById(R.id.btnPA);
        Button raBTN = findViewById(R.id.btnRA);
        Button saBTN = findViewById(R.id.btnSA);
        Button taBTN = findViewById(R.id.btnTA);
        Button uBTN = findViewById(R.id.btnU);
        Button waBTN = findViewById(R.id.btnWA);
        Button yaBTN = findViewById(R.id.btnYA);

        aBTN.setOnClickListener(this);
        baBTN.setOnClickListener(this);
        kaBTN.setOnClickListener(this);
        daBTN.setOnClickListener(this);
        eBTN.setOnClickListener(this);
        gaBTN.setOnClickListener(this);
        haBTN.setOnClickListener(this);
        iBTN.setOnClickListener(this);
        laBTN.setOnClickListener(this);
        maBTN.setOnClickListener(this);
        naBTN.setOnClickListener(this);
        ngaBTN.setOnClickListener(this);
        oBTN.setOnClickListener(this);
        paBTN.setOnClickListener(this);
        raBTN.setOnClickListener(this);
        saBTN.setOnClickListener(this);
        taBTN.setOnClickListener(this);
        uBTN.setOnClickListener(this);
        waBTN.setOnClickListener(this);
        yaBTN.setOnClickListener(this);


    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnA:

                opentoLearn("A");
                break;
            case R.id.btnBA:
                opentoLearn("BA");
                break;
            case R.id.btnKA:
                opentoLearn("KA");
                break;
            case R.id.btnDA:
                opentoLearn("DA");
                break;
            case R.id.btnE:
                opentoLearn("E");
                break;
            case R.id.btnGA:
                opentoLearn("GA");
                break;
            case R.id.btnHA:
                opentoLearn("HA");
                break;
            case R.id.btnI:
                opentoLearn("I");
                break;
            case R.id.btnLA:
                opentoLearn("LA");
                break;
            case R.id.btnMA:
                opentoLearn("MA");
                break;
            case R.id.btnNA:
                opentoLearn("NA");
                break;
            case R.id.btnNGA:
                opentoLearn("NGA");
                break;
            case R.id.btnO:
                opentoLearn("O");
                break;
            case R.id.btnPA:
                opentoLearn("PA");
                break;
            case R.id.btnRA:
                opentoLearn("RA");
                break;
            case R.id.btnSA:
                opentoLearn("SA");
                break;
            case R.id.btnTA:
                opentoLearn("TA");
                break;
            case R.id.btnU:
                opentoLearn("U");
                break;
            case R.id.btnWA:
                opentoLearn("WA");
                break;
            case R.id.btnYA:
                opentoLearn("YA");
                break;


        }

    }

    public void opentoLearn(String text){


        Intent intent = new Intent(this , Learn.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);

    }
}
