package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.AppointmentData;
import com.example.testloginforuserrole.database.data.BookAppointmentData;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.AppointmentModel;
import com.example.testloginforuserrole.databinding.ActivityBookForPatientFromReceptionistBinding;

import java.util.ArrayList;

public class Activity_Appointment extends AppCompatActivity {

    Spinner spinnerAvailableAppointmentsForDoctor;
    EditText searchByDoctorIdForBook,searchByPatientIdForBook;
    Button btnBookAppointment, btnSearchDoctor;

    ArrayList<AppointmentModel> arrayListTime;

    DoctorData doctorData;
    AppointmentData appointmentData;
    BookAppointmentData bookAppointmentData;
    MyDatabaseHelper helper;
    ActivityBookForPatientFromReceptionistBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookForPatientFromReceptionistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Appointment.this, ActivityReceptionist.class));
            }
        });

        helper = new MyDatabaseHelper(this);
        appointmentData = new AppointmentData(helper);
        doctorData = new DoctorData(helper);
        bookAppointmentData = new BookAppointmentData(helper);


        searchByDoctorIdForBook = findViewById(R.id.edit_text_search_doctor_id_for_book);
        searchByPatientIdForBook = findViewById(R.id.edit_text_search_patient_id_for_book);
        spinnerAvailableAppointmentsForDoctor = findViewById(R.id.spinner_date_time_for_doctor);

        searchByDoctorIdForBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<AppointmentModel> adapterDateTime = new ArrayAdapter<>(
                        getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, readDate());
                spinnerAvailableAppointmentsForDoctor.setAdapter(adapterDateTime);
            }
        });


        spinnerAvailableAppointmentsForDoctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.btnBookAppointmentForPatientFromReceptionist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointmentData.insertBookAppointment(searchByPatientIdForBook.getText().toString(),
                        spinnerAvailableAppointmentsForDoctor.getSelectedItem().toString(),
                        searchByDoctorIdForBook.getText().toString());
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


    public ArrayList<AppointmentModel> readDate(){
        arrayListTime = appointmentData.readAppointmentsByDrName(searchByDoctorIdForBook.getText().toString());
        arrayListTime.toString();
        return arrayListTime;
    }
}