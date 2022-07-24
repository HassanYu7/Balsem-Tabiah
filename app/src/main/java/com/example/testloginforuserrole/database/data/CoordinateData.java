package com.example.testloginforuserrole.database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.AppointmentModel;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.database.table.AppointmentDB;
import com.example.testloginforuserrole.database.table.CoordinateDB;
import com.example.testloginforuserrole.database.table.DoctorDB;

public class CoordinateData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;
    public Context context;

    public CoordinateData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }


    public void insertCoordinate(String date, String name) {

        db.execSQL("INSERT INTO " + CoordinateDB.TABLE_NAME + "(" + CoordinateDB.ID_APPOINTMENT + "," + CoordinateDB.ID_DOCTOR + ")" +

                        "VALUES((SELECT " + AppointmentDB.ID_APPOINTMENT +
                        " FROM " + AppointmentDB.TABLE_NAME +
                        " WHERE " + AppointmentDB.DATE_TIME + "=?)," +

                        "(SELECT " + DoctorDB.ID_DOCTOR +
                        " FROM " + DoctorDB.TABLE_NAME +
                        " WHERE " + DoctorDB.FIRST_NAME + "=?))",
                new Object[]{date, name});
    }



}
