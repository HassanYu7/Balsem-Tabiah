package com.example.testloginforuserrole.database.table;

public abstract class BookAppointmentDB {

    public final static String TABLE_NAME = "book_appointment";

    public final static String ID_PATIENT = "id_patient";
    public final static String ID_DOCTOR = "id_doctor";
    public final static String ID_APPOINTMENT = "id_appointment";



    public final static String CREATE_BOOK_APPOINTMENT_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_PATIENT + " INTEGER PRIMARY KEY REFERENCES " + PatientDB.TABLE_NAME + (PatientDB.ID_PATIENT) + ","
            + ID_DOCTOR + " INTEGER REFERENCES " + DoctorDB.TABLE_NAME + (DoctorDB.ID_DOCTOR) + ","
            + ID_APPOINTMENT + " INTEGER REFERENCES " + AppointmentDB.TABLE_NAME + (AppointmentDB.ID_APPOINTMENT) + ");";

}
