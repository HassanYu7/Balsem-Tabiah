package com.example.testloginforuserrole.database.table;

public abstract class BookForPatientDB {

    public final static String TABLE_NAME = "book_for_patient";

    public final static String ID_PATIENT = "id_patient";
    public final static String ID_DOCTOR = "id_doctor";
    public final static String ID_RECEPTIONIST = "id_receptionist";
    public final static String ID_APPOINTMENT = "id_appointment";


    public final static String CREATE_BOOK_FOR_PATIENT_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_PATIENT + " INTEGER PRIMARY KEY REFERENCES " + (PatientDB.ID_PATIENT) + ","
            + ID_DOCTOR + " INTEGER REFERENCES " + (DoctorDB.ID_DOCTOR) + ","
            + ID_RECEPTIONIST + " INTEGER REFERENCES " + (ReceptionistDB.ID_RECEPTIONIST) + ","
            + ID_APPOINTMENT + " INTEGER REFERENCES " + (AppointmentDB.ID_APPOINTMENT) + ");";

}
