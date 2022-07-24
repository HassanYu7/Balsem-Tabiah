package com.example.testloginforuserrole.database.model;

public class CoordinateModel {

    int id_doctor;
    int id_receptionist;
    int id_appointment;

    public CoordinateModel(int id_doctor, int id_receptionist, int id_appointment) {
        this.id_doctor = id_doctor;
        this.id_receptionist = id_receptionist;
        this.id_appointment = id_appointment;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getId_receptionist() {
        return id_receptionist;
    }

    public void setId_receptionist(int id_receptionist) {
        this.id_receptionist = id_receptionist;
    }

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }
}
