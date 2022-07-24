package com.example.testloginforuserrole.database.model;

public class ViewRecordModel {

    int id_record, id_doctor;

    public ViewRecordModel(int id_record, int id_doctor) {
        this.id_record = id_record;
        this.id_doctor = id_doctor;
    }

    public int getId_record() {
        return id_record;
    }

    public void setId_record(int id_record) {
        this.id_record = id_record;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }
}
