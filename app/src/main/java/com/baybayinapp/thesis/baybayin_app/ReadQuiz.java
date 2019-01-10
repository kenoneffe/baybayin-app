package com.baybayinapp.thesis.baybayin_app;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class ReadQuiz extends AppCompatActivity {

    Button answer1, answer2, answer3;

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
                else
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
                if(answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else
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
                if(answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else
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

    private void updateQuestion(int num){
        quesCharacter.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }
}
