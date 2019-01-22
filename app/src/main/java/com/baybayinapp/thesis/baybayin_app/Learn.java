package com.baybayinapp.thesis.baybayin_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mukesh.DrawingView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Learn extends AppCompatActivity {

    int penColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);


        com.raed.drawingview.DrawingView mDrawingView = findViewById(R.id.drawing_view);
        mDrawingView.setBackgroundColor(Color.TRANSPARENT);


        Intent intent = getIntent();
        String text = intent.getStringExtra(Chart.EXTRA_TEXT);
        TextView learnmainTV = (TextView)findViewById(R.id.learnTV);
        learnmainTV.setText(text);

        GifImageView gifView = findViewById(R.id.gifViewer);

        switch (text){
            case "A":
                gifView.setBackgroundResource(R.drawable.a);
                break;
            case "BA":
                gifView.setBackgroundResource(R.drawable.ba);
                break;
            case "KA":
                gifView.setBackgroundResource(R.drawable.ka);
                break;
            case "DA":
                gifView.setBackgroundResource(R.drawable.da);
                break;
            case "E":
                gifView.setBackgroundResource(R.drawable.e);
                break;
            case "GA":
                gifView.setBackgroundResource(R.drawable.ga);
                break;
            case "HA":
                gifView.setBackgroundResource(R.drawable.ha);
                break;
            case "I":
                gifView.setBackgroundResource(R.drawable.i);
                break;
            case "LA":
                gifView.setBackgroundResource(R.drawable.la);
                break;
            case "MA":
                gifView.setBackgroundResource(R.drawable.ma);
                break;
            case "NA":
                gifView.setBackgroundResource(R.drawable.na);
                break;
            case "NGA":
                gifView.setBackgroundResource(R.drawable.nga);
                break;
            case "O":
                gifView.setBackgroundResource(R.drawable.o);
                break;
            case "PA":
                gifView.setBackgroundResource(R.drawable.pa);
                break;
            case "RA":
                gifView.setBackgroundResource(R.drawable.ra);
                break;
            case "SA":
                gifView.setBackgroundResource(R.drawable.sa);
                break;
            case "TA":
                gifView.setBackgroundResource(R.drawable.ta);
                break;
            case "U":
                gifView.setBackgroundResource(R.drawable.u);
                break;
            case "WA":
                gifView.setBackgroundResource(R.drawable.wa);
                break;
            case "YA":
                gifView.setBackgroundResource(R.drawable.ya);
                break;
        }

        //penColor = ResourcesCompat.getColor(getResources(), R.color.colorBlack, null); //without theme

        /*DrawingView drawingView = (DrawingView) findViewById(R.id.scratch_pad);
        drawingView.initializePen(); //To use the pen mode to draw on the screen
        drawingView.setPenSize(30); //To set the size of the pen
        drawingView.setPenColor(penColor); //To set the color of the pen*/

        //ERASER
        //drawingView.initializeEraser(); //To use the eraser mode to clear the screen
        //drawingView.setBackgroundColor(@ColorInt int color); //To set the background color of the drawing view
        //drawingView.setEraserSize(float size); //To set the size of the eraser
        //drawingView.saveImage(String filePath, String filename, Bitmap.CompressFormat format, int quality); //To save the image after your done drawing
        //drawingView.loadImage(Bitmap bitmap); //Load image (your saved drawing)
        //drawingView.clear(); //clear image
    }


}
