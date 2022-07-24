package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testloginforuserrole.databinding.ActivityReceptionistBinding;

public class ActivityReceptionist extends AppCompatActivity {

    Button addPatient,editPatient,coordinateAppointment,bookForPatient;
    ActivityReceptionistBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = ActivityReceptionistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.cardViewAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReceptionist.this, Register.class));
            }
        });

        binding.cardViewEditPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReceptionist.this, EditPatient.class));
            }
        });

        binding.cardViewCoordinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReceptionist.this,CoordinateAppointmentDoctor.class));
            }
        });

        binding.cardViewBookForPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReceptionist.this, Activity_Appointment.class));

            }
        });
        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReceptionist.this, MainActivity.class));
            }
        });

        binding.cardViewListViewAppointmentReciptionist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReceptionist.this,ListAppointment.class));
            }
        });

        binding.cardViewEditDateForDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityReceptionist.this,EditDateForDoctor.class));
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


//        addPatient = findViewById(R.id.button_add_patient_from_receptionist);
//        addPatient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    Intent intent = new Intent(ActivityReceptionist.this,Register.class);
//                    startActivity(intent);
//
//            }
//        });
//
//        editPatient = findViewById(R.id.button_edit_patient_from_receptionist);
//        editPatient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ActivityReceptionist.this,EditPatient.class);
//                startActivity(intent);
//            }
//        });
//
//        coordinateAppointment = findViewById(R.id.button_coordinate_appointment);
//        coordinateAppointment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            //    startActivity(new Intent(ActivityReceptionist.this,CategoryDoctor.class));
//                startActivity(new Intent(ActivityReceptionist.this,CoordinateAppointmentDoctor.class));
//            }
//        });
//
//        bookForPatient = findViewById(R.id.button_book_for_patient);
//        bookForPatient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ActivityReceptionist.this,BookForPatientFromReceptionist.class));
//            }
//        });


    }
}