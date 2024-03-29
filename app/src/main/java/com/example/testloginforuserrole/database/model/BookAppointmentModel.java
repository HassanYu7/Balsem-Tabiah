package com.example.testloginforuserrole.database.model;

public class BookAppointmentModel {

    int id_patient;
    int id_doctor;
    int id_appointment;


    public BookAppointmentModel(int id_patient, int id_doctor, int id_appointment) {
        this.id_patient = id_patient;
        this.id_doctor = id_doctor;
        this.id_appointment = id_appointment;
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

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }
}
