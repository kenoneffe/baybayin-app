package com.baybayinapp.thesis.baybayin_app;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapterReadingQuiz extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapterReadingQuiz(Context context){
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {

            R.drawable.india,
            R.drawable.old_paper,
            R.drawable.shell
    };

    private SlideAdapterReadingQuiz characterRead = new SlideAdapterReadingQuiz(){
        //final String[] character = resources.getStringArray(R.array.characters);
        //String arr[] = SlideAdapterReadingQuiz.this.getResources.getStringArray(R.array.characters);
    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        TextView slideCharacter = (TextView) view.findViewById(R.id.slide_char_reading);
        //TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        //slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    //To prevent any error when we get to the last page
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
