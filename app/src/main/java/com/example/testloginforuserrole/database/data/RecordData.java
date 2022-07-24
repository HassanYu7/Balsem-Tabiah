package com.example.testloginforuserrole.database.data;

import android.database.sqlite.SQLiteDatabase;
import com.example.testloginforuserrole.database.MyDatabaseHelper;

public class RecordData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public RecordData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

}
