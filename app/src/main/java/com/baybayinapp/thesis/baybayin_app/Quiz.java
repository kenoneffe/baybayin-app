package com.baybayinapp.thesis.baybayin_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";

    private TextView textViewHighScore;

    private int highscore;

    Button toReadQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //textViewHighScore = findViewById(R.id.text_view_highscore)
        //loadHighScore();

        //reading quiz
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

        //startActivityForResult(intent, REQUEST_CODE_QUIZ);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                int score = data.getIntExtra(ReadQuiz.EXTRA_SCORE, 0);
                if(score > highscore){
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighScore.setText("Highscore: " + highscore);

    }
    private void updateHighscore(int highscoreNew){
        highscore = highscoreNew;
        textViewHighScore.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }

}
