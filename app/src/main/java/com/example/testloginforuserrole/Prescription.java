package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DiagnoseData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityPrescriptionBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescription extends AppCompatActivity {

    ActivityPrescriptionBinding binding;
    MyDatabaseHelper db;
    ArrayList<UserModel> arrayList;
    DiagnoseData diagnoseData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPrescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        db = new MyDatabaseHelper(this);
        diagnoseData = new DiagnoseData(db);

        arrayList = diagnoseData.getInfoPrescription();


        Intent intent = this.getIntent();

        if (intent != null) {


            String name = intent.getStringExtra("name");
            String genderPatient = intent.getStringExtra("Gender");
            String dateOfBirthPatient = intent.getStringExtra("DateOfBirth");
            String prescription = intent.getStringExtra("Prescription");
            String drName = intent.getStringExtra("DrName");
            String splization = intent.getStringExtra("Splization");
            String appointDate = intent.getStringExtra("AppointDate");


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

            //1/1/1990

            //calculate age
            int currentYear = Integer.parseInt(simpleDateFormat.format(new Date()));
            int birth = Integer.parseInt(dateOfBirthPatient.substring(4,8));
            int age = currentYear - birth;



            binding.txtViewPrescriptionPatientName1.setText(name);
            binding.txtViewPrescriptionSex.setText(genderPatient);
            binding.txtViewPrescriptionAge.setText(String.valueOf(age));
            binding.txtViewPrescriptionTreatment.setText(prescription);
            binding.txtViewPrescriptionDrName.setText(drName);
            binding.txtViewPrescriptionSignature.setText(splization);
            binding.txtViewPrescriptionDate.setText(appointDate);
        }
    }


}