package com.baybayinapp.thesis.baybayin_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private static final  int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView resultLabel;
    private int highscore;

    private Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //resultLabel = findViewById(R.id.totalScore);
        //loadHighScore();

        Intent intent = getIntent();
        String number = intent.getStringExtra(ReadQuiz.EXTRA_SCORE);

        TextView textView2 = (TextView) findViewById(R.id.totalScore);
        textView2.setText(number);

        Button returnReadQuiz = findViewById(R.id.returnBtn);
        returnReadQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openReadQuiz();
            }
        });
    }

    public void openReadQuiz(){
        Intent intent = new Intent (Result.this, MainActivity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }
}
