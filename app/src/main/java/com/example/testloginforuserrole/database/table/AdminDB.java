package com.example.testloginforuserrole.database.table;

public abstract class AdminDB {

    public final static String TABLE_NAME = "admin";

    public final static String USER_NAME = "user_name";
    public final static String PASSWORD = "password";


    public final static String CREATE_ADMIN_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + USER_NAME  + " TEXT, "
            + PASSWORD + " INTEGER);";
}
