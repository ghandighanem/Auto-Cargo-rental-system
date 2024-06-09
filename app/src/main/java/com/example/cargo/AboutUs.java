package com.example.cargo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {
    private ImageView aboutBtn, contactBtn, homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        onResume();;

        setupListeners();
        saveVisit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        contactBtn = findViewById(R.id.contacticon);
        aboutBtn = findViewById(R.id.aboutIcon);
        homeBtn = findViewById(R.id.homepic);

    }
    private void setupListeners() {
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUs.this, AboutUs.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUs.this, mainpage.class));
            }
        });
        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUs.this, contactUs.class));
            }
        });
    }

    private void saveVisit() {
        SharedPreferences sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("visited_about_us", true);
        editor.apply();
    }

    private boolean hasVisitedBefore() {
        SharedPreferences sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("visited_about_us", false);
    }
}
