package com.baybayinapp.thesis.baybayin_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz extends AppCompatActivity {

    Button toReadQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //reading quid
        toReadQuiz = findViewById(R.id.toreadquiz);
        toReadQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoReadQuiz();
            }
        });
    }

    public void gotoReadQuiz(){
        Intent intent = new Intent(this, ReadQuiz.class);
        startActivity(intent);
    }
}
