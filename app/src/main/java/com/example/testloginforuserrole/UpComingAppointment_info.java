package com.example.testloginforuserrole;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.AppointmentData;
import com.example.testloginforuserrole.database.data.BookAppointmentData;
import com.example.testloginforuserrole.database.data.CoordinateData;
import com.example.testloginforuserrole.database.data.DiagnoseData;
import com.example.testloginforuserrole.database.data.DoctorData;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.databinding.ActivityUpComingAppointmentInfoBinding;

import java.util.ArrayList;

public class UpComingAppointment_info extends AppCompatActivity {

    ActivityUpComingAppointmentInfoBinding binding;

    MyDatabaseHelper db;
    ArrayList<UserModel> arrayListDrName;
    ArrayList<UserModel> arrayListDAteDrName;
    Dialog dialog;
    DoctorData doctorData;
    AppointmentData appointmentData;
    CoordinateData coordinateData;
    BookAppointmentData bookAppointmentData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpComingAppointmentInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new MyDatabaseHelper(this);
        doctorData = new DoctorData(db);
        appointmentData = new AppointmentData(db);
        coordinateData = new CoordinateData(db);
        bookAppointmentData = new BookAppointmentData(db);

        arrayListDrName = new ArrayList<>();
        arrayListDrName = doctorData.getDoctorsNames();
        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpComingAppointment_info.this,UpComingAppointment_listView.class));
            }
        });


        Intent intent = this.getIntent();

        if (intent != null) {

            int idPatient = intent.getIntExtra("idPatient",1);
            String namePatient = intent.getStringExtra("namePatient");
            int idAppoint = intent.getIntExtra("id",2);
            String drName = intent.getStringExtra("DrName");
            String appointDate = intent.getStringExtra("AppointDate");
            //int imageid = intent.getIntExtra("imageid",R.drawable.a);

            //Toast.makeText(this, idPatient+ "", Toast.LENGTH_SHORT).show();
            binding.txtViewIdPatientUpComingUpAppointment.setText(String.valueOf(idPatient));
            binding.txtViewNamePatientUpComingUpAppointment.setText(namePatient);
            binding.txtViewIdUpComingUpAppointment.setText(String.valueOf(idAppoint));
            binding.txtViewDoctorsUpComing.setText(drName);
            binding.txtViewDatesUpComing.setText(appointDate);

            //arrayListDAteDrName = new ArrayList<>();






/*            binding.btnSelectDoctor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    dialog = new Dialog(UpComingAppointment_info.this);
                    dialog.setContentView(R.layout.dialog_search_spinner);



                    dialog.getWindow().setLayout(1000, 1500);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();




                    EditText edtText = dialog.findViewById(R.id.edit_text);
                    ListView listView = dialog.findViewById(R.id.lstViewSearchDialog);

                    LstiV  arrayAdapter = new LstiV(UpComingAppointment_info.this, arrayListDrName);
                    listView.setAdapter(arrayAdapter);






                    // listView.setAdapter(new LstiV(UpComingAppointment_info.this, arrayList));




                    edtText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                            arrayAdapter.getFilter().filter(s);


                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });


                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            //binding.txtViewIdUpComingUpAppointment.setText(arrayAdapter.getItem(position).getIdAppointment());
                            binding.txtViewDoctorsUpComing.setText(arrayAdapter.getItem(position).getDrName());
                            //inding.txtViewDatesUpComing.setText(arrayAdapter.getItem(position).getAppointDate());
                            dialog.dismiss();

                        }
                    });

                }
            });
            binding.btnSelectDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    arrayListDAteDrName = appointmentData.getDateByDrName(binding.txtViewDoctorsUpComing.getText().toString());


                    dialog = new Dialog(UpComingAppointment_info.this);
                    dialog.setContentView(R.layout.dialog_search_spinner);



                    dialog.getWindow().setLayout(1000, 1500);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();


                    EditText edtText = dialog.findViewById(R.id.edit_text);
                    ListView listView = dialog.findViewById(R.id.lstViewSearchDialog);


                    ArrayAdapter<UserModel> arrayAdapter = new ArrayAdapter<>(UpComingAppointment_info.this
                            , android.R.layout.simple_list_item_1,arrayListDAteDrName);

                    listView.setAdapter(arrayAdapter);


                    edtText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                            arrayAdapter.getFilter().filter(s);


                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });


                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            // TODO: 9/1/2021  : problem:  should use getAppointmentDate instead getDrName
                            binding.txtViewDatesUpComing.setText(arrayAdapter.getItem(position).getDrName());
                            dialog.dismiss();

                        }
                    });

                }
            });*/

            binding.btnChangeAnAppointment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appointmentData.updateData(binding.txtViewDoctorsUpComing.getText().toString(),
                            binding.txtViewDatesUpComing.getText().toString(),
                            binding.txtViewNamePatientUpComingUpAppointment.getText().toString());

                    appointmentData.deleteOneRow(binding.txtViewDatesUpComing.getText().toString());
                    coordinateData.insertCoordinate(appointDate, drName);

                    Intent intent1 = new Intent(UpComingAppointment_info.this, MainActivity.class);
                    startActivity(intent1);


                }
            });

            binding.btnDeleteAnAppointment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bookAppointmentData.deleteUpComingAppointment(appointDate,
                            binding.txtViewIdPatientUpComingUpAppointment.getText().toString());
                    coordinateData.insertCoordinate(appointDate, drName);

                    Intent intent1 = new Intent(UpComingAppointment_info.this, MainActivity.class);
                    startActivity(intent1);

//                    Toast.makeText(UpComingAppointment_info.this, "Date:"+appointDate, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(UpComingAppointment_info.this, "Dr:"+drName, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(UpComingAppointment_info.this,"id:"+ binding.txtViewIdPatientUpComingUpAppointment.getText().toString(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(UpComingAppointment_info.this,"id:"+ binding.txtViewNamePatientUpComingUpAppointment.getText().toString(), Toast.LENGTH_SHORT).show();

                }
            });
        }

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

    public class LstiV extends ArrayAdapter<UserModel> {

        ArrayList<UserModel> userArrayList;

        public LstiV(Context context, ArrayList<UserModel> userArrayList){

            super(context,R.layout.list_view_show_doctors_spiectlaztion, userArrayList);
            this.userArrayList = userArrayList;

        }

        @Nullable
        @Override
        public UserModel getItem(int position) {
            return userArrayList.get(position);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            UserModel user = getItem(position);

            if (convertView == null){

                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_show_doctors_spiectlaztion,null,false);

            }

            TextView drName = convertView.findViewById(R.id.txtDoctorNameUpcoming);
            TextView drSpecilaztion = convertView.findViewById(R.id.txtSpecialzationUpComing);

            drName.setText(user.getDrName());
            drSpecilaztion.setText(user.getSplization());


            return convertView;
        }
    }
}