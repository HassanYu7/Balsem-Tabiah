package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BackgroundScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_screen);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);

                    Intent intent = new Intent(BackgroundScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();


        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//                );
//    }
}