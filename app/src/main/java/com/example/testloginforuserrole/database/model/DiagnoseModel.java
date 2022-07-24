package com.example.testloginforuserrole.database.model;

public class DiagnoseModel {

    int id_patient,id_doctor;
    String result, Prescription;

    public DiagnoseModel(int id_patient, int id_doctor, String result, String prescription) {
        this.id_patient = id_patient;
        this.id_doctor = id_doctor;
        this.result = result;
        Prescription = prescription;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPrescription() {
        return Prescription;
    }

    public void setPrescription(String prescription) {
        Prescription = prescription;
    }
}
