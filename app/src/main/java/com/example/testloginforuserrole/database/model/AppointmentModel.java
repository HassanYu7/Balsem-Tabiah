package com.example.testloginforuserrole.database.model;

import java.util.Date;

public class AppointmentModel {

    int id_appointment,foreign_id_doctor;
    String date_time;


    public AppointmentModel(int id_appointment, String date_time) {
        this.id_appointment = id_appointment;
        this.date_time = date_time;
    }

    public AppointmentModel(int foreign_id_doctor) {
        this.foreign_id_doctor = foreign_id_doctor;
    }


    //    public AppointmentModel(int id_appointment) {
//        this.id_appointment = id_appointment;
//    }


    public AppointmentModel(String date_time) {
        this.date_time = date_time;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return date_time;
    }

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }

    public int getForeign_id_doctor() {
        return foreign_id_doctor;
    }

    public void setForeign_id_doctor(int foreign_id_doctor) {
        this.foreign_id_doctor = foreign_id_doctor;
    }

}
