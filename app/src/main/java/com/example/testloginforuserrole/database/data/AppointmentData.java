package com.example.testloginforuserrole.database.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.AppointmentModel;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.database.table.AppointmentDB;
import com.example.testloginforuserrole.database.table.BookAppointmentDB;
import com.example.testloginforuserrole.database.table.CoordinateDB;
import com.example.testloginforuserrole.database.table.DoctorDB;
import com.example.testloginforuserrole.database.table.PatientDB;

import java.util.ArrayList;
import java.util.List;

public class AppointmentData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;
    private Context context;



    public AppointmentData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
        this.context = context;
    }


    public void insertDate(String date) {
        db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AppointmentDB.DATE_TIME, date);
        long result = db.insert(AppointmentDB.TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(helper.context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(helper.context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    public ArrayList<AppointmentModel> readAppointment() {
        Cursor cursorAppointment =
                db.rawQuery("SELECT * FROM " + AppointmentDB.TABLE_NAME, null);

        ArrayList<AppointmentModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(new AppointmentModel(
                        cursorAppointment.getString(1)
                ));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }
    public ArrayList<AppointmentModel> readAppointmentsByDrName(String name) {
        db = helper.getReadableDatabase();


        Cursor cursorAppointment = db.rawQuery("SELECT " + AppointmentDB.DATE_TIME + " FROM "
                + AppointmentDB.TABLE_NAME
                + " INNER JOIN " + CoordinateDB.TABLE_NAME
                + " ON " + AppointmentDB.TABLE_NAME + "." + AppointmentDB.ID_APPOINTMENT + "=" + CoordinateDB.TABLE_NAME + "." + CoordinateDB.ID_APPOINTMENT
                + " INNER JOIN " + DoctorDB.TABLE_NAME
                + " ON " + DoctorDB.TABLE_NAME + "." + DoctorDB.ID_DOCTOR + "=" + CoordinateDB.TABLE_NAME + "." + CoordinateDB.ID_DOCTOR

                + " AND " + DoctorDB.TABLE_NAME + "." + DoctorDB.ID_DOCTOR + "=?", new String[]{name});



        ArrayList<AppointmentModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(new AppointmentModel(
                        cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME))


                ));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<UserModel> getDateByDrName(String dr) {

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();


        Cursor cursorAppointment = db.rawQuery("SELECT "
                        + AppointmentDB.TABLE_NAME + "." + AppointmentDB.DATE_TIME + "," +
                        DoctorDB.TABLE_NAME + "." + DoctorDB.FIRST_NAME
                        + " FROM " + AppointmentDB.TABLE_NAME + " INNER JOIN " + CoordinateDB.TABLE_NAME + " ON " +
                        AppointmentDB.TABLE_NAME + "." + AppointmentDB.ID_APPOINTMENT + "=" + CoordinateDB.TABLE_NAME + "." + CoordinateDB.ID_APPOINTMENT
                        + " INNER JOIN " + DoctorDB.TABLE_NAME + " ON " +
                        DoctorDB.TABLE_NAME + "." + DoctorDB.ID_DOCTOR + "=" + CoordinateDB.TABLE_NAME + "." + CoordinateDB.ID_DOCTOR
                        + " AND " + DoctorDB.TABLE_NAME + "." + DoctorDB.FIRST_NAME + "=?"
                , new String[]{dr});
        if (cursorAppointment.moveToFirst()) {
            do {

                String n = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME));
                String appointDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));


                UserModel user = new UserModel(appointDate, n);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<UserModel> updateData(String drName, String date, String namePatient) {
         db = helper.getWritableDatabase();

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();

//        Cursor cursorAppointment = db.rawQuery(" UPDATE " + TABLE_NAME_BOOK_APPOINTMENT
//                + " SET " +
//                        ID_PATIENT_FORNKEYBOOK + "=("
//                        + "SELECT " + ID_PATIENT + " FROM " + TABLE_NAME_PATIENT + " WHERE " + FIRST_NAME_PATIENT + "=?),"+
//
//                        ID_DOCTOR_FORNKYBOOK + "=("
//                        + "SELECT " + ID_DOCTOR + " FROM " + TABLE_NAME_Doctor + " WHERE " + FIRST_NAME + "=?),"+
//
//                ID_APPOINTMENT_FORNKEYBOOK + "=("
//                        +  "SELECT " + COLUMN_APPOINT_ID + " FROM " + TABLE_APPOINT + " WHERE " + COLUMN_DATE + "=?)"
//
//                , new String[]{namePatient,drName,date});

        Cursor cursorAppointment = db.rawQuery(" UPDATE " + BookAppointmentDB.TABLE_NAME
                        + " SET " +
//                        ID_PATIENT_FORNKEYBOOK + "=("
//                        + "SELECT " + ID_PATIENT + " FROM " + TABLE_NAME_PATIENT + " WHERE " + FIRST_NAME_PATIENT + "=?),"+
                        BookAppointmentDB.ID_DOCTOR + "=("
                        + "SELECT " + DoctorDB.ID_DOCTOR + " FROM " + DoctorDB.TABLE_NAME + " WHERE " + DoctorDB.FIRST_NAME + "=?),"+

                        BookAppointmentDB.ID_APPOINTMENT + "=("
                        +  "SELECT " + AppointmentDB.ID_APPOINTMENT + " FROM " + AppointmentDB.TABLE_NAME + " WHERE " + AppointmentDB.DATE_TIME + "=?)"

                        +" WHERE "+  BookAppointmentDB.ID_PATIENT + "=("
                        + "SELECT " + PatientDB.ID_PATIENT + " FROM " + PatientDB.TABLE_NAME + " WHERE " + PatientDB.FIRST_NAME + "=?)"
                , new String[]{drName,date,namePatient});



        if (cursorAppointment.moveToFirst()) {
            do {
                String namePat = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.FIRST_NAME));

                int idPatient = cursorAppointment.getInt(cursorAppointment.getColumnIndex(PatientDB.ID_PATIENT));

                String firstNameDoctor = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME));

                String appointDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));

                UserModel user = new UserModel(namePat, firstNameDoctor, appointDate);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }


    public ArrayList<UserModel> deleteOneRow(String date) {
         db = helper.getWritableDatabase();

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();

        Cursor cursorAppointment = db.rawQuery("DELETE FROM " + CoordinateDB.TABLE_NAME
                        + " WHERE " + CoordinateDB.ID_APPOINTMENT + "=" +
                        "(SELECT " + AppointmentDB.ID_APPOINTMENT + " FROM "+ AppointmentDB.TABLE_NAME + " WHERE "+ AppointmentDB.DATE_TIME+ "=?)"
                , new String[]{date});

        if (cursorAppointment.moveToFirst()) {
            do {

                //String n = cursorAppointment.getString(cursorAppointment.getColumnIndex(FIRST_NAME));
                String appointDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));

                UserModel user = new UserModel(appointDate);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

}
