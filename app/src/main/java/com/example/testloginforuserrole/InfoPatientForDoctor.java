package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testloginforuserrole.adapter.ListAdapterForDoctor;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DiagnoseData;
import com.example.testloginforuserrole.database.data.PatientData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityInfoPatientForDoctorBinding;

import java.util.ArrayList;

public class InfoPatientForDoctor extends AppCompatActivity {

    ActivityInfoPatientForDoctorBinding binding;

    MyDatabaseHelper db;
    ListAdapterForDoctor listAdapterForDoctor;
    ArrayList<UserModel> arrayList;
    PatientData patientData;
    DiagnoseData diagnoseData;


    //int imageid = intent.getIntExtra("imageid",R.drawable.a);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInfoPatientForDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabaseHelper(this);
        patientData = new PatientData(db);
        diagnoseData = new DiagnoseData(db);


        arrayList = patientData.getNamePatientList();


        listAdapterForDoctor = new ListAdapterForDoctor(this, arrayList);

//        String a = userArrayList.get(position).getNamePatient();
//        String b = userArrayList.get(position).getDrName();
//        String c = userArrayList.get(position).getAppointDate();
//
//        Toast.makeText(getContext(), a + " " + b + " " + c, Toast.LENGTH_LONG).show();



        //String a = arrayList.get(position).getNamePatient();



        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoPatientForDoctor.this,ApppintmentDoctor.class));
            }
        });



        Intent intent = this.getIntent();

        if (intent != null){

            int id = intent.getIntExtra("id",4);
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String Address = intent.getStringExtra("Address");
            //String btnPrescription = intent.getStringExtra("Prescription");
            String appointDate = intent.getStringExtra("date");
            //int imageid = intent.getIntExtra("imageid",R.drawable.a);


            //set info in listView
            binding.txtPatientIdProfileDr.setText(String.valueOf(id));
            binding.txtPatientNameProfileDr.setText(name);
            binding.txtPatientPhoneProfileDr.setText(phone);
            binding.txtPatientAddressProfileDr.setText(Address);

            binding.btnWritePrescription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(InfoPatientForDoctor.this);
                    dialog.setContentView(R.layout.custom_dialog_prescription);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    Button submit = (Button) dialog.findViewById(R.id.btnSubmit);
                    Button cancel = (Button) dialog.findViewById(R.id.btnCancel);
                    EditText multiTextDescription =(EditText) dialog.findViewById(R.id.multiTextTreatment);



                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            EditText multiTextDiagnose = (EditText) dialog.findViewById(R.id.multiTextDiagnose);
                            EditText multiTextTreatment = (EditText) dialog.findViewById(R.id.multiTextTreatment);
//                        db.insertDiagnose(name, name, appointDate,
//                                multiTextDiagnose.getText().toString(), multiTextTreatment.getText().toString());

                            diagnoseData.insertDiagnose(name, "hassan", appointDate,
                                    multiTextDiagnose.getText().toString(),
                                    multiTextTreatment.getText().toString());


                        }
                    });

                    dialog.show();

//                    db.insertDiagnose(patientName, doctorName, date, diagnose, treatment);


                }
            });

            // binding.profileImage.setImageResource(imageid);

        }



        // get info from listView
//        String txtPatientName = binding.txtPatientNameProfileDr.getText().toString();
//        Toast.makeText(InfoPatientForDoctor.this, txtPatientName+"", Toast.LENGTH_SHORT).show();
//

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