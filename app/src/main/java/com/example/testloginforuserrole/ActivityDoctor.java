package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testloginforuserrole.databinding.ActivityDoctorBinding;

public class ActivityDoctor extends AppCompatActivity {

    ActivityDoctorBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.cardviewListViewAppointmentForDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDoctor.this,ApppintmentDoctor.class));
            }
        });

        binding.iconBackDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityDoctor.this,MainActivity.class));
            }
        });

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






}