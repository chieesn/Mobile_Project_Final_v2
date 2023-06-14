package com.example.final_project.Helper.Home;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {
    int image;
    String title;

    GradientDrawable gd;

    public CategoriesHelperClass(GradientDrawable gd, int image, String title) {
        this.image = image;
        this.title = title;
        this.gd = gd;
    }

    public int getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }

    public Drawable getGradient() {
        return gd;
    }
}
