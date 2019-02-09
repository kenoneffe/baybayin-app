package com.baybayinapp.thesis.baybayin_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ReadQuiz extends AppCompatActivity {

    public static final String EXTRA_SCORE = "com.baybayinapp.thesis.baybayin_app.EXTRA_SCORE";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewTime;
    private RadioGroup rbGrp;
    private RadioButton bttn1, bttn2, bttn3;
    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private List<Questions> questionsList;
    private int questionCounter;
    private int questionCountTotal;
    private Questions currentQuestion;

    private int score;
    private boolean answered;
    
    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_quiz);

        textViewQuestion = findViewById(R.id.quesCharacter);
        textViewScore = findViewById(R.id.score);
        textViewTime = findViewById(R.id.time);
        textViewQuestionCount = findViewById(R.id.quesCount);

        rbGrp = findViewById(R.id.rbGroup);
        bttn1 = findViewById(R.id.answer1);
        bttn2 = findViewById(R.id.answer2);
        bttn3 = findViewById(R.id.answer3);
        buttonConfirmNext = findViewById(R.id.buttonConfirmNext);

        textColorDefaultRb = bttn1.getTextColors();
        textColorDefaultCd = textViewTime.getTextColors();

            ReadQuizDBHelper dbHelper = new ReadQuizDBHelper(this);
            questionsList = dbHelper.getAllQuestions();
            questionCountTotal = questionsList.size();
            Collections.shuffle(questionsList);

            showNextQuestion();

            buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!answered){
                        if(bttn1.isChecked() || bttn2.isChecked() || bttn3.isChecked()){
                            checkAnswer();
                        }
                        else{
                            Toast.makeText(ReadQuiz.this, "Please select an answer.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        showNextQuestion();
                    }
                }
            });
    }

    private void showNextQuestion(){
        bttn1.setTextColor(textColorDefaultRb);
        bttn2.setTextColor(textColorDefaultRb);
        bttn3.setTextColor(textColorDefaultRb);
        rbGrp.clearCheck();

        if(questionCounter < questionCountTotal){
            currentQuestion = questionsList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            bttn1.setText(currentQuestion.getAnswer1());
            bttn2.setText(currentQuestion.getAnswer2());
            bttn3.setText(currentQuestion.getAnswer3());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("C O N F I R M");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDowm();
        }
        else
        {
            finishQuiz();
        }
    }
    private void startCountDowm(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewTime.setText(timeFormatted);

        if(timeLeftInMillis < 10000){
            textViewTime.setTextColor(Color.RED);
        }
        else
        {
            textViewTime.setTextColor(textColorDefaultCd);
        }
    }
    private void checkAnswer(){
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGrp.getCheckedRadioButtonId());
        int answerNr = rbGrp.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()){
            score++;
            textViewScore.setText("Score: " + score);
        }

        showSolution();
    }

    private void showSolution(){
        bttn1.setTextColor(Color.RED);
        bttn2.setTextColor(Color.RED);
        bttn3.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()){
            case 1:
                bttn1.setTextColor(Color.GREEN);
                break;
            case 2:
                bttn2.setTextColor(Color.GREEN);
                break;
            case 3:
                bttn3.setTextColor(Color.GREEN);
                break;
        }
        if (questionCounter < questionCountTotal){
            buttonConfirmNext.setText("N E X T  →");
        }
        else {
            buttonConfirmNext.setText("F I N I S H");
            Button button = findViewById(R.id.buttonConfirmNext);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openResultsActivity();
                }
            });
        }
    }

    public void openResultsActivity(){

        TextView textView1 = (TextView) findViewById(R.id.score);
        String number = textView1.getText().toString();

        Intent intent = new Intent(ReadQuiz.this, Result.class);
        intent.putExtra(EXTRA_SCORE, number);
        startActivity(intent);
    }

    private void finishQuiz(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            finishQuiz();
        }
        else{
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }
        
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        //outState.putParcelableArrayList(KEY_QUESTION_LIST, questionsList);
    }*/
}