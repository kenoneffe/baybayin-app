package com.baybayinapp.thesis.baybayin_app;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.raed.drawingview.DrawingView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HandwritingQuiz extends AppCompatActivity {

    public static HandwritingQuiz instance = null;

    DrawingView hwqDrawingView;
    TextView tv_questions;
    List<HQitems> questions;
    int curQuestions = 0;
    Button nextBTN;
    TextView tvQcount;
    int questionCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handwriting_quiz);


        instance = this;
        copyTessDataForTextRecognizor();


        hwqDrawingView = findViewById(R.id.handQ_drawing_view);
        hwqDrawingView.setUndoAndRedoEnable(true);
        tvQcount = findViewById(R.id.itemqueueTV);
        nextBTN = findViewById(R.id.nextHQ);
        tv_questions = findViewById(R.id.learnTVHQ);
        questions = new ArrayList<>();

        nextBTN.setVisibility(View.INVISIBLE);

        //add all question and answer to the HQ
        for(int i = 0; i < HQquestionans.questions.length; i++){

            questions.add(new HQitems(HQquestionans.questions[i], HQquestionans.answers[i]));

        }

        //shuffle the questions
        Collections.shuffle(questions);

        tv_questions.setText(questions.get(curQuestions).getQuestions());



        Button clrBTN = (Button) findViewById(R.id.clrbtnHQ);
        clrBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hwqDrawingView.clear();
            }
        });
        final Button undoBTN =  (Button) findViewById(R.id.undobtnHQ);
        undoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hwqDrawingView.undo();
                undoBTN.setEnabled(!hwqDrawingView.isUndoStackEmpty());
                undoBTN.setEnabled(!hwqDrawingView.isRedoStackEmpty());
            }
        });

        Button submitBTN = (Button) findViewById(R.id.submitHQ);

        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(OCR().equals(questions.get(curQuestions).getAnswers())){
                    nextBTN.setVisibility(View.VISIBLE);
                }else {
                    nextBTN.setVisibility(View.INVISIBLE);
                }






            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curQuestions < HQquestionans.questions.length - 1){
                    //
                    hwqDrawingView.clear();
                    questionCounter++;
                    curQuestions++;
                    tvQcount.setText("Question: " + questionCounter + "/" + HQquestionans.questions.length);
                    tv_questions.setText(questions.get(curQuestions).getQuestions());
                    nextBTN.setVisibility(View.INVISIBLE);

                    //ocr
                    OCR();
                }else {
                    //finish the quiz
                    Toast.makeText(HandwritingQuiz.this,"You finish the quiz!",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }

    public String OCR(){
        String OCRresult = null;
        hwqDrawingView = (DrawingView) findViewById(R.id.handQ_drawing_view);
        Bitmap bitmap =  hwqDrawingView.exportDrawing();
        OcrManager manager = new OcrManager();
        manager.initAPI();
        manager.startRecognize(bitmap);
        OCRresult = manager.startRecognize(bitmap);
        //TextView tv_OCR_Result = (TextView) findViewById(R.id.learnTVHQ);
        //tv_OCR_Result.setText(OCRresult);
        //Toast.makeText(getApplicationContext(),OCRresult,Toast.LENGTH_LONG).show();
        return OCRresult;
    }




    private String tessDataPath()
    {
        return HandwritingQuiz.instance.getExternalFilesDir(null)+"/tessdata/";
    }

    public String getTessDataParentDirectory()
    {
        return HandwritingQuiz.instance.getExternalFilesDir(null).getAbsolutePath();
    }



    private void copyTessDataForTextRecognizor()
    {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                AssetManager assetManager = HandwritingQuiz.instance.getAssets();
                OutputStream out =null;
                try {
                    InputStream in = assetManager.open("bcd.traineddata");
                    String tesspath = instance.tessDataPath();
                    File tessFolder = new File(tesspath);
                    if(!tessFolder.exists())
                        tessFolder.mkdir();
                    String tessData = tesspath+"/"+"bcd.traineddata";
                    File tessFile = new File(tessData);
                    if(!tessFile.exists())
                    {
                        out = new FileOutputStream(tessData);
                        byte[] buffer = new byte[1024];
                        int read = in.read(buffer);
                        while (read != -1) {
                            out.write(buffer, 0, read);
                            read = in.read(buffer);
                        }
                        Log.d("MainApplication", " Did finish copy tess file  ");


                    }
                    else
                        Log.d("MainApplication", " tess file exist  ");

                } catch (Exception e)
                {
                    Log.d("MainApplication", "couldn't copy with the following error : "+e.toString());
                }finally {
                    try {
                        if(out!=null)
                            out.close();
                    }catch (Exception exx)
                    {

                    }
                }
            }
        };
        new Thread(run).start();
    }

}
