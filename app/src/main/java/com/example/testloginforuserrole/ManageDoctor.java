package com.example.testloginforuserrole;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.databinding.ActivityAddDoctorBinding;

public class ManageDoctor extends AppCompatActivity {

    EditText firstName,middleName,lastName,phoneNo,specialization,idPersonal, idPersonalDelete, specializationE;
    MyDatabaseHelper helper;
    DoctorData doctorData;
    RadioButton rdMale,rdFemale;
    RadioGroup rdGroup;
    PageAdmin pageAdmin;
    SQLiteDatabase sqLiteDatabase;
    ImageView iconBack;

    // TODO: Change EditText for specialization to become SPINNER
    // TODO: Two icon back in AddDoctor and DeleteDoctor Don't work

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (!pageAdmin.isAddButtonTriggered) {
            setContentView(R.layout.activity_delete_doctor);
            setTitle("Delete doctor");
        }
        else {
    //        setContentView(R.layout.get_specialization);
            setContentView(R.layout.activity_add_doctor);
            setTitle("Add doctor");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        helper = new MyDatabaseHelper(this);
        doctorData = new DoctorData(helper);


        init();
        hideNav();

/*    // Icon back

     iconBack = findViewById(R.id.icon_backAddDoctor);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageDoctor.this,PageAdmin.class);
                startActivity(intent);

            }
        });*/
    }

    private void init(){
        rdGroup = (RadioGroup) findViewById(R.id.radio_group);
        rdMale = (RadioButton) findViewById(R.id.radio_male);
        rdFemale = (RadioButton) findViewById(R.id.radio_female);

        firstName = findViewById(R.id.edit_text_first_name);
        middleName = findViewById(R.id.edit_text_middle_name);
        lastName = findViewById(R.id.edit_text_last_name);
        phoneNo = findViewById(R.id.edit_text_phone_number);
        specialization = findViewById(R.id.edit_text_specialization);
        idPersonal = findViewById(R.id.edit_text_id_personal);

        idPersonalDelete = findViewById(R.id.edit_text_id_personal_del);


        specializationE = findViewById(R.id.edit_text_specialization);
    }


    public void addDoctor(View v){
        String radiovalue = ((RadioButton) findViewById(rdGroup.getCheckedRadioButtonId())).getText().toString();

        String firstname = firstName.getText().toString();
        String middlename = middleName.getText().toString();
        String lastname = lastName.getText().toString();
        String specialization_ = specialization.getText().toString();


        int id = Integer.parseInt(idPersonal.getText().toString());
        int phone = Integer.parseInt(phoneNo.getText().toString());
        DoctorModel doctorModel = new DoctorModel(id,phone,firstname,middlename,lastname,specialization_,radiovalue);
       // DoctorModel doctorModel = new DoctorModel(phone,firstname,middlename,lastname,specialization_,radiovalue);

        doctorData.addDoctor(doctorModel);


    }

    public void deleteDoctor(View v){
        int id = Integer.parseInt(idPersonalDelete.getText().toString());
        doctorData.removeDoctorById(id);
        Cursor cursor = doctorData.readAllDataFromDoctor();

        if (cursor.getCount() == 0)
            Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "The doctor has been successfully deleted", Toast.LENGTH_SHORT).show();
        }

    }

    public void getSpecializationDoctor(View v){
        String specialization = specializationE.getText().toString();
        helper = new MyDatabaseHelper(getApplicationContext());
        sqLiteDatabase = helper.getReadableDatabase();
        Cursor cursor =  doctorData.getSpecialization(specialization);
       // Cursor cursor = doctorData.readDoctors();

        if (cursor.getCount() == 0)
            Toast.makeText(this,"No!",Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Yes, There's doctor in section " + specialization, Toast.LENGTH_SHORT).show();
        }
    }

    private void hideNav(){
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
