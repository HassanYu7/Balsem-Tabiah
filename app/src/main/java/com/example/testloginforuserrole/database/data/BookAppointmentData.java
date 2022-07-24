package com.example.testloginforuserrole.database.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.database.table.AppointmentDB;
import com.example.testloginforuserrole.database.table.BookAppointmentDB;
import com.example.testloginforuserrole.database.table.DoctorDB;
import com.example.testloginforuserrole.database.table.PatientDB;

import java.util.ArrayList;

public class BookAppointmentData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public BookAppointmentData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public void insertBookAppointment(String namePatient, String date, String name) {
        db = helper.getWritableDatabase();

        db.execSQL("INSERT INTO "
                        + BookAppointmentDB.TABLE_NAME +
                        "("
                        + BookAppointmentDB.ID_PATIENT + ","
                        +  BookAppointmentDB.ID_DOCTOR + ","
                        + BookAppointmentDB.ID_APPOINTMENT +
                        ")" +

                        "VALUES((SELECT " + PatientDB.ID_PATIENT +
                        " FROM " + PatientDB.TABLE_NAME +
                        " WHERE " + PatientDB.ID_PATIENT + "=?)," +


                        "(SELECT " + DoctorDB.ID_DOCTOR +
                        " FROM " + DoctorDB.TABLE_NAME +
                        " WHERE " + DoctorDB.ID_DOCTOR + "=?),"+

                        "(SELECT " + AppointmentDB.ID_APPOINTMENT +
                        " FROM " + AppointmentDB.TABLE_NAME +
                        " WHERE " + AppointmentDB.DATE_TIME + "=?))",

                new Object[]{namePatient, name, date});
    }

    public ArrayList<UserModel> getInfoUpComingAppoint() {

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();


        Cursor cursorAppointment = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME, null);

        if (cursorAppointment.moveToFirst()) {
            do {


                String drName = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME));

                UserModel user = new UserModel(drName);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<UserModel> deleteUpComingAppointment(String date, String idPatient) {
         db = helper.getWritableDatabase();

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();

        Cursor cursorAppointment = db.rawQuery("DELETE FROM " + BookAppointmentDB.TABLE_NAME
                        + " WHERE " + BookAppointmentDB.ID_APPOINTMENT + "=" +
                        "(SELECT " + AppointmentDB.ID_APPOINTMENT + " FROM "+ AppointmentDB.TABLE_NAME + " WHERE "+ AppointmentDB.DATE_TIME+ "=?)"

                        +" AND "
                        + BookAppointmentDB.ID_PATIENT +  "=" +
                        "(SELECT " + PatientDB.ID_PATIENT + " FROM "+ PatientDB.TABLE_NAME + " WHERE "+ PatientDB.ID_PATIENT+ "=?)"
                , new String[]{date, idPatient});

        if (cursorAppointment.moveToFirst()) {
            do {

                int idPat = cursorAppointment.getInt(cursorAppointment.getColumnIndex(PatientDB.ID_PATIENT));
                String appointDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));

                UserModel user = new UserModel(appointDate, idPat);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<UserModel> updateDataForDoctor(String newDate, String oldDate) {
         db = helper.getWritableDatabase();

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();


        Cursor cursorAppointment = db.rawQuery(" UPDATE " + AppointmentDB.TABLE_NAME
                        + " SET " +
                        AppointmentDB.DATE_TIME + "=?"
                        +" WHERE "+  AppointmentDB.DATE_TIME+"=?"
                , new String[]{newDate,oldDate});



        if (cursorAppointment.moveToFirst()) {
            do {


                String appointDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));

                UserModel user = new UserModel(appointDate);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public void deleteDateForDoctor(String date){
         db = helper.getWritableDatabase();
        db.delete(AppointmentDB.TABLE_NAME, AppointmentDB.DATE_TIME+"=?", new String[]{date});
    }

    void deleteAllDateForDoctor(){
         db = helper.getWritableDatabase();
        db.delete(AppointmentDB.TABLE_NAME,null,null);
    }
}
