package com.example.testloginforuserrole.database.table;

public abstract class DiagnoseDB {

    public final static String TABLE_NAME = "diagnose";

    public final static String ID_PATIENT = "id_patient";
    public final static String ID_APPOINTMENT_DIAGNOSE = "id_appointment_diagnose";
    public final static String ID_DOCTOR = "id_doctor";
    public final static String RESULT = "result";
    public final static String PRESCRIPTION = "prescription";


    public final static String CREATE_DIAGNOSE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_PATIENT + " INTEGER PRIMARY KEY REFERENCES " + PatientDB.TABLE_NAME + (PatientDB.ID_PATIENT) + ","
            + ID_DOCTOR + " INTEGER REFERENCES " + (DoctorDB.ID_DOCTOR) + ","
            + ID_APPOINTMENT_DIAGNOSE + " INTEGER REFERENCES " + (AppointmentDB.TABLE_NAME) + ","
            + RESULT + " TEXT, "
            + PRESCRIPTION + " TEXT);";


}
