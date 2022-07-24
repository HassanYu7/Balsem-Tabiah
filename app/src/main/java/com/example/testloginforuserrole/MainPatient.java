package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.data.PatientData;
import com.example.testloginforuserrole.database.model.PatientModel;
import com.example.testloginforuserrole.database.table.PatientDB;
import com.example.testloginforuserrole.databinding.ActivityMainPatientBinding;


public class MainPatient extends AppCompatActivity {

    TextView showUserNamePatient, showIdPatient;
    PatientDB patientDB;
    MyDatabaseHelper helper;
    PatientData patientData;
    ActivityMainPatientBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPatientBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        helper = new MyDatabaseHelper(this);
        patientData = new PatientData(helper);

        showUserNamePatient = findViewById(R.id.user_name_patient);
        showIdPatient = findViewById(R.id.user_id_patient);

     //   String userName_patient = showUserNamePatient.getText().toString();

        binding.cardviewAppoitnemnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPatient.this,CategoryDoctor.class));
            }
        });
        binding.cardviewUpcomingAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPatient.this,UpComingAppointment_listView.class));
            }
        });
        binding.cardviewPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPatient.this,ViewPrescription.class));
            }
        });

        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (!isFinishing()){
                            new AlertDialog.Builder(MainPatient.this,R.style.AlertDialogStyle)
                                    .setTitle("ALERT!")
                                    .setMessage("Are you sure you want to logout?")
                                    .setCancelable(false)
                                    .setIcon(R.drawable.ic_alert)
                                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            startActivity(new Intent(MainPatient.this, MainActivity.class));
                                        }
                                    }).show();
                        }
                    }
                });
            }
        });

        /*
        loginIntent.putExtra("phoneNumber", PatientDB.PHONE_NO);
        loginIntent.putExtra("idPatient", PatientDB.ID_PATIENT);
        loginIntent.putExtra("firstName", PatientDB.FIRST_NAME);
        loginIntent.putExtra("middleName", PatientDB.MIDDLE_NAME);
        loginIntent.putExtra("lastName", PatientDB.LAST_NAME);
        */
        String firstName = getIntent().getStringExtra("firstName");
        String middleName = getIntent().getStringExtra("middleName");
        String lastName = getIntent().getStringExtra("lastName");
        PatientModel patientModel = new PatientModel(firstName,middleName,lastName);





        showUserNamePatient.setText(patientData.getUsername());
        showIdPatient.setText(patientData.getIdPatient());


//        String userName_patient = showUserNamePatient.getText().toString();

/*        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get(PatientDB.ID_PATIENT);
            Toast.makeText(this,j,Toast.LENGTH_LONG).show();
        }*/

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



/*    public void showNameAndIdPatient(){

        String userName_patient = showUserNamePatient.getText().toString();
        int idPatient = Integer.parseInt(showIdPatient.getText().toString());

    }*/




}