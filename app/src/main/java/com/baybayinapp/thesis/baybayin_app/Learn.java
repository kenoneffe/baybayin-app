package com.baybayinapp.thesis.baybayin_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Learn extends AppCompatActivity {

    private TextView mainLeanTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        //main learn text view initailization
        mainLeanTV = findViewById(R.id.learnTV);





    }
}
