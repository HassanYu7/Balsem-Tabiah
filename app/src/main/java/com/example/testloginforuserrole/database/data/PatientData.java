package com.example.testloginforuserrole.database.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.database.model.PatientModel;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.database.table.AppointmentDB;
import com.example.testloginforuserrole.database.table.BookAppointmentDB;
import com.example.testloginforuserrole.database.table.DoctorDB;
import com.example.testloginforuserrole.database.table.PatientDB;
import com.example.testloginforuserrole.database.table.ReceptionistDB;

import java.util.ArrayList;

public class PatientData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public PatientData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public long addPatient(PatientModel patientModel){
        ContentValues values = new ContentValues();
        values.put(PatientDB.ID_PATIENT,patientModel.getIdPersonal());
        values.put(PatientDB.FIRST_NAME,patientModel.getFirstName());
        values.put(PatientDB.MIDDLE_NAME,patientModel.getMiddleName());
        values.put(PatientDB.LAST_NAME,patientModel.getLastName());
        values.put(PatientDB.PHONE_NO,patientModel.getPhoneNo());
        values.put(PatientDB.ADDRESS,patientModel.getAddress());
        values.put(PatientDB.GENDER,patientModel.getGender());
        values.put(PatientDB.DATE_BIRTH,patientModel.getDateBirth());
        values.put(PatientDB.ID_RECORD,patientModel.getIdRecord());
        long id =  db.insert(PatientDB.TABLE_NAME,null,values);
        return id;
    }

    public Cursor getContent(String userName, SQLiteDatabase db){
        String [] proj = {PatientDB.ID_PATIENT, PatientDB.FIRST_NAME, PatientDB.MIDDLE_NAME, PatientDB.LAST_NAME,PatientDB.PHONE_NO,PatientDB.ADDRESS,PatientDB.DATE_BIRTH};
        String selection = PatientDB.ID_PATIENT +" LIKE ?";
        String [] selection_arg = {userName};
        Cursor cursor = db.query(PatientDB.TABLE_NAME, proj,selection,selection_arg,null,null,null);
        return cursor;
    }

    public Cursor getAllPatient(){
        Cursor cursor = db.rawQuery("SELECT * FROM " + PatientDB.TABLE_NAME, null);
        return cursor;
    }

    public String getUsername() throws SQLException {
        String username = "";
        String middleName = "";
        String lastName = "";

        Cursor cursor = db.query(PatientDB.TABLE_NAME, new String[] { PatientDB.FIRST_NAME, PatientDB.MIDDLE_NAME, PatientDB.LAST_NAME},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
                middleName = cursor.getString(1);
                lastName = cursor.getString(2);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return username + " " + middleName + " " + lastName;
    }

    public PatientModel getPatientInfo(PatientModel patientModel) throws SQLException {
        String username = "";
        String middleName = "";
        String lastName = "";

        Cursor cursor = db.query(PatientDB.TABLE_NAME, new String[] { PatientDB.FIRST_NAME, PatientDB.MIDDLE_NAME, PatientDB.LAST_NAME},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                cursor.getColumnIndex(patientModel.getFirstName());
                cursor.getColumnIndex(patientModel.getMiddleName());
                cursor.getColumnIndex(patientModel.getLastName());
            } while (cursor.moveToNext());
        }
        cursor.close();

        return patientModel;
    }

    public String getIdPatient() throws SQLException {
        String id = "";

        Cursor cursor = db.query(PatientDB.TABLE_NAME, new String[] { PatientDB.ID_PATIENT},
                null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return id;
    }



    public int updatePatient(String id,PatientModel patientModel, SQLiteDatabase sqLiteDatabase ){
        ContentValues values = new ContentValues();
        values.put(PatientDB.ID_PATIENT,patientModel.getIdPersonal());
        values.put(PatientDB.FIRST_NAME,patientModel.getFirstName());
        values.put(PatientDB.MIDDLE_NAME,patientModel.getMiddleName());
        values.put(PatientDB.LAST_NAME,patientModel.getLastName());
        values.put(PatientDB.PHONE_NO,patientModel.getPhoneNo());
        values.put(PatientDB.ADDRESS,patientModel.getAddress());
        values.put(PatientDB.GENDER,patientModel.getGender());
        values.put(PatientDB.DATE_BIRTH,patientModel.getDateBirth());
        values.put(PatientDB.ID_RECORD,patientModel.getIdRecord());
        String selection = PatientDB.ID_PATIENT + " LIKE ?";
        String [] selection_args = {id};
        int count = db.update(PatientDB.TABLE_NAME, values, selection, selection_args);
    //    db.update(PatientDB.TABLE_NAME,values,"id_patient = ?", new String[]{String.valueOf(patientModel.getIdPersonal())});
        return count;
    }

    public Cursor readAllDataFromPatient(){
        String query = "SELECT * FROM " + PatientDB.TABLE_NAME;
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    public String Login(String phoneNo){
        db = helper.getReadableDatabase();
        String  query="SELECT phone_no,id_patient FROM  "+ PatientDB.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String id,phone;
        phone = "Not found";
        if(cursor.moveToFirst()){
            do{
                phone = cursor.getString(0);
                if(phone.contentEquals(phoneNo)){
                    phone = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return phone;
    }

    public String Login1(String phoneNo){
        db = helper.getReadableDatabase();
        String  query="SELECT phone_no,id_patient FROM  "+ PatientDB.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String id,phone;
        phone = "Not found";
        if(cursor.moveToFirst()){
            do{
                phone = cursor.getString(0);
                if(phone.contentEquals(phoneNo)){
                    phone = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return phone;
    }

    public Cursor getData(String phoneNumber, String id) {
         db = helper.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + PatientDB.TABLE_NAME + " where " + PatientDB.PHONE_NO + "=?" + " and " + PatientDB.PHONE_NO + "=?",
                new String[] {phoneNumber, id});
        return res;
    }

    public long removePatientById(int id){
        long idp = db.delete(PatientDB.TABLE_NAME,PatientDB.ID_PATIENT + " =?", new String[] {Integer.toString(id)});
        return idp;
    }

    public ArrayList<UserModel> getNamePatientList() {

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();

        Cursor cursorAppointment = db.rawQuery("SELECT " +
                        PatientDB.TABLE_NAME + "." + PatientDB.FIRST_NAME + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.ID_PATIENT + "," +
                        AppointmentDB.TABLE_NAME + "." + AppointmentDB.ID_APPOINTMENT + "," +
                        AppointmentDB.TABLE_NAME + "." + AppointmentDB.DATE_TIME + "," +
                        DoctorDB.TABLE_NAME + "." + DoctorDB.FIRST_NAME + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.PHONE_NO + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.ADDRESS + " FROM "
                        + PatientDB.TABLE_NAME + " INNER JOIN " + BookAppointmentDB.TABLE_NAME
                        + " ON " + PatientDB.TABLE_NAME + "." + PatientDB.ID_PATIENT + "=" + BookAppointmentDB.TABLE_NAME + "." + BookAppointmentDB.ID_PATIENT

                        + " INNER JOIN " + AppointmentDB.TABLE_NAME
                        + " ON " + AppointmentDB.TABLE_NAME + "." + AppointmentDB.ID_APPOINTMENT + "=" + BookAppointmentDB.TABLE_NAME + "." + BookAppointmentDB.ID_APPOINTMENT

                        + " INNER JOIN " + DoctorDB.TABLE_NAME
                        + " ON " + DoctorDB.TABLE_NAME + "." + DoctorDB.ID_DOCTOR + "=" + BookAppointmentDB.TABLE_NAME + "." + BookAppointmentDB.ID_DOCTOR

                , null);

        if (cursorAppointment.moveToFirst()) {
            do {



                String namePatient = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.FIRST_NAME));
                int idPatient = cursorAppointment.getInt(cursorAppointment.getColumnIndex(PatientDB.ID_PATIENT));
                int idAppointment = cursorAppointment.getInt(cursorAppointment.getColumnIndex(AppointmentDB.ID_APPOINTMENT));
                String appoinDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));
                String drName = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME));
                String phonePatient = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.PHONE_NO));
                String addressPatient = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.ADDRESS));


                UserModel user = new UserModel(namePatient, idPatient, appoinDate, drName, phonePatient, addressPatient, idAppointment);


                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }



}
