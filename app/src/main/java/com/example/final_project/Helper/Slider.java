package com.example.final_project.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.final_project.R;

public class Slider extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public Slider(Context context) {
        this.context = context;
    }

    int imgs[] = {
            R.drawable.board1,
            R.drawable.board2,
            R.drawable.board3,
            R.drawable.board4
    };

    int headings[] = {
            R.string.boarding_title1,
            R.string.boarding_title2,
            R.string.boarding_title3,
            R.string.boarding_title4
    };

    int descriptions[] = {
            R.string.boarding_description1,
            R.string.boarding_description2,
            R.string.boarding_description3,
            R.string.boarding_description4
    };

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides,container, false);

        ImageView imageView = view.findViewById(R.id.slider_img);
        TextView heading = view.findViewById(R.id.slider_heading);
        TextView description = view.findViewById(R.id.slider_description);

        imageView.setImageResource(imgs[position]);
        heading.setText(headings[position]);
        description.setText(descriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
