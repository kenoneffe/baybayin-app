package com.baybayinapp.thesis.baybayin_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button toChart, toHistory, toQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //chart
        toChart = findViewById(R.id.tochart);
        toChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoChart();
            }
        });

        //history
        toHistory = findViewById(R.id.tohistory);
        toHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHistory();
            }
        });

        //quiz
        toQuiz = (Button) findViewById(R.id.toquiz);
        toQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoQuiz();
            }
        });


    }

    public void gotoChart(){
        Intent intent = new Intent(this , Chart.class);
        startActivity(intent);

    }

    public void gotoHistory(){
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

    public void gotoQuiz(){

        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);

    }


}
