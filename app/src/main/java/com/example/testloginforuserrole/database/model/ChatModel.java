package com.example.testloginforuserrole.database.model;

public class ChatModel {
    /*

    public final static String ID_PATIENT = "id_patient";
    public final static String ID_DOCTOR = "id_doctor";
    public final static String CHAT_DESCRIPTION = "chat_description";
     */

    int id_patient;
    int id_doctor;
    String chat_description;

    public ChatModel(int id_patient, int id_doctor, String chat_description) {
        this.id_patient = id_patient;
        this.id_doctor = id_doctor;
        this.chat_description = chat_description;
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

    public String getChat_description() {
        return chat_description;
    }

    public void setChat_description(String chat_description) {
        this.chat_description = chat_description;
    }
}
