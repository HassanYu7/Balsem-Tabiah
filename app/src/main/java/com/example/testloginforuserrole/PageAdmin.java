package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testloginforuserrole.databinding.ActivityPageAdminBinding;

public class PageAdmin extends AppCompatActivity {

    ManageDoctor m;
    public static boolean isAddButtonTriggered = false;
    ActivityPageAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPageAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardviewAddDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   startActivity(new Intent(PageAdmin.this, ManageDoctor.class));
                isAddButtonTriggered = true;
                Intent intent = new Intent(PageAdmin.this,ManageDoctor.class);
                startActivity(intent);
            }
        });

        binding.cardviewDeleteDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAddButtonTriggered = false;
                Intent intent = new Intent(PageAdmin.this,ManageDoctor.class);
                startActivity(intent);
              //  startActivity(new Intent(PageAdmin.this, ManageDoctor.class));


            }
        });


        binding.cardviewAddReceptionist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAdmin.this,AddReceptionist.class);
                startActivity(intent);
            }
        });

        binding.cardviewDeleteReceptionist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageAdmin.this,DeleteReceptionist.class);
                startActivity(intent);
            }
        });

        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PageAdmin.this, MainActivity.class));
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