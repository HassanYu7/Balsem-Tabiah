package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.data.PatientData;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.database.model.PatientModel;
import com.example.testloginforuserrole.databinding.ActivityRegisterBinding;

import java.util.Calendar;
import java.util.Random;

public class Register extends AppCompatActivity {

    EditText firstName,middleName,lastName,idPatient,phoneNo,address,dateBirth;
    MyDatabaseHelper helper;
    PatientData patientData;
    RadioButton rdMale,rdFemale;
    RadioGroup rdGroup;
    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        hideNavigationBar();

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateBirth = findViewById(R.id.edit_text_date_birth_patient);
        dateBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this, AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                        dateBirth.setText(year1+"/"+month1+"/"+dayOfMonth);
                    }
                },year,month,day);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
               // datePickerDialog.setTitle("Select Date");
                datePickerDialog.show();
            }
        });
      //  dateBirth.setInputType(InputType.TYPE_NULL);



        helper = new MyDatabaseHelper(this);
        patientData = new PatientData(helper);



        rdGroup = (RadioGroup) findViewById(R.id.radio_group_patient);
        rdMale = (RadioButton) findViewById(R.id.radio_male_patient);
        rdFemale = (RadioButton) findViewById(R.id.radio_female_patient);
        binding.buttonAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });
    }

    // TODO: Change date to DATE
    // TODO: ID Record in package table to AUTOINCREMENT
    public void button_register_patient(View v){

        firstName = findViewById(R.id.edit_text_first_name_patient);
        middleName = findViewById(R.id.edit_text_middle_name_patient);
        lastName = findViewById(R.id.edit_text_last_name_patient);
        idPatient = findViewById(R.id.edit_text_id_number_patient);
        phoneNo = findViewById(R.id.edit_text_phone_number_patient);
        address = findViewById(R.id.edit_text_address_patient);


        //  String radio1 = Integer.toString(rdGroup.getId());
        String radiovaluea = ((RadioButton) this.findViewById(rdGroup.getCheckedRadioButtonId())).getText().toString();


        String firstname = firstName.getText().toString();
        String middlenaame = middleName.getText().toString();
        String lastname = lastName.getText().toString();
        String addressPatient = address.getText().toString();
        String datePatient = dateBirth.getText().toString();


        long id = Long.parseLong(idPatient.getText().toString());
        long phone = Long.parseLong(phoneNo.getText().toString());


//         idRecord.nextInt(5800);


        PatientModel patientModel = new PatientModel(id,phone,firstname,middlenaame,lastname,radiovaluea,addressPatient,datePatient);

        patientData.addPatient(patientModel);
    }

    private void hideNavigationBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                ); }


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
}