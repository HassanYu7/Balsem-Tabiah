package com.example.testloginforuserrole.database.table;

public abstract class ReceptionistDB {

    public final static String TABLE_NAME = "receptionist";


    public final static String ID_RECEPTIONIST = "id_receptionist";
    public final static String FIRST_NAME = "first_name";
    public final static String MIDDLE_NAME = "middle_name";
    public final static String LAST_NAME = "last_name";
    public final static String PHONE_NO = "phone_no";
    public final static String GENDER = "gender";


    public final static String CREATE_RECEPTIONIST_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    " (" +
                    ID_RECEPTIONIST + " INTEGER PRIMARY KEY NOT NULL, " +
                    FIRST_NAME + " TEXT, " +
                    MIDDLE_NAME + " TEXT, " +
                    LAST_NAME + " TEXT, " +
                    PHONE_NO + " INTEGER, " +
                    GENDER + " TEXT);";
}
