package com.baybayinapp.thesis.baybayin_app;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mukesh.DrawingView;

public class Learn extends AppCompatActivity {

    int penColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);


        penColor = ResourcesCompat.getColor(getResources(), R.color.colorBlack, null); //without theme

        DrawingView drawingView = (DrawingView) findViewById(R.id.scratch_pad);
        drawingView.initializePen(); //To use the pen mode to draw on the screen
        drawingView.setPenSize(30); //To set the size of the pen
        drawingView.setPenColor(penColor); //To set the color of the pen

        //ERASER
        //drawingView.initializeEraser(); //To use the eraser mode to clear the screen
        //drawingView.setBackgroundColor(@ColorInt int color); //To set the background color of the drawing view
        //drawingView.setEraserSize(float size); //To set the size of the eraser
        //drawingView.saveImage(String filePath, String filename, Bitmap.CompressFormat format, int quality); //To save the image after your done drawing
        //drawingView.loadImage(Bitmap bitmap); //Load image (your saved drawing)
        //drawingView.clear(); //clear image
    }
}
