package com.example.testloginforuserrole.database.table;

public abstract class RecordDB {

    public final static String TABLE_NAME = "record";

    public final static String ID_RECORD = "id_record";
    public final static String ID_RECEPTIONIST = "id_receptionist";
    public final static String STATE = "state";

    /*
     TODO:
          1- Default state [Inactive]
          2- Change to [Active] from Receptionist after check him
     */

    public final static String CREATE_RECORD_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ("
                    + ID_RECORD + " INTEGER PRIMARY KEY NOT NULL, "
                    + ID_RECEPTIONIST + " INTEGER REFERENCES " + ReceptionistDB.ID_RECEPTIONIST + ","
                    + STATE + " INTEGER );";




}
