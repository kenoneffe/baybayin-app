package com.baybayinapp.thesis.baybayin_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Chart extends AppCompatActivity {

    private Button  aBTN,baBTN,kaBTN,daBTN,
                    eBTN,gaBTN,haBTN,iBTN,
                    laBTN,maBTN,naBTN,ngaBTN,
                    oBTN,paBTN,raBTN,saBTN,
                    taBTN,uBTN,waBTN,yaBTN;

    private TextView mainLearnTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);


        //main learn Text View initialization
        mainLearnTV = (TextView) findViewById(R.id.learnTV);


        //button listener initialization

        aBTN = findViewById(R.id.btnA);
        aBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        baBTN = findViewById(R.id.btnBA);
        baBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        kaBTN = findViewById(R.id.btnKA);
        kaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        daBTN = findViewById(R.id.btnDA);
        daBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        eBTN = findViewById(R.id.btnE);
        eBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        gaBTN = findViewById(R.id.btnGA);
        gaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        haBTN = findViewById(R.id.btnHA);
        haBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        iBTN = findViewById(R.id.btnI);
        iBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        laBTN = findViewById(R.id.btnLA);
        laBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        maBTN = findViewById(R.id.btnMA);
        maBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        naBTN = findViewById(R.id.btnNA);
        naBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        ngaBTN = findViewById(R.id.btnNGA);
        ngaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        oBTN = findViewById(R.id.btnO);
        oBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        paBTN = findViewById(R.id.btnPA);
        paBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        raBTN = findViewById(R.id.btnRA);
        raBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        saBTN = findViewById(R.id.btnSA);
        saBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        taBTN = findViewById(R.id.btnTA);
        taBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        uBTN =findViewById(R.id.btnU);
        uBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        waBTN = findViewById(R.id.btnWA);
        waBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });

        yaBTN = findViewById(R.id.btnYA);
        yaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opentoLearn();

            }
        });



    }

    public void opentoLearn(){
        Intent intent = new Intent(this , Learn.class);
        startActivity(intent);



    }


}
