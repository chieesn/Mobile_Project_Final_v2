package com.example.final_project.Material;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.final_project.User.Dashboard;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;
    ImageView splashImg;
    TextView poweredBy;
    SharedPreferences boarding;

    Animation splashAnim, powerAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);

        splashImg = findViewById(R.id.splashImg);
        poweredBy = findViewById(R.id.poweredBy);

        splashAnim = AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        powerAnim = AnimationUtils.loadAnimation(this,R.anim.power_anim);

        //set animation
        splashImg.setAnimation(splashAnim);
        poweredBy.setAnimation(powerAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boarding = getSharedPreferences("boarding",MODE_PRIVATE);
                boolean firstTime = boarding.getBoolean("firstTime",true);
                /*
                if(firstTime){
                    SharedPreferences.Editor editor = boarding.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(),Boarding.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(intent);
                    finish();
                }*/

                Intent intent = new Intent(getApplicationContext(),Boarding.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
    }
}