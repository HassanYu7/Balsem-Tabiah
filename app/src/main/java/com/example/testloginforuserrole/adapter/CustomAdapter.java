package com.example.testloginforuserrole.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testloginforuserrole.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList doctor_id, doctor_firstName, doctor_lastName, doctor_specialization;

    public CustomAdapter(Context context, ArrayList doctor_id, ArrayList doctor_firstName, ArrayList doctor_lastName,
                         ArrayList doctor_specialization){
        this.context = context;
        this.doctor_id = doctor_id;
        this.doctor_firstName = doctor_firstName;
        this.doctor_lastName = doctor_lastName;
        this.doctor_specialization = doctor_specialization;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.doctor_id_text.setText(String.valueOf(doctor_id.get(position)));
        holder.doctor_firstName_text.setText(String.valueOf(doctor_firstName.get(position)));
        holder.doctor_lastName_text.setText(String.valueOf(doctor_lastName.get(position)));
        holder.doctor_specialization_text.setText(String.valueOf(doctor_specialization.get(position)));
    }


    @Override
    public int getItemCount() {
        return doctor_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView doctor_id_text, doctor_firstName_text, doctor_lastName_text,doctor_specialization_text;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            doctor_id_text = itemView.findViewById(R.id.id_doctor);
            doctor_firstName_text = itemView.findViewById(R.id.doctor_firstname);
            doctor_lastName_text = itemView.findViewById(R.id.doctor_lastname);
            doctor_specialization_text = itemView.findViewById(R.id.doctor_Specialization);
            /*mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);*/
        }

    }

}