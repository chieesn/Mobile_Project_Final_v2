package com.example.final_project.Material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.final_project.Helper.Slider;
import com.example.final_project.R;
import com.example.final_project.User.Dashboard;

public class Boarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout lnlayout;
    Slider sliderAdapter;
    TextView[] dots;
    Button getStarted;
    int curPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_boarding);

        viewPager = findViewById(R.id.slider);
        lnlayout = findViewById(R.id.lnlayout);
        getStarted = findViewById(R.id.getStarted_btn);

        sliderAdapter = new Slider(this);
        viewPager.setAdapter(sliderAdapter);

        sliderDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view){
        startActivity(new Intent(getApplicationContext(), Dashboard.class));
        finish();
    }

    public void next(View view){
        viewPager.setCurrentItem(curPos+1);
    }
    private void sliderDots(int pos){
        dots = new TextView[4];
        lnlayout.removeAllViews();

        for(int i = 0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;")); //special character that displayed as a dot
            dots[i].setTextSize(40);

            lnlayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[pos].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            sliderDots(position);
            curPos = position;
            if(position == 3){
                getStarted.setVisibility(View.VISIBLE);
            }else{
                getStarted.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}