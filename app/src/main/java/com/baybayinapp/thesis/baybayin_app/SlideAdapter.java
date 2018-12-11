package com.baybayinapp.thesis.baybayin_app;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {

            R.drawable.india,
            R.drawable.old_paper,
            R.drawable.shell
    };

    public String[] slide_headings = {
            "BRAHMIC FAMILY",
            "ANCIENT SCRIPT",
            "GIANT CLAM"
    };

    public String[] slide_descs = {
            "Paul Morrow of The Filipino Express (2017) explored some of the claims that Baybayin, our ancient script known to be developed from the Brahmic script of India, possessed a meaning beyond its actual function. It is a pre-Spanish Philippine writing system. It is a member of the Brahmic family and is recorded as being in use in the 16th century.",
            "Description",
            "Description"

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    //To prevent any error when we get to the last page
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
