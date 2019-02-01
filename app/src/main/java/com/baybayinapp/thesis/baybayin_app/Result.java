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

        Intent intent = getIntent();
        int number = intent.getIntExtra(ReadQuiz.EXTRA_SCORE, 0);

        TextView textView1 = (TextView) findViewById(R.id.score);

        textView1.setText("" + number);
    }
    public void openReadQuiz(){
        Intent intent = new Intent (Result.this, ReadQuiz.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                int score = data.getIntExtra(ReadQuiz.EXTRA_SCORE, 0);
                if(score > highscore){
                    updateHighScore(score);
                }
            }
        }
    }

    private void loadHighScore()
    {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        resultLabel.setText("Highscore: " + highscore);
    }
    private void updateHighScore(int newHighscore){
        highscore = newHighscore;
        resultLabel.setText("Highscore: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}
