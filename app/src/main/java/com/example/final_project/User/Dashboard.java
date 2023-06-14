package com.example.final_project.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.final_project.Helper.Home.CategoriesAdapter;
import com.example.final_project.Helper.Home.CategoriesHelperClass;
import com.example.final_project.Helper.Home.FeaturedAdapter;
import com.example.final_project.Helper.Home.FeaturedHelper;
import com.example.final_project.Helper.Home.MostViewedAdapter;
import com.example.final_project.Helper.Home.MostViewedHelperClass;
import com.example.final_project.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView featuredCycler, mostViewedCycler, categCycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        featuredCycler = findViewById(R.id.featured_cycler);
        mostViewedCycler = findViewById(R.id.mv_cycler);
        categCycler = findViewById(R.id.categ_cycler);
        menuIcon = findViewById(R.id.menu_icon);

        //menu
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawer();

        featureCycler();
        mvCycler();
        catCycler();
    }

    private void navigationDrawer() {
        //navigation
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
    }


    private void mvCycler() {
        mostViewedCycler.setHasFixedSize(true);

        mostViewedCycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.yzu_gym, "YZU Gym","This is the testing description of YZU Gym, with no meaning"));

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.restaurant, "Siwei (十味健康素食)","This is the testing description of YZU Gym, with no meaning"));

  

        adapter = new MostViewedAdapter(mostViewedLocations);

        mostViewedCycler.setAdapter(adapter);
    }
    private void featureCycler(){
        featuredCycler.setHasFixedSize(true);
        featuredCycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelper> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelper(R.drawable.yzu_gym,"YZU Gym","This is the testing description of YZU Gym, with no meaning"));
        featuredLocations.add(new FeaturedHelper(R.drawable.restaurant,"Siwei (十味健康素食)","This is the testing description of Seiwei (十味健康素食), with no meaning"));
        featuredLocations.add(new FeaturedHelper(R.drawable.fruits_shop,"珍蜜平價水果","This is the testing description of 珍蜜平價水果 fruit shops, with no meaning"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredCycler.setAdapter(adapter);

        //GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{0xF5F0BB,0xC4DFAA, 0x90C8AC});
    }
    private void catCycler() {

        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});

        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});

        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});

        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();

        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1,R.drawable.gym_categ, "gyms"));

        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2,R.drawable.restaurant_categ, "restaurant"));

        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3,R.drawable.shop_categ, "fruits shop"));

        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4,R.drawable.park_categ, "park"));

        //categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable., ""));

        categCycler.setHasFixedSize(true);

        adapter = new CategoriesAdapter(categoriesHelperClasses);

        categCycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        categCycler.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}