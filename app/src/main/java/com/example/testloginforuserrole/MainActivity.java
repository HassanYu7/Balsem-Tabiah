package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testloginforuserrole.database.data.AdminData;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.PatientData;
import com.example.testloginforuserrole.database.data.ReceptionistData;
import com.example.testloginforuserrole.database.model.AdminModel;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.database.table.AdminDB;
import com.example.testloginforuserrole.database.table.DoctorDB;
import com.example.testloginforuserrole.database.table.PatientDB;
import com.example.testloginforuserrole.database.table.ReceptionistDB;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    TextInputEditText EditTextUser,EditTextPass;
    Button buttonLogin;
    MyDatabaseHelper myDB;
    ArrayList<String> name_doctor, specialization_doctor, gender_doctor;
    ArrayList<String> firstName_receptionist, midName_receptionist, gender_receptionist;
    ArrayList<String> phone_patient, id_patient;
//    CustomAdapter customAdapter;
    DoctorData doctorData;
    ReceptionistData receptionistData;
    PatientData patientData;
    AdminData adminData;
    Button registerPatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        EditTextUser = findViewById(R.id.username);
        EditTextPass = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.button_login);


        myDB = new MyDatabaseHelper(MainActivity.this);

        name_doctor = new ArrayList<>();
        specialization_doctor = new ArrayList<>();
        gender_doctor = new ArrayList<>();

        firstName_receptionist = new ArrayList<>();
        midName_receptionist = new ArrayList<>();
        gender_receptionist = new ArrayList<>();


        phone_patient = new ArrayList<>();
        id_patient = new ArrayList<>();


        storeDataInArrays();
        storeDataInArraysReceptionist();
        storeDataInArraysPatient();
//        customAdapter = new CustomAdapter(MainActivity.this,name_doctor,specialization_doctor,gender_doctor);

        registerPatient = findViewById(R.id.button_register);
        registerPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });



    }



    @Override
    protected void onStart() {
        super.onStart();
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

    private void hideNavigationBar(){
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

    //    public void FullScreencall() {
//        if(Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
//            View v = this.getWindow().getDecorView();
//            v.setSystemUiVisibility(View.GONE);
//        } else if(Build.VERSION.SDK_INT >= 19) {
//            //for new api versions.
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
//            decorView.setSystemUiVisibility(uiOptions);
//        }
//    }

    void storeDataInArrays(){
        doctorData = new DoctorData(myDB);
        Cursor cursor = doctorData.readAllDataFromDoctor();
        if (cursor.getCount() == 0){
//            Toast.makeText(this,null,Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                name_doctor.add(cursor.getString(1));
                specialization_doctor.add(cursor.getString(2));
                gender_doctor.add(cursor.getString(3));
            }
        }
    }

    void storeDataInArraysReceptionist(){
        receptionistData = new ReceptionistData(myDB);
        Cursor cursor = receptionistData.readAllDataFromReceptionist();
        if (cursor.getCount() == 0){
//            Toast.makeText(this,null,Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                firstName_receptionist.add(cursor.getString(1));
                midName_receptionist.add(cursor.getString(2));
                gender_receptionist.add(cursor.getString(3));
            }
        }
    }

    void storeDataInArraysPatient(){
        patientData = new PatientData(myDB);
        Cursor cursor = patientData.readAllDataFromPatient();
        if (cursor.getCount() == 0){
           // Toast.makeText(this,null,Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                phone_patient.add(cursor.getString(1));
                id_patient.add(cursor.getString(2));
            }
        }
    }

    // TODO: Change name variables ..
    // TODO: Check receptionist for login without enter Phone number, Because it can login just by ID number!
    public  void onBtnLoginInClick(View v){



        if (v.getId() == R.id.button_login) {

            EditText UserNameET = (EditText) findViewById(R.id.username);
            String UserNameStr = UserNameET.getText().toString();

            EditText PasswordET = (EditText) findViewById(R.id.password);
            String PasswordStr = PasswordET.getText().toString();

            String dbPhoneDoctor = doctorData.Login(UserNameStr);
            String dbPhoneReceptionist = receptionistData.Login(UserNameStr);
            String dbPhonePatient = patientData.Login(UserNameStr);


            if (UserNameStr.isEmpty()){
                UserNameET.setError("Please enter phone number");
                UserNameET.requestFocus();
            } else {
                PasswordET.setError("Please enter ID number");
                PasswordET.requestFocus();
            }


            if (dbPhoneDoctor.equals(PasswordStr)) {
                Intent loginIntent = new Intent(this, ActivityDoctor.class);
                loginIntent.putExtra(DoctorDB.PHONE_NO, UserNameStr);
                loginIntent.putExtra(DoctorDB.ID_DOCTOR, PasswordStr);
                startActivity(loginIntent);
            } else if (dbPhoneReceptionist.equals(PasswordStr)) {
                Intent loginIntent = new Intent(this, ActivityReceptionist.class);
                loginIntent.putExtra(ReceptionistDB.PHONE_NO, UserNameStr);
                loginIntent.putExtra(ReceptionistDB.ID_RECEPTIONIST, PasswordStr);
                startActivity(loginIntent);
            }
            else if (dbPhonePatient.equals(PasswordStr)){
                Intent loginIntent = new Intent(this, MainPatient.class);
//                loginIntent.putExtra(PatientDB.PHONE_NO, UserNameStr);
//                loginIntent.putExtra(PatientDB.ID_PATIENT, PasswordStr);
                loginIntent.putExtra("phoneNumber", PatientDB.PHONE_NO);
                loginIntent.putExtra("idPatient", PatientDB.ID_PATIENT);
                loginIntent.putExtra("firstName", PatientDB.FIRST_NAME);
                loginIntent.putExtra("middleName", PatientDB.MIDDLE_NAME);
                loginIntent.putExtra("lastName", PatientDB.LAST_NAME);
                startActivity(loginIntent);
            }
         /*
            else if (adminData.Login(PasswordStr).equals("ahmed")){
                Intent loginIntent = new Intent(this,PageAdmin.class);
                loginIntent.putExtra(AdminDB.USER_NAME,UserNameStr);
                loginIntent.putExtra(AdminDB.PASSWORD,PasswordStr);
                startActivity(loginIntent);
            }

          */
/*
            else if (dbPhonePatient.equals(PasswordStr)){
                Intent loginIntent = new Intent(this,ActivityReceptionist.class);
                loginIntent.putExtra(PatientDB.PHONE_NO,UserNameStr);
                loginIntent.putExtra(PatientDB.ID_PERSONAL,PasswordStr);
                startActivity(loginIntent);
            }
*/

            else if (EditTextUser.getText().toString().equalsIgnoreCase("admin") && EditTextPass.getText().toString().equalsIgnoreCase("admin")) {
                Intent intent = new Intent(MainActivity.this, PageAdmin.class);
                Toast.makeText(MainActivity.this, "Welcome " + EditTextUser.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } else {
                Toast.makeText(this, "ID and phone number don't match!", Toast.LENGTH_SHORT).show();
            }

        }


    }



}