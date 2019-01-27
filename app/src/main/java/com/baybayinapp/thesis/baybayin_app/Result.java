package com.baybayinapp.thesis.baybayin_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /*Intent intent = getIntent();
        int number = intent.getIntExtra(ReadQuiz.EXTRA_NUMBER, 0);

        TextView txtResult = (TextView) findViewById(R.id.totalScore);

        txtResult.setText("" + number);*/

        Button button = (Button) findViewById(R.id.returnBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReadQuiz();
            }
        });
    }
    public void openReadQuiz(){
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }
}
