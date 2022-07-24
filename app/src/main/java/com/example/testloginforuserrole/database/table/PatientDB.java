package com.example.testloginforuserrole.database.table;

public abstract class PatientDB {

    public final static String TABLE_NAME = "patient";

    public final static String ID_PATIENT = "id_patient";
    public final static String ID_RECORD = "id_record";
    public final static String FIRST_NAME = "first_name";
    public final static String MIDDLE_NAME = "middle_name";
    public final static String LAST_NAME = "last_name";
    public final static String PHONE_NO = "phone_no";
    public final static String ADDRESS = "address";
    public final static String GENDER = "gender";
    public final static String DATE_BIRTH = "date_birth";


    public final static String CREATE_PATIENT_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_PATIENT  + " INTEGER PRIMARY KEY NOT NULL, "
            + FIRST_NAME + " TEXT, "
            + MIDDLE_NAME + " TEXT, "
            + LAST_NAME + " TEXT, "
            + PHONE_NO + " INTEGER (10), "
            + ADDRESS + " TEXT, "
            + DATE_BIRTH + " INTEGER, "
            + ID_RECORD + " INTEGER REFERENCES " + (RecordDB.ID_RECORD) + ","
         //   + ID_RECORD + " INTEGER REFERENCES " + RecordDB.TABLE_NAME+"("+RecordDB.ID_RECORD+")"
            + GENDER + " TEXT);";




}

