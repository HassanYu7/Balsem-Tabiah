package com.example.testloginforuserrole.database.table;

public abstract class CoordinateDB {

    public final static String TABLE_NAME = "coordinate";

    public final static String ID_COORDINATE = "id_coordinate";
    public final static String ID_DOCTOR = "id_doctor";
    public final static String ID_APPOINTMENT = "id_appointment";
   // public final static String ID_RECEPTIONIST = "id_receptionist";



    public final static String CREATE_COORDINATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_COORDINATE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
           // + ID_DOCTOR_FOREIGN_KEY + " INTEGER, "
         //   + " CONSTRAINT"
            + ID_APPOINTMENT + " INTEGER REFERENCES " + AppointmentDB.TABLE_NAME + (AppointmentDB.ID_APPOINTMENT) + ","
            + ID_DOCTOR + " INTEGER REFERENCES " + DoctorDB.TABLE_NAME + (DoctorDB.ID_DOCTOR) + ");";

}
