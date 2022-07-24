package com.example.testloginforuserrole.database.table;

import java.time.LocalDateTime;

public abstract class AppointmentDB {




    public static final String TABLE_NAME = "appointment";
    public static final String ID_APPOINTMENT = "id_appointment";
    public static final String DATE_TIME = "date_time";


    public final static String CREATE_APPOINTMENT_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_APPOINTMENT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DATE_TIME + " TEXT " + ");";





}
