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

            R.drawable.blocks,
            R.drawable.dictionary,
            R.drawable.contract,
            R.drawable.india,
            //R.drawable.old_paper,
            //R.drawable.shell
    };

    public String[] slide_headings = {

            "ALIBATA",
            "MADJAPAHIT",
            "PATINIG AT KATINIG",
            "PANGSULAT",
            //"ANCIENT SCRIPT",
            //"GIANT CLAM"
    };

    public String[] slide_descs = {
            "Ito ang kinikilalang unang sistema ng pagsulat ng mga Pilipino. Mula sa Alifabata ng Arabia na nang lumaon ay naging ALIBATA.",
            "Nakaabot sa Pilipinas sa daang India, Java, Sumatra, Borneo at Malaya. Pinaniniwalaang pumasok ito nang maitatag ang emperyo ng Madjapahit sa Java.",
            "Binubuo ito ng tatlong (3) patinig: a, e / i at o / u. Mayroon din itong labinlimang (15) katinig: ba, ka, da, ga, ha, la, ma, na, nga, pa, sa, ta, wa at ya.",
            "Karaniwang sulatan ng mga sinaunang Pilipino ang mga dahon, murang kawayan, balat ng kahoy o puno at tanso."
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
