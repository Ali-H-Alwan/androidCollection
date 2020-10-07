package com.example.dashboarduidesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class ActivitySplashScreen extends AppCompatActivity {
    ProgressBar progressBar;
    boolean handler;
    int splashTimeOut = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.progressBar);
        handler = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashTimeOut);

    }
}