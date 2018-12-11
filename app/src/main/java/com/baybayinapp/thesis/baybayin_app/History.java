package com.baybayinapp.thesis.baybayin_app;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class History extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private SlideAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);

        sliderAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
    }
}
