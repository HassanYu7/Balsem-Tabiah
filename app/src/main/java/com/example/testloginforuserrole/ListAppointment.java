package com.example.testloginforuserrole;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testloginforuserrole.adapter.ListAdapter;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.PatientData;
import com.example.testloginforuserrole.database.data.ReceptionistData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityListAppointmentBinding;

import java.util.ArrayList;

public class ListAppointment extends AppCompatActivity {

    ActivityListAppointmentBinding binding;

    MyDatabaseHelper db;

    ArrayList<UserModel> arrayListPatientName;

    ListAdapter listAdapterNamePatient;

    PatientData patientData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListAppointmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabaseHelper(this);
        patientData = new PatientData(db);

        arrayListPatientName = patientData.getNamePatientList();


        listAdapterNamePatient = new ListAdapter(ListAppointment.this, arrayListPatientName);
        binding.lstView.setAdapter(listAdapterNamePatient);

//        binding.searchViewAppointment.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                ListAppointment.this.listAdapterNamePatient.getFilter().filter(newText);
//                ListAppointment.this.listAdapterNamePatient.getFilter().filter(newText);
//                ListAppointment.this.listAdapterNamePatient.getFilter().filter(newText);
//                ListAppointment.this.listAdapterNamePatient.getFilter().filter(newText);
//
//                return true;
//            }
//        });
        binding.searchViewAppointment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ListAppointment.this.listAdapterNamePatient.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        binding.lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ListAppointment.this, InfoPatient.class);

                i.putExtra("id", arrayListPatientName.get(position).getIdPatient());
                i.putExtra("name", arrayListPatientName.get(position).getNamePatient());
                i.putExtra("drName",arrayListPatientName.get(position).getDrName());
                i.putExtra("phone", arrayListPatientName.get(position).getPhoneNo());
                i.putExtra("Address", arrayListPatientName.get(position).getAddress());
                i.putExtra("idApp", arrayListPatientName.get(position).getIdAppointment());
                i.putExtra("dateApp", arrayListPatientName.get(position).getAppointDate());
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
