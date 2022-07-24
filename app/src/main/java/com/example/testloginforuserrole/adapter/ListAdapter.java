package com.example.testloginforuserrole.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.testloginforuserrole.R;
import com.example.testloginforuserrole.database.model.UserModel;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<UserModel> {


    public ListAdapter(Context context, ArrayList<UserModel> userArrayList){

        super(context,R.layout.patient_list,userArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UserModel user = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.patient_list,parent,false);

        }

        //ImageView imageView = convertView.findViewById(R.id.imgProfilePaient);

        TextView namePatient = convertView.findViewById(R.id.patientName);
        TextView txtPaientId = convertView.findViewById(R.id.txtPaientId);
        TextView txtAppoibtDate = convertView.findViewById(R.id.txtDateList);
        TextView txtDrName = convertView.findViewById(R.id.txtDrNameList);

//        TextView phonePatient = convertView.findViewById(R.id.txtPatientPhoneProfile);
//        TextView addressPatient = convertView.findViewById(R.id.txtPatientAddressProfile);
        //TextView time = convertView.findViewById(R.id.msgtime);

        TextView nameDoctorPrescription = convertView.findViewById(R.id.doctorName);
        TextView dateAppoint = convertView.findViewById(R.id.txtDatePrescription);


        //imageView.setImageResource(user.imageId);
        namePatient.setText(user.getNamePatient());
        txtPaientId.setText(String.valueOf(user.getIdPatient()));
        txtAppoibtDate.setText(user.getAppointDate());
        txtDrName.setText(user.getDrName());


        //time.setText(user.lastMsgTime);

//        phonePatient.setText(user.phoneNo);
//        addressPatient.setText(user.address);


        return convertView;
    }
}