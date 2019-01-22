package com.baybayinapp.thesis.baybayin_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ReadQuiz extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewTime;
    private RadioGroup rbGroup;
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

    }

    private void showNextQuestion(){
        bttn1.setTextColor(textColorDefaultRb);
        bttn2.setTextColor(textColorDefaultRb);
        bttn3.setTextColor(textColorDefaultRb);

        if(questionCounter < questionCountTotal){
            currentQuestion = questionsList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            bttn1.setText(currentQuestion.getAnswer1());
            bttn2.setText(currentQuestion.getAnswer2());
            bttn3.setText(currentQuestion.getAnswer3());

            questionCounter++;
            // textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

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

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

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
                textViewQuestion.setText("Answer 1 is correct!");
                break;
            case 2:
                bttn2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct!");
                break;
            case 3:
                bttn3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct!");
                break;
        }
        if (questionCounter < questionCountTotal){
            buttonConfirmNext.setText("N E X T  →");
        }
        else {
            buttonConfirmNext.setText("F I N I S H");
        }
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
}

//------------------------------------READ QUIZ OLD------------------------------------//
    /*Button answer1, answer2, answer3;

    TextView score, quesCharacter;

    private Questions mQuestions = new Questions();

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_quiz);

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);

        score = (TextView) findViewById(R.id.score);
        quesCharacter = (TextView) findViewById(R.id.quesCharacter);

        score.setText("Score: " + mScore);

        updateQuestion(r.nextInt(mQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else if(answer1.getText() != mAnswer)
                {
                    //INSERT PROMPT MESSAGE: "Incorrect! The correct answer is (answer)"
                    AlertDialog alertDialog = new AlertDialog.Builder(ReadQuiz.this).create();
                    alertDialog.setTitle("Incorrect!");
                    alertDialog.setMessage("The correct answer is " + mAnswer);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    updateQuestion(r.nextInt(mQuestionsLength));
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else if(answer2.getText() != mAnswer)
                {
                    //INSERT PROMPT MESSAGE: "Incorrect! The correct answer is (answer)"
                    AlertDialog alertDialog = new AlertDialog.Builder(ReadQuiz.this).create();
                    alertDialog.setTitle("Incorrect!");
                    alertDialog.setMessage("The correct answer is " + mAnswer);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    updateQuestion(r.nextInt(mQuestionsLength));
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else if(answer3.getText() != mAnswer)
                {
                    //INSERT PROMPT MESSAGE: "Incorrect! The correct answer is (answer)"
                    AlertDialog alertDialog = new AlertDialog.Builder(ReadQuiz.this).create();
                    alertDialog.setTitle("Incorrect!");
                    alertDialog.setMessage("The correct answer is " + mAnswer);
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    updateQuestion(r.nextInt(mQuestionsLength));
                }
            }
        });
    }

    private void updateQuestion(int num) {
            quesCharacter.setText(mQuestions.getQuestion(num));
            answer1.setText(mQuestions.getChoice1(num));
            answer2.setText(mQuestions.getChoice2(num));
            answer3.setText(mQuestions.getChoice3(num));

            mAnswer = mQuestions.getCorrectAnswer(num);
    }*/