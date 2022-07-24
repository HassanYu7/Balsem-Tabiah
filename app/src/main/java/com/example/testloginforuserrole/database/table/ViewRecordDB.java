package com.example.testloginforuserrole.database.table;

public abstract class ViewRecordDB {

    public final static String TABLE_NAME = "view_record";

    public final static String ID_RECORD = "id_record";
    public final static String ID_DOCTOR = "id_doctor";



    public final static String CREATE_VIEW_RECORD_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + ID_RECORD + " INTEGER PRIMARY KEY REFERENCES " + (RecordDB.ID_RECORD) + ","
            + ID_DOCTOR + " INTEGER REFERENCES " + (DoctorDB.ID_DOCTOR) + ");";

}
