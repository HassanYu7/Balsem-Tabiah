package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.testloginforuserrole.adapter.AdapterForPrescription;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DiagnoseData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityViewPrescriptionBinding;

import java.util.ArrayList;

public class ViewPrescription extends AppCompatActivity {

    ActivityViewPrescriptionBinding binding;
    MyDatabaseHelper db;
    ArrayList<UserModel> arrayList;
    AdapterForPrescription listAdapter;
    DiagnoseData diagnoseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewPrescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabaseHelper(this);
        diagnoseData = new DiagnoseData(db);

        arrayList = diagnoseData.getInfoPrescription();



        listAdapter = new AdapterForPrescription(this, arrayList);
        binding.lstViewPrescription.setAdapter(listAdapter);

        binding.lstViewPrescription.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ViewPrescription.this, Prescription.class);

                i.putExtra("name", arrayList.get(position).getNamePatient());
                i.putExtra("Gender", arrayList.get(position).getGender());
                i.putExtra("DateOfBirth", arrayList.get(position).getDateOfBirth());
                i.putExtra("Prescription", arrayList.get(position).getPrescription());
                i.putExtra("DrName",arrayList.get(position).getDrName());
                i.putExtra("Splization",arrayList.get(position).getSplization());
                i.putExtra("AppointDate",arrayList.get(position).getAppointDate());
                //i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });




    }
}