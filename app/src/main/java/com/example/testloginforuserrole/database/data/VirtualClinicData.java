package com.example.testloginforuserrole.database.data;

import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;

public class VirtualClinicData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public VirtualClinicData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }
}
