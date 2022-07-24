package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.BookAppointmentData;
import com.example.testloginforuserrole.database.data.CoordinateData;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityInfoPatientBinding;

import java.util.ArrayList;

public class InfoPatient extends AppCompatActivity {

    ActivityInfoPatientBinding binding;

    MyDatabaseHelper db;

    ArrayList<UserModel> arrayListDrName;
    DoctorData doctorData;
    BookAppointmentData bookAppointmentData;
    CoordinateData coordinateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInfoPatientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabaseHelper(this);
        doctorData = new DoctorData(db);

        arrayListDrName = new ArrayList<>();
        arrayListDrName = doctorData.getDoctorsNames();

        bookAppointmentData = new BookAppointmentData(db);
        coordinateData = new CoordinateData(db);

        Intent intent = this.getIntent();


        if (intent != null){

            int id = intent.getIntExtra("id",3);
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String Address = intent.getStringExtra("Address");
            int idApp = intent.getIntExtra("idApp",4);
            String dateDate = intent.getStringExtra("dateApp");
            String drName = intent.getStringExtra("drName");
            //int imageid = intent.getIntExtra("imageid",R.drawable.a);

            binding.txtPatientIdProfileResiptionist.setText(String.valueOf(id));
            binding.txtPatientNameProfileResiptionist.setText(name);
            binding.txtPatientPhoneProfileResiptionist.setText(phone);
            binding.txtPatientAddressProfileResiptionist.setText(Address);
            // binding.profileImage.setImageResource(imageid);

            binding.btnDeleteAppointmentResptinest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bookAppointmentData.deleteUpComingAppointment(dateDate,
                            binding.txtPatientIdProfileResiptionist.getText().toString());
                    coordinateData.insertCoordinate(dateDate, drName);

                    Intent intent1 = new Intent(InfoPatient.this, MainActivity.class);
                    startActivity(intent1);

                }
            });
        }

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