package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.AppointmentData;
import com.example.testloginforuserrole.database.data.BookAppointmentData;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.AppointmentModel;
import com.example.testloginforuserrole.databinding.ActivityEditDateForDoctorBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class EditDateForDoctor extends AppCompatActivity {

    EditText txtDrNameForEditDate,txtSelectDateForEdit;

    Button btnSearchDoctorForEdit, btnChangeDate, btnDeleteDate;

    Spinner spinner_date;

    MyDatabaseHelper db;

    ArrayAdapter<AppointmentModel> adapterDate;

    ArrayList<AppointmentModel> arrayList;
    DoctorData doctorData;
    BookAppointmentData bookAppointmentData;
    AppointmentData appointmentData;

    ActivityEditDateForDoctorBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditDateForDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabaseHelper(this);
        doctorData = new DoctorData(db);
        bookAppointmentData = new BookAppointmentData(db);
        appointmentData = new AppointmentData(db);

        txtDrNameForEditDate = (EditText) findViewById(R.id.txtDoctorNameForEditDate);
        txtSelectDateForEdit = (EditText) findViewById(R.id.txtSelectDateForEdit);

        btnSearchDoctorForEdit = (Button) findViewById(R.id.btnSearchDoctorForEdit);
        btnChangeDate = (Button) findViewById(R.id.btnChangeDate);
        btnDeleteDate = (Button) findViewById(R.id.btnDeleteDate);

        spinner_date = findViewById(R.id.spinner_date);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);

        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);






        btnSearchDoctorForEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapterDate = new ArrayAdapter<>(
                        EditDateForDoctor.this, android.R.layout.simple_spinner_dropdown_item, readDate());

                spinner_date.setAdapter(adapterDate);
            }
        });

        txtSelectDateForEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditDateForDoctor.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                        month1 = month1 + 1;
                        txtSelectDateForEdit.setText(year1 + "/" + month1 + "/" + dayOfMonth);
                    }
                }, year, month, day);
                datePickerDialog.setTitle("Select Date");
                datePickerDialog.show();
            }
        });

        spinner_date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        btnChangeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = spinner_date.getSelectedItemPosition();
                if (pos>-1) {
                    bookAppointmentData.updateDataForDoctor(txtSelectDateForEdit.getText().toString(),
                            spinner_date.getSelectedItem().toString());
                    Toast.makeText(EditDateForDoctor.this, "date has been Changed" + "", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EditDateForDoctor.this, "No change" + "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDeleteDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = spinner_date.getSelectedItemPosition();
                if (pos>-1) {
                    bookAppointmentData.deleteDateForDoctor(spinner_date.getSelectedItem().toString());
                    Toast.makeText(EditDateForDoctor.this, "date has been deleted" + "", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EditDateForDoctor.this, "No change" + "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditDateForDoctor.this,ActivityReceptionist.class));
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
        arrayList = appointmentData.readAppointmentsByDrName(txtDrNameForEditDate.getText().toString());
        arrayList.toString();
        return arrayList;
    }

}