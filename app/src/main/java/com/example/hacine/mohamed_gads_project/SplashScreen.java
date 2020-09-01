package com.example.hacine.mohamed_gads_project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {
// i used external library to make splash screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
getSupportActionBar().setTitle("");
        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(R.color.bbl)
                .withBackgroundResource(R.color.bbl)


                .withLogo(R.drawable.gads);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);    }
}