package com.example.testloginforuserrole.database.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.database.table.AppointmentDB;
import com.example.testloginforuserrole.database.table.DiagnoseDB;
import com.example.testloginforuserrole.database.table.DoctorDB;
import com.example.testloginforuserrole.database.table.PatientDB;

import java.util.ArrayList;

public class DiagnoseData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public DiagnoseData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public void insertDiagnose(String namePatient, String nameDoctor, String date, String txtDiagnose, String txtPrescription) {
        db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        db.execSQL("INSERT INTO "
                        + DiagnoseDB.TABLE_NAME +
                        "(" + DiagnoseDB.ID_PATIENT + ","
                        + DiagnoseDB.ID_DOCTOR + ","
                        + DiagnoseDB.ID_APPOINTMENT_DIAGNOSE + ","
                        + DiagnoseDB.RESULT + ","
                        + DiagnoseDB.PRESCRIPTION + ")" +

                        // TODO: add full name
                        "VALUES((SELECT " + PatientDB.ID_PATIENT +
                        " FROM " + PatientDB.TABLE_NAME +
                        " WHERE " + PatientDB.FIRST_NAME + "=?)," +

                        // TODO: add full name
                        "(SELECT " + DoctorDB.ID_DOCTOR +
                        " FROM " + DoctorDB.TABLE_NAME +
                        " WHERE " + DoctorDB.FIRST_NAME + "=?)," +

                        "(SELECT " + AppointmentDB.ID_APPOINTMENT +
                        " FROM " + AppointmentDB.TABLE_NAME +
                        " WHERE " + AppointmentDB.DATE_TIME + "=?)," +

                        "('" + txtDiagnose + "')," +
                        "('" + txtPrescription + "'))",

                new Object[]{namePatient, nameDoctor, date});


    }

    // TODO: Something wrong here (Query)
    public ArrayList<UserModel> getInfoPrescription() {

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();


        Cursor cursorAppointment = db.rawQuery("SELECT " +
                        PatientDB.TABLE_NAME + "." + PatientDB.FIRST_NAME + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.GENDER + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.DATE_BIRTH + "," +
                        DiagnoseDB.TABLE_NAME + "." + DiagnoseDB.PRESCRIPTION + "," +
                        DoctorDB.TABLE_NAME + "." + DoctorDB.FIRST_NAME + "," +
                        DoctorDB.TABLE_NAME + "." + DoctorDB.SPECIALIZATION + "," +
                        AppointmentDB.TABLE_NAME + "." + AppointmentDB.DATE_TIME + " FROM "
                        + PatientDB.TABLE_NAME + " INNER JOIN " + DiagnoseDB.TABLE_NAME
                        + " ON " + PatientDB.TABLE_NAME + "." + PatientDB.ID_PATIENT + "=" + DiagnoseDB.TABLE_NAME + "." + DiagnoseDB.ID_PATIENT
                        + " INNER JOIN " + DoctorDB.TABLE_NAME
                        + " ON " + DoctorDB.TABLE_NAME + "." + DoctorDB.ID_DOCTOR + "=" + DiagnoseDB.TABLE_NAME + "." + DiagnoseDB.ID_DOCTOR

                        + " INNER JOIN " + AppointmentDB.TABLE_NAME
                        + " ON " + AppointmentDB.TABLE_NAME + "." + AppointmentDB.ID_APPOINTMENT + "=" + DiagnoseDB.TABLE_NAME + "." + DiagnoseDB.ID_APPOINTMENT_DIAGNOSE

                , null);

        if (cursorAppointment.moveToFirst()) {
            do {

                String namePatient = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.FIRST_NAME));

                String gender = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.GENDER));

                String dateOfBirth = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.DATE_BIRTH));

                String prescription = cursorAppointment.getString(cursorAppointment.getColumnIndex(DiagnoseDB.PRESCRIPTION));

                String drName = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME));


                String speciliztion = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.SPECIALIZATION));

                String date = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));


                UserModel user = new UserModel(namePatient, gender, dateOfBirth, prescription
                        , drName, speciliztion, date);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }



}
