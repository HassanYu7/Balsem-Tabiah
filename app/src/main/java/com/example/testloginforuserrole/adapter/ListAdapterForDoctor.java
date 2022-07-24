package com.example.testloginforuserrole.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testloginforuserrole.R;
import com.example.testloginforuserrole.database.model.UserModel;

import java.util.ArrayList;

public class ListAdapterForDoctor extends ArrayAdapter<UserModel> {

    ArrayList<UserModel> userArrayList;

    public ListAdapterForDoctor(Context context, ArrayList<UserModel> userArrayList){

        super(context,R.layout.list_patient_for_doctor, userArrayList);
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

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_patient_for_doctor,parent,false);

        }

        //ImageView imageView = convertView.findViewById(R.id.imgProfilePaient);

        TextView namePatient = convertView.findViewById(R.id.patientNameForDoctor);
        TextView txtPaientId = convertView.findViewById(R.id.txtPaientIdForDoctor);
        TextView txtAppoibtDate = convertView.findViewById(R.id.txtDateAppointmentForDoctor);


//        TextView phonePatient = convertView.findViewById(R.id.txtPatientPhoneProfile);
//        TextView addressPatient = convertView.findViewById(R.id.txtPatientAddressProfile);
        //TextView time = convertView.findViewById(R.id.msgtime);

        //imageView.setImageResource(user.imageId);
        namePatient.setText(user.getNamePatient());
        txtPaientId.setText(String.valueOf(user.getIdPatient()));
        txtAppoibtDate.setText(user.getAppointDate());




        return convertView;
    }
}