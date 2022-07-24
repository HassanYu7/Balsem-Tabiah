package com.example.testloginforuserrole.database.table;

public abstract class DoctorDB {

    public final static String TABLE_NAME = "doctor";

    public final static String ID_DOCTOR = "id_doctor";
    public final static String FIRST_NAME = "first_name";
    public final static String MIDDLE_NAME = "middle_name";
    public final static String LAST_NAME = "last_name";
    public final static String PHONE_NO = "phone_no";
    public final static String SPECIALIZATION = "specialization";
    public final static String GENDER = "gender";



    public final static String CREATE_DOCTOR_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    " (" +
                    ID_DOCTOR + " INTEGER PRIMARY KEY, " +
                    FIRST_NAME + " TEXT, " +
                    MIDDLE_NAME + " TEXT, " +
                    LAST_NAME + " TEXT, " +
                    PHONE_NO + " INTEGER, " +
                    SPECIALIZATION + " TEXT, " +
                    GENDER + " TEXT);";

}
