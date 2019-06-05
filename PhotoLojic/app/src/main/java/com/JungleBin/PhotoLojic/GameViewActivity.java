package com.JungleBin.PhotoLojic;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;


import java.net.URI;

public class GameViewActivity extends AppCompatActivity {
    Button btnHome, btnOrigin;
    Chronometer chronometer;
    int count = 0;
    Bitmap bitmap;

    GameFragment gameFragment;
    ImageFragment imageFragment;

//    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

/*
        MobileAds.initialize(this, "");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/

        btnHome = (Button)findViewById(R.id.btnHome);
        btnOrigin = (Button)findViewById(R.id.btnOrigin);
        chronometer = (Chronometer) findViewById(R.id.chronometer);

        chronometer.setBase(SystemClock.elapsedRealtime());
        Intent urigetintent = getIntent();
        Bundle bundle = new Bundle();
        Uri uri = urigetintent.getParcelableExtra("imageUri");
        bundle.putParcelable("imageUri", uri);


        gameFragment = (GameFragment) getSupportFragmentManager().findFragmentById(R.id.gameFragment);
        imageFragment = (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.imageFragment);
        imageFragment.setArguments(bundle);
        gameFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().hide(imageFragment).commit();
        btnHome.setText("HOME");
        btnOrigin.setText("PHOTO");


        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        btnOrigin.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (count % 2 == 0) {

                    btnOrigin.setText("Game");
                    count++;
                    getSupportFragmentManager().beginTransaction().hide(gameFragment).commit();
                    getSupportFragmentManager().beginTransaction().show(imageFragment).commit();

                } else {
                    btnOrigin.setText("PHOTO");
                    count++;
                    getSupportFragmentManager().beginTransaction().hide(imageFragment).commit();
                    getSupportFragmentManager().beginTransaction().show(gameFragment).commit();
                }
            }
        }));
    }
    int startCheck = 0;
    @Override
    protected void onResume() {
        super.onResume();
        if(startCheck ==0){
            chronometer.setBase(SystemClock.elapsedRealtime());
            startCheck++;
        }
        chronometer.start();
    }

    @Override
    public void onBackPressed() {
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        finish();
    }
    int finishCheck = 0;
    public void completeWork(){
        if(finishCheck ==0){
            chronometer.stop();
            chronometer.setText("your record : " + chronometer.getText().toString());
            finishCheck++;
        }
    }
}
