package com.example.testloginforuserrole.database.data;

import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;

public class ViewRecordData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public ViewRecordData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }
}
