package com.baybayinapp.thesis.baybayin_app;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.raed.drawingview.DrawingView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class HandwritingQuiz extends AppCompatActivity {

    public static HandwritingQuiz instance = null;

    DrawingView hwqDrawingView;

    Bitmap image;
    private TessBaseAPI mTess;
    String datapath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handwriting_quiz);


        instance = this;
        copyTessDataForTextRecognizor();


        hwqDrawingView = findViewById(R.id.handQ_drawing_view);
        hwqDrawingView.setUndoAndRedoEnable(true);
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

                Bitmap bitmap = hwqDrawingView.exportDrawing();

                OcrManager manager = new OcrManager();
                manager.initAPI();
                manager.startRecognize(bitmap);







            }
        });

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
