package com.example.testloginforuserrole.database.table;

public abstract class VirtualClinicDB {

    public final static String TABLE_NAME = "virtual_clinic";

    public final static String ID_PATIENT = "id_patient";
    public final static String ID_DOCTOR = "id_doctor";
    public final static String HOUR = "hour";


    public final static String CREATE_VIRTUAL_CLINIC_TABLE = "CREATE TABLE " + TABLE_NAME + " ("

            + ID_PATIENT + " INTEGER PRIMARY KEY REFERENCES " + (PatientDB.ID_PATIENT) + ","
            + HOUR + " INTEGER, "
            + ID_DOCTOR + " INTEGER REFERENCES " + (DoctorDB.ID_DOCTOR) + ");";

}

