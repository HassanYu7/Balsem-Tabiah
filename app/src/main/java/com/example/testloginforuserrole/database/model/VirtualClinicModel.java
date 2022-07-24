package com.example.testloginforuserrole.database.model;

public class VirtualClinicModel {

    int id_patient, id_doctor, hour;

    public VirtualClinicModel(int id_patient, int id_doctor, int hour) {
        this.id_patient = id_patient;
        this.id_doctor = id_doctor;
        this.hour = hour;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
