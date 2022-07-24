package com.example.testloginforuserrole.database.table;

public abstract class ChatDB {

    public final static String TABLE_NAME = "chat";

    public final static String ID_PATIENT = "id_patient";
    public final static String ID_DOCTOR = "id_doctor";
    public final static String CHAT_DESCRIPTION = "chat_description";


    public final static String CREATE_CHAT_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            //     + ID_PATIENT  + " INTEGER PRIMARY KEY NOT NULL, "


            + ID_PATIENT + " INTEGER PRIMARY KEY REFERENCES " + (PatientDB.ID_PATIENT) + ","
            + CHAT_DESCRIPTION + " TEXT, "
            + ID_DOCTOR + " INTEGER REFERENCES " + (DoctorDB.ID_DOCTOR) + ");";
}


