package com.example.testloginforuserrole.database.model;

public class RecordModel {

    int id_record, id_receptionist;
    String state;

    public RecordModel(int id_record, int id_receptionist, String state) {
        this.id_record = id_record;
        this.id_receptionist = id_receptionist;
        this.state = state;
    }

    public int getId_record() {
        return id_record;
    }

    public void setId_record(int id_record) {
        this.id_record = id_record;
    }

    public int getId_receptionist() {
        return id_receptionist;
    }

    public void setId_receptionist(int id_receptionist) {
        this.id_receptionist = id_receptionist;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
