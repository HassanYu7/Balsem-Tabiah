package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.testloginforuserrole.adapter.CustomAdapter;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.DoctorModel;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {

    MyDatabaseHelper helper;
    DoctorData doctorData;
    CategoryDoctor categoryDoctor;
    ArrayList<String> dr_id, dr_first_name, dr_last_name, dr_specialization;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

      //  doctorData = new DoctorData(helper);


        getRecycler();

/*        if (categoryDoctor.isDentalButtonTriggered)
            userList = doctorData.getDoctorBySpecialization("dental");
        else
            userList = doctorData.getDoctorBySpecialization("general");

        ListView lv = (ListView) findViewById(R.id.user_list);

        ListAdapter adapter = new SimpleAdapter(DetailsActivity.this, userList, R.layout.list_row,
                new String[]{"id_doctor","first_name","last_name","specialization"}, new int[]
                {R.id.id_doctor, R.id.doctor_firstname, R.id.doctor_lastname, R.id.doctor_Specialization});

        lv.setAdapter(adapter);*/

    }

    void storeDataInArrays(){
        doctorData = new DoctorData(helper);
        helper = new MyDatabaseHelper(getApplicationContext());

        Cursor cursor;

        if (categoryDoctor.category.equalsIgnoreCase("dental"))
            cursor = doctorData.getSpecialization("dental");
        else if (categoryDoctor.category.equalsIgnoreCase("general"))
            cursor = doctorData.getSpecialization("general");
        else if (categoryDoctor.category.equalsIgnoreCase("heart"))
            cursor = doctorData.getSpecialization("heart");
        else
            cursor = doctorData.getSpecialization("neurologist");


//        if (categoryDoctor.isDentalButtonTriggered)
//            cursor = doctorData.getSpecialization("dental");
//        else
//            cursor = doctorData.getSpecialization("general");

        if (cursor.getCount() == 0){
            Toast.makeText(this,"No data from doctor.",Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                dr_id.add(cursor.getString(0));
                dr_first_name.add(cursor.getString(1)); // Middle
                dr_last_name.add(cursor.getString(2)); //
                dr_specialization.add(cursor.getString(3)); //
            }
        }

    }

    void getRecycler(){
        recyclerView = findViewById(R.id.recyclerView);

        helper = new MyDatabaseHelper(this);

        dr_id = new ArrayList<>();
        dr_first_name = new ArrayList<>();
        dr_last_name = new ArrayList<>();
        dr_specialization = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(this,dr_id,dr_first_name,dr_last_name,dr_specialization);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DetailsActivity.this));
    }

//    public void getSpecializationDoctoar(){
//        helper = new MyDatabaseHelper(getApplicationContext());
//        sqLiteDatabase = helper.getReadableDatabase();
//        Cursor cursor =  doctorData.getSpecialization("dental");
//        // Cursor cursor = doctorData.readDoctors();
//
//        if (cursor.getCount() == 0)
//            Toast.makeText(this,"No!",Toast.LENGTH_SHORT).show();
//        else {
//            Toast.makeText(this, "Yes, There's doctor in section " , Toast.LENGTH_SHORT).show();
//        }
//    }
}