package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.testloginforuserrole.adapter.AdapterForPrescription;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityUpComingAppointmentListViewBinding;

import java.util.ArrayList;

public class UpComingAppointment_listView extends AppCompatActivity {

    ActivityUpComingAppointmentListViewBinding binding;
    MyDatabaseHelper db;
    ArrayList<UserModel> arrayList;
    AdapterForPrescription listAdapter;
    DoctorData doctorData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_coming_appointment_list_view);

        binding = ActivityUpComingAppointmentListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabaseHelper(this);
        doctorData = new DoctorData(db);

        arrayList = doctorData.getNameDoctorListUpComing();
        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpComingAppointment_listView.this,MainPatient.class));
            }
        });


        listAdapter = new AdapterForPrescription(this, arrayList);
        binding.lstViewUpcomingAppointment.setAdapter(listAdapter);

        binding.lstViewUpcomingAppointment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(UpComingAppointment_listView.this, UpComingAppointment_info.class);

                i.putExtra("idPatient", arrayList.get(position).getIdPatient());
                i.putExtra("namePatient", arrayList.get(position).getNamePatient());
                i.putExtra("id", arrayList.get(position).getIdAppointment());
                i.putExtra("DrName", arrayList.get(position).getDrName());
                i.putExtra("Splization", arrayList.get(position).getSplization());
                i.putExtra("AppointDate", arrayList.get(position).getAppointDate());
                //i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

        hideNav();

    }

    public void hideNav(){
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