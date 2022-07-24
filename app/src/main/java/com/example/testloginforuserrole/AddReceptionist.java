package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.ReceptionistModel;
import com.example.testloginforuserrole.database.data.ReceptionistData;

public class AddReceptionist extends AppCompatActivity {

    EditText firstName,middleName,lastName,phoneNo,dateBirth,idPersonal;
    MyDatabaseHelper helper;
    ReceptionistData receptionistData;
    RadioButton rdMale,rdFemale,radioButton;
    RadioGroup rdGroup;
    SQLiteDatabase db;
    String gender="";
    ImageView iconBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receptionist);

        helper = new MyDatabaseHelper(this);
        receptionistData = new ReceptionistData(helper);

        iconBack = findViewById(R.id.icon_backAddReceptionist);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddReceptionist.this,PageAdmin.class));
            }
        });

        rdGroup = (RadioGroup) findViewById(R.id.radio_group_receptionist);
        rdMale = (RadioButton) findViewById(R.id.radio_male_receptionist);
        rdFemale = (RadioButton) findViewById(R.id.radio_female_receptionist);

        hideNav();
    }

    public void btn_add_onclick_receptionist(View v){

        firstName = findViewById(R.id.edit_text_first_name_receptionist);
        middleName = findViewById(R.id.edit_text_middle_name_receptionist);
        lastName = findViewById(R.id.edit_text_last_name_receptionist);
        phoneNo = findViewById(R.id.edit_text_phone_number_receptionist);
       // dateBirth = findViewById(R.id.edit_text_date_birth);
        idPersonal = findViewById(R.id.edit_text_d_personal_receptionist);

        try {

            String radiovalue = ((RadioButton) this.findViewById(rdGroup.getCheckedRadioButtonId())).getText().toString();


            String firstname = firstName.getText().toString();
            String middlename = middleName.getText().toString();
            String lastname = lastName.getText().toString();
            //   String dateBirth_ = dateBirth.getText().toString();

            int id = Integer.parseInt(idPersonal.getText().toString());
            int phone = Integer.parseInt(phoneNo.getText().toString());

            ReceptionistModel receptionistModel = new ReceptionistModel(id, phone, firstname, middlename, lastname, radiovalue);

            receptionistData.addReceptionist(receptionistModel);
        } catch (Exception e){
            System.out.println(e.getMessage());
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