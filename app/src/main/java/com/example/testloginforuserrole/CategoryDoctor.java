package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.databinding.ActivityCategoryDoctorBinding;
import com.example.testloginforuserrole.databinding.ActivityListAppointmentBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryDoctor extends AppCompatActivity {

    Intent intent;
    MyDatabaseHelper helper;
    DoctorData doctorData;
    SQLiteDatabase sqLiteDatabase;
    Button btnDental,btnGeneral,btnHeart,btnNeurologist;
    ActivityCategoryDoctorBinding binding;

    public static boolean isDentalButtonTriggered = false;
    public static String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCategoryDoctorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardViewCardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "heart";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        binding.cardViewGeneralPractitioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "general";
                isDentalButtonTriggered = false;
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        binding.cardViewNeurosurgery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "neurologist";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        binding.cardViewOphthalmologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "ophthalmologist";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        binding.cardViewOtolaryngology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "otolaryngology";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        binding.cardViewOrthopedicPhysiciant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "orthopedic physician";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryDoctor.this,MainPatient.class));
            }
        });



        /*btnDental = findViewById(R.id.btnDental);
        btnDental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDentalButtonTriggered = true;
                category = "dental";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });
        btnGeneral = findViewById(R.id.btnGeneral);
        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "general";
                isDentalButtonTriggered = false;
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        btnHeart = findViewById(R.id.btnHeart);
        btnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "heart";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        btnNeurologist = findViewById(R.id.btnNeurologist);
        btnNeurologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "neurologist";
                Intent intent = new Intent(CategoryDoctor.this,DetailsActivity.class);
                startActivity(intent);
            }
        });*/

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


    public void onClickDental(View view) {
//        setContentView(R.layout.activity_details);
//        ArrayList<HashMap<String, String>> userList = doctorData.getDoctorBySpecialization("dental");
//        ListView lv = (ListView) findViewById(R.id.user_list);
//
//        ListAdapter adapter = new SimpleAdapter(DetailsActivity, userList, R.layout.list_row,
//                new String[]{"id_doctor","first_name","last_name","specialization"}, new int[]
//                {R.id.id_doctor, R.id.doctor_firstname, R.id.last_name, R.id.doctor_Specialization});
//
//        lv.setAdapter(adapter);
    }

/*   public void getSpecializationDoctor(View v){
        helper = new MyDatabaseHelper(getApplicationContext());
        sqLiteDatabase = helper.getReadableDatabase();
        Cursor cursor =  doctorData.getSpecialization(specialization);
        // Cursor cursor = doctorData.readDoctors();

        if (cursor.getCount() == 0)
            Toast.makeText(this,"No!",Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Yes, There's doctor in section " + specialization, Toast.LENGTH_SHORT).show();
        }
    }*/
}