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

public class AdapterForPrescription extends ArrayAdapter<UserModel> {


    ArrayList<UserModel> userArrayList;

    public AdapterForPrescription(Context context, ArrayList<UserModel> userArrayList){

        super(context, R.layout.view_prescription_model, userArrayList);
        this.userArrayList = userArrayList;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UserModel user = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_prescription_model,parent,false);

        }


        TextView nameDoctor = convertView.findViewById(R.id.doctorName);
        TextView datePrescription = convertView.findViewById(R.id.txtDatePrescription);



        nameDoctor.setText(user.getDrName());
        datePrescription.setText(user.getAppointDate());

        return convertView;
    }
}
