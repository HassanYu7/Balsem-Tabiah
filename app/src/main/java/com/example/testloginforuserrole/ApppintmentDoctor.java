package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.testloginforuserrole.adapter.ListAdapterForDoctor;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityApppintmentDoctorBinding;

import java.util.ArrayList;

public class ApppintmentDoctor extends AppCompatActivity {

    ActivityApppintmentDoctorBinding binding;

    MyDatabaseHelper db;

    ArrayList<UserModel> arrayListPatientName;
    ListAdapterForDoctor listAdapterNamePatient;
    DoctorData doctorData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityApppintmentDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        db = new MyDatabaseHelper(this);
        doctorData = new DoctorData(db);

        arrayListPatientName = doctorData.getNamePatientListForDoctor();

        binding.iconBackDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ApppintmentDoctor.this, ActivityDoctor.class));
            }
        });


        listAdapterNamePatient = new ListAdapterForDoctor(ApppintmentDoctor.this, arrayListPatientName);
        binding.lstView2.setAdapter(listAdapterNamePatient);

//
//         searchViewAppointment.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                ApppintmentDoctor.this.listAdapterNamePatient.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


        binding.lstView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ApppintmentDoctor.this, InfoPatientForDoctor.class);

                i.putExtra("id", arrayListPatientName.get(position).getIdPatient());
                i.putExtra("name", arrayListPatientName.get(position).getNamePatient());
                // i.putExtra("name",arrayListPatientName.get(position).getDrName());
                i.putExtra("phone", arrayListPatientName.get(position).getPhoneNo());
                i.putExtra("Address", arrayListPatientName.get(position).getAddress());
                i.putExtra("date", arrayListPatientName.get(position).getAppointDate());
                //i.putExtra("imageid",imageId[position]);
                startActivity(i);

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