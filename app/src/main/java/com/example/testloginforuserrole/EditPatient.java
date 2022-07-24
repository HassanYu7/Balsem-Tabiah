package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.data.PatientData;
import com.example.testloginforuserrole.database.model.PatientModel;
import com.example.testloginforuserrole.databinding.ActivityEditPatientBinding;

public class EditPatient extends AppCompatActivity {



    EditText searchIdPatient;
    Button buttonSearchPatient, buttonUpdatePatient;
    MyDatabaseHelper helper;
    PatientData patientData;
    SQLiteDatabase sqLiteDatabase;
    EditText idPatient,firstName, middleName, lastName, phoneNo, address, dateBirth;
    String searchID,newID,newFirstName,newMiddleName,newLastName,newPhone,newAddress,newDateBirth;
    ActivityEditPatientBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditPatientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditPatient.this, ActivityReceptionist.class));
            }
        });


        helper = new MyDatabaseHelper(this);
        patientData = new PatientData(helper);

        searchIdPatient = (EditText) findViewById(R.id.edit_text_id_patient_to_edit);

        idPatient = (EditText) findViewById(R.id.edit_text_id_number_patient_for_edit);
        firstName = (EditText) findViewById(R.id.edit_text_first_name_patient_for_edit);
        middleName = (EditText) findViewById(R.id.edit_text_middle_name_patient_for_edit);
        lastName = (EditText) findViewById(R.id.edit_text_last_name_patient_for_edit);
        phoneNo = (EditText) findViewById(R.id.edit_text_phone_number_patient_for_edit);
        address = (EditText) findViewById(R.id.edit_text_address_patient_for_edit);
        dateBirth = (EditText) findViewById(R.id.edit_text_date_birth_patient_for_edit);

        buttonUpdatePatient = (Button) findViewById(R.id.button_update_patient);
        buttonSearchPatient = (Button) findViewById(R.id.button_search_patient);

        idPatient.setVisibility(View.GONE);
        firstName.setVisibility(View.GONE);
        middleName.setVisibility(View.GONE);
        lastName.setVisibility(View.GONE);
        phoneNo.setVisibility(View.GONE);
        address.setVisibility(View.GONE);
        dateBirth.setVisibility(View.GONE);
        buttonUpdatePatient.setVisibility(View.GONE);


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


    // TODO: Add gender to can change it
    public void updatePatient(View view){
        helper = new MyDatabaseHelper(getApplicationContext());
        sqLiteDatabase = helper.getReadableDatabase();
        String fName,mName,lName,address_,dateBirth_;

        fName = firstName.getText().toString();
        mName = middleName.getText().toString();
        lName = lastName.getText().toString();
        address_ = address.getText().toString();
        dateBirth_ = dateBirth.getText().toString();

        int id = Integer.parseInt(idPatient.getText().toString());
        int phone = Integer.parseInt(phoneNo.getText().toString());

        PatientModel patientModel = new PatientModel(id,phone,fName,mName,lName,address_,dateBirth_);

        int count = patientData.updatePatient(searchID,patientModel, sqLiteDatabase);
        Toast.makeText(getApplicationContext(),count + "patient updated",Toast.LENGTH_SHORT).show();
    }


    // TODO: Disable (ID) to prevent change it
    public void search(View view){
        searchID = searchIdPatient.getText().toString();
        helper = new MyDatabaseHelper(getApplicationContext());
        sqLiteDatabase = helper.getReadableDatabase();
        Cursor cursor = patientData.getContent(searchID,sqLiteDatabase);

        if (cursor.moveToFirst()){
            newID = cursor.getString(0);
            newFirstName = cursor.getString(1);
            newMiddleName = cursor.getString(2);
            newLastName = cursor.getString(3);
            newPhone = cursor.getString(4);
            newAddress = cursor.getString(5);
            newDateBirth = cursor.getString(6);

            newID = searchID;

            idPatient.setText(newID);
            firstName.setText(newFirstName);
            middleName.setText(newMiddleName);
            lastName.setText(newLastName);
            phoneNo.setText(newPhone);
            address.setText(newAddress);
            dateBirth.setText(newDateBirth);

            idPatient.setVisibility(View.VISIBLE);
            firstName.setVisibility(View.VISIBLE);
            middleName.setVisibility(View.VISIBLE);
            lastName.setVisibility(View.VISIBLE);
            phoneNo.setVisibility(View.VISIBLE);
            phoneNo.setVisibility(View.VISIBLE);
            dateBirth.setVisibility(View.VISIBLE);
            address.setVisibility(View.VISIBLE);

            buttonUpdatePatient.setVisibility(View.VISIBLE);
        }
    }
}