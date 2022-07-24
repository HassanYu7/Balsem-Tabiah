package com.example.testloginforuserrole;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Criteria;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.AppointmentData;
import com.example.testloginforuserrole.database.data.CoordinateData;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.AppointmentModel;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.databinding.ActivityCoordinateAppointmentDoctorBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CoordinateAppointmentDoctor extends AppCompatActivity {

    EditText txtDate, txtTime;
    Button btnAdd;

    AppointmentData appointmentData;
    DoctorData doctorData;
    CoordinateData coordinateData;
    MyDatabaseHelper helper;

    Spinner spinnerDoctor, spinnerSpecialization;


    ArrayAdapter<String> adapterSpeclaztion;
    ArrayList<AppointmentModel> arrayList; // <AppointmentModel>

    ActivityCoordinateAppointmentDoctorBinding binding;

    // @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCoordinateAppointmentDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoordinateAppointmentDoctor.this, ActivityReceptionist.class));
            }
        });

        final Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        helper = new MyDatabaseHelper(this);

        appointmentData = new AppointmentData(helper);
        coordinateData = new CoordinateData(helper);
        doctorData = new DoctorData(helper);
       // coordinateData = new CoordinateData(helper);


        init();
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(CoordinateAppointmentDoctor.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                        month1 = month1 + 1;
                        txtDate.setText(year1 + "/" + month1 + "/" + dayOfMonth);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(CoordinateAppointmentDoctor.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (minute < 10) {
                            txtTime.setText(hourOfDay + ":0" + minute);
                        } else {
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }

        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  //  helper = new MyDatabaseHelper(CoordinateAppointmentDoctor.this);

                    String dateTime = txtDate.getText().toString() + " " + txtTime.getText().toString();

              //  AppointmentModel appointmentModel = new AppointmentModel(dateTime);
            //    appointmentData.insertDateTime(appointmentModel);

//                AppointmentModel appointmentModel = new AppointmentModel(dateTime);
//                DoctorModel doctorModel = new DoctorModel(spinnerDoctor.getSelectedItem().toString());

                appointmentData.insertDate(dateTime);
              //  coordinateData.insertCoordinate(appointmentModel,doctorModel);
                coordinateData.insertCoordinate(dateTime,spinnerDoctor.getSelectedItem().toString());

          //      startActivity(new Intent(CoordinateAppointmentDoctor.this,ActivityReceptionist.class));
//                appointmentData.insertDateandTime(text_date + " " + text_time);
//                AppointmentModel appointmentModel = new AppointmentModel(text_date, text_time);
//                appointmentData.insertDateAndTimeByCallingObject(appointmentModel);



            }
        });


        // TODO: These items are case sensitive
        ArrayList<String> items = new ArrayList<>();items.add("Dental");items.add("General");items.add("Heart");items.add("neurologist");


        adapterSpeclaztion = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items);
        spinnerSpecialization.setAdapter(adapterSpeclaztion);
        spinnerSpecialization.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<AppointmentModel> adapterDoctor = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, readDoctor());
                spinnerDoctor.setAdapter(adapterDoctor);
             //   ((TextView)parent.getChildAt(0)).setTextColor(Color.parseColor("#FFFFFF"));



//                String s = spinnerSpecialization.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(),"Specialization: " + s + "\n",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       spinnerDoctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//               String s = spinnerDoctor.getSelectedItem().toString();
//               Toast.makeText(getApplicationContext(), s ,Toast.LENGTH_LONG).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

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


    private void init() {
        txtDate = (EditText) findViewById(R.id.txtDate);
        txtTime = (EditText) findViewById(R.id.txtTime);
        btnAdd = (Button) findViewById(R.id.btnAddCoordinate);
        spinnerSpecialization = (Spinner) findViewById(R.id.spinner_Specialization);
        spinnerDoctor = (Spinner) findViewById(R.id.spinner_doctor);
    }

    public ArrayList<AppointmentModel> readDoctor() {
         arrayList = doctorData.readDoctors(spinnerSpecialization.getSelectedItem().toString());
        return arrayList;
    }






}
