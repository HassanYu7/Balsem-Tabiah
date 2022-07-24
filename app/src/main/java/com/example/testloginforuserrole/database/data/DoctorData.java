package com.example.testloginforuserrole.database.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.testloginforuserrole.database.model.AppointmentModel;
import com.example.testloginforuserrole.database.model.DoctorModel;
import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.UserModel;
import com.example.testloginforuserrole.database.table.AppointmentDB;
import com.example.testloginforuserrole.database.table.BookAppointmentDB;
import com.example.testloginforuserrole.database.table.DoctorDB;
import com.example.testloginforuserrole.database.table.PatientDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public DoctorData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public void addDoctor(DoctorModel doctorModel){
        ContentValues values = new ContentValues();
        values.put(DoctorDB.ID_DOCTOR,doctorModel.getIdPersonal());
        values.put(DoctorDB.FIRST_NAME,doctorModel.getFirstName());
        values.put(DoctorDB.MIDDLE_NAME,doctorModel.getMiddleName());
        values.put(DoctorDB.LAST_NAME,doctorModel.getLastName());
        values.put(DoctorDB.PHONE_NO,doctorModel.getPhoneNo());
        values.put(DoctorDB.SPECIALIZATION,doctorModel.getSpecialization());
        values.put(DoctorDB.GENDER,doctorModel.getGender());
        long id =  db.insert(DoctorDB.TABLE_NAME,null,values);
        if (id == -1) {
            Toast.makeText(helper.context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(helper.context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }

    }
    public long removeDoctorById(int id){
        long idp = db.delete(DoctorDB.TABLE_NAME,DoctorDB.ID_DOCTOR + " =?", new String[] {Integer.toString(id)});
        return idp;
    }
    public void removeDoctor(DoctorModel doctorModel){
        removeDoctorById(doctorModel.getIdPersonal());
    }
    public void updateDoctor(int id, DoctorModel doctorModel){
        ContentValues values = new ContentValues();
        values.put(DoctorDB.FIRST_NAME,doctorModel.getFirstName());
        values.put(DoctorDB.MIDDLE_NAME,doctorModel.getMiddleName());
        values.put(DoctorDB.LAST_NAME,doctorModel.getLastName());
        db.update(DoctorDB.TABLE_NAME,values,DoctorDB.ID_DOCTOR + " =?", new String[] {Integer.toString(id)});
    }
    public Cursor readAllDataFromDoctor(){
        String query = "SELECT * FROM " + DoctorDB.TABLE_NAME;
         db = helper.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
    public ArrayList<HashMap<String, String>> getDoctors(){
         db = helper.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT id_doctor, first_name, last_name , specialization  FROM "+ DoctorDB.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("id_doctor",cursor.getString(cursor.getColumnIndex(DoctorDB.ID_DOCTOR)));
            user.put("first_name",cursor.getString(cursor.getColumnIndex(DoctorDB.FIRST_NAME)));
            user.put("last_name",cursor.getString(cursor.getColumnIndex(DoctorDB.LAST_NAME)));
            user.put("specialization",cursor.getString(cursor.getColumnIndex(DoctorDB.SPECIALIZATION)));
            userList.add(user);
        }
        return userList;
    }
    public ArrayList<String> getDoctorBySpecialization(String specialization){
        db = helper.getWritableDatabase();
        ArrayList<String> userList = new ArrayList<>();
        String query = "SELECT id_doctor, first_name, last_name , specialization FROM "+ DoctorDB.TABLE_NAME;
        Cursor cursor = db.query(DoctorDB.TABLE_NAME, new String[]{DoctorDB.ID_DOCTOR, DoctorDB.FIRST_NAME, DoctorDB.LAST_NAME, DoctorDB.SPECIALIZATION}
                , DoctorDB.SPECIALIZATION+ "=?",new String[]{specialization},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("id_doctor",cursor.getString(cursor.getColumnIndex(DoctorDB.ID_DOCTOR)));
            user.put("first_name",cursor.getString(cursor.getColumnIndex(DoctorDB.FIRST_NAME)));
            user.put("last_name",cursor.getString(cursor.getColumnIndex(DoctorDB.LAST_NAME)));
            user.put("specialization",cursor.getString(cursor.getColumnIndex(DoctorDB.SPECIALIZATION)));
            userList.add(String.valueOf(user));
        }
        return  userList;
    }

//    public ArrayList<HashMap<String, String>> getDoctorBySpecialization(String specialization){
//        db = helper.getWritableDatabase();
//        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
//        String query = "SELECT id_doctor, first_name, last_name , specialization FROM "+ DoctorDB.TABLE_NAME;
//        Cursor cursor = db.query(DoctorDB.TABLE_NAME, new String[]{DoctorDB.ID_DOCTOR, DoctorDB.FIRST_NAME, DoctorDB.LAST_NAME, DoctorDB.SPECIALIZATION}
//        , DoctorDB.SPECIALIZATION+ "=?",new String[]{specialization},null, null, null, null);
//        if (cursor.moveToNext()){
//            HashMap<String,String> user = new HashMap<>();
//            user.put("id_doctor",cursor.getString(cursor.getColumnIndex(DoctorDB.ID_DOCTOR)));
//            user.put("first_name",cursor.getString(cursor.getColumnIndex(DoctorDB.FIRST_NAME)));
//            user.put("last_name",cursor.getString(cursor.getColumnIndex(DoctorDB.LAST_NAME)));
//            user.put("specialization",cursor.getString(cursor.getColumnIndex(DoctorDB.SPECIALIZATION)));
//            userList.add(user);
//        }
//        return  userList;
//    }



/*
    public Cursor getData(){
        SQLiteDatabase db = helper.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME, null);
    }

 */

    public String Login(String phoneNo){
        db = helper.getReadableDatabase();
        String query = "SELECT phone_no,id_doctor FROM  " + DoctorDB.TABLE_NAME;
        Cursor corsor = db.rawQuery(query, null);
        String id,phone;
        phone = "Not found";
        if(corsor.moveToFirst()){
            do{
                phone = corsor.getString(0);
                if(phone.contentEquals(phoneNo)){
                    phone = corsor.getString(1);
                    break;
                }
            } while (corsor.moveToNext());
        }
        return  phone;
    }

    public ArrayList<DoctorModel> readDoctors() {
        ArrayList<DoctorModel> courseModalArrayList = null;
         db = helper.getReadableDatabase();
        Cursor cursorDoctors = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME, null);

         courseModalArrayList = new ArrayList<>();

        if (cursorDoctors.moveToFirst()) {
            do {
                courseModalArrayList.add(new DoctorModel(
                        cursorDoctors.getString(2),
                        cursorDoctors.getString(4)
                ));
            } while (cursorDoctors.moveToNext());
        }
        cursorDoctors.close();
        return courseModalArrayList;
    }

    public ArrayList<String> readDoctorsOnly() {
        db = helper.getReadableDatabase();
        Cursor cursorAppointment = db.rawQuery("SELECT first_name FROM " + DoctorDB.TABLE_NAME, null);

        ArrayList<String> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(cursorAppointment.getString(2));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public Cursor getSpecialization(String specialization){
        String [] proj = {DoctorDB.ID_DOCTOR, DoctorDB.FIRST_NAME, DoctorDB.LAST_NAME, DoctorDB.SPECIALIZATION};
        String selection = DoctorDB.SPECIALIZATION +" LIKE ?";
        String [] selection_arg = {specialization};
        Cursor cursor = db.query(DoctorDB.TABLE_NAME, proj,selection,selection_arg,null,null,null);
        return cursor;
    }

//    public Cursor getSpecialization(){
//        String [] proj = {DoctorDB.ID_DOCTOR, DoctorDB.FIRST_NAME, DoctorDB.LAST_NAME, DoctorDB.SPECIALIZATION};
//        String selection = DoctorDB.SPECIALIZATION +" LIKE ?";
//        Cursor cursor = db.query(DoctorDB.TABLE_NAME, proj,selection,null,null,null,null);
//        return cursor;
//    }
    public ArrayList<DoctorModel> getSpecializationToCoordinate() {
        db = helper.getWritableDatabase();
       // Cursor c = null;
       // c = db.rawQuery("Select specialization from doctor ", null);
        Cursor c = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME, null);
        ArrayList<DoctorModel> courseModalArrayList = new ArrayList<>();

        if (c.moveToFirst()) {
            do {
                courseModalArrayList.add(new DoctorModel(
                        c.getString(5)
                ));
            } while (c.moveToNext());
        }


        c.close();

        return courseModalArrayList;
    }

    public ArrayList<DoctorModel> readSpecialization() {
        db = helper.getReadableDatabase();
        Cursor cursorAppointment = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME, null);

        ArrayList<DoctorModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                        courseModalArrayList.add(new DoctorModel(
                                cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.SPECIALIZATION))

                ));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<DoctorModel> readDateAndTime() {
      //  Cursor c = db.rawQuery("Select specialization from " + DoctorDB.TABLE_NAME, null);
        Cursor c = db.rawQuery("Select first_name, last_name from doctor ", null);


        ArrayList<DoctorModel> courseModalArrayList = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                courseModalArrayList.add(new DoctorModel(
                        c.getString(c.getColumnIndex(DoctorDB.FIRST_NAME)),
                        c.getString(c.getColumnIndex(DoctorDB.LAST_NAME))
                        ));
            } while (c.moveToNext());
        }
        c.close();

        return courseModalArrayList;
    }

    public List <DoctorModel> getAllLabels(){
        List <DoctorModel> labels = new ArrayList <DoctorModel> ();
        // Select All Query

        String selectQuery = "SELECT  * FROM " + DoctorDB.TABLE_NAME;
         db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst ()) {
            do {
                labels.add ( new DoctorModel (
                        cursor.getString(0) ,
                        cursor.getString(1)
                        )
                );
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning labels
        return labels;
    }

    public List<String> getAllLabelss(){
        List<String> labels = new ArrayList<String>();

        String selectQuery = "SELECT  first_name FROM " + DoctorDB.TABLE_NAME;



        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }

    public List<DoctorModel> getAllDoctorsList(){
        List<DoctorModel> labels = new ArrayList<>();

        String selectQuery = "SELECT  specialization FROM " + DoctorDB.TABLE_NAME;
         db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(new DoctorModel
                        (cursor.getString(6)
                        ));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }

    public List <DoctorModel> getAllDat(){

        List<DoctorModel> list = new ArrayList<>();

        SQLiteDatabase db = helper.getReadableDatabase();

        String [] columns = {DoctorDB.FIRST_NAME,DoctorDB.LAST_NAME};
        Cursor cursor = db.query(DoctorDB.TABLE_NAME, columns, null, null, null, null, null);

        while (cursor.moveToNext()) {

//            int index = cursor.getColumnIndex(LysandrosHelper.UID);
//            int index2 = cursor.getColumnIndex(LysandrosHelper.NAME);
//            int index3 = cursor.getColumnIndex(LysandrosHelper.SURNAME);
//            int index4 = cursor.getColumnIndex(LysandrosHelper.DEPARTMENT);
              int index1 = cursor.getColumnIndex(DoctorDB.FIRST_NAME);
              int index2 = cursor.getColumnIndex(DoctorDB.LAST_NAME);
           //   int cid = cursor.getInt(index);

            String firstName = cursor.getString(index1);
            String lastName = cursor.getString(index2);


            DoctorModel bean = new DoctorModel(firstName,lastName);
            list.add(bean);
        }

        return list;
    }


    public ArrayList<DoctorModel> readAllSpilazation() {
        db = helper.getReadableDatabase();
        Cursor cursorAppointment = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME, null);

        ArrayList<DoctorModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(new DoctorModel(
                        cursorAppointment.getString(5)


                ));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<DoctorModel> readDoctorsSecondry(String speclaization) throws SQLException {
        db = helper.getReadableDatabase();
        Cursor cursorAppointment = db.rawQuery("SELECT id_doctor, first_name, last_name FROM " + DoctorDB.TABLE_NAME
                + " WHERE " + DoctorDB.SPECIALIZATION + "=?" , new String[]{speclaization});

        ArrayList<DoctorModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(new DoctorModel(
                        cursorAppointment.getInt(0),
                        cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME)),
                        cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.LAST_NAME))
                ));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<DoctorModel> readDoctors1(String speclaization) {
        db = helper.getReadableDatabase();
        Cursor cursorAppointment = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME
                + " WHERE " + DoctorDB.SPECIALIZATION + "=?", new String[]{speclaization});

        ArrayList<DoctorModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(new DoctorModel(
                        cursorAppointment.getString(2)
                     //   cursorAppointment.getString(3)


                ));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }


    public ArrayList<AppointmentModel> readDoctors(String speclaization) {
        db = helper.getReadableDatabase();
        Cursor cursorAppointment = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME
                + " WHERE " + DoctorDB.SPECIALIZATION + "=?", new String[]{speclaization});

        ArrayList<AppointmentModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(new AppointmentModel(
                        cursorAppointment.getString(1)
                        //   cursorAppointment.getString(3)


                ));
            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }
    public Cursor getIdCursor() {
        String selectQuery = "SELECT id_doctor AS _id, * FROM " + DoctorDB.TABLE_NAME;
         db = helper.getReadableDatabase();
        return db.rawQuery(selectQuery, null);
    }



    public ArrayList<DoctorModel> readDoctorsAndReturnId(String speclaization) {
        db = helper.getReadableDatabase();
      //  Cursor cursorAppointment = db.rawQuery("SELECT * FROM " + DoctorDB.TABLE_NAME + " WHERE " + DoctorDB.SPECIALIZATION + "=?" , new String[]{speclaization});
       Cursor cursorAppointment = db.rawQuery( "SELECT id_doctor, first_name, last_name  FROM  doctor WHERE specialization = '"+speclaization+"'" , null);


//        Cursor cursorAppointment = db.rawQuery("SELECT id_doctor, first_name, last_name FROM " + DoctorDB.TABLE_NAME
//                + " WHERE " + DoctorDB.SPECIALIZATION + "=?" , new String[]{speclaization});

        ArrayList<DoctorModel> courseModalArrayList = new ArrayList<>();

        if (cursorAppointment.moveToFirst()) {
            do {
                courseModalArrayList.add(new DoctorModel(
                        cursorAppointment.getInt(0),
                        cursorAppointment.getString(1),
                        cursorAppointment.getString(2)
                ));
            } while (cursorAppointment.moveToNext());
        }


        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<UserModel> getNameDoctorListUpComing() {

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();


        Cursor cursorAppointment = db.rawQuery("SELECT " +
                        AppointmentDB.TABLE_NAME + "." + AppointmentDB.ID_APPOINTMENT + "," +
                        AppointmentDB.TABLE_NAME + "." + AppointmentDB.DATE_TIME + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.ID_PATIENT + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.FIRST_NAME + "," +
                        DoctorDB.TABLE_NAME + "." + DoctorDB.FIRST_NAME + "," +
                        DoctorDB.TABLE_NAME + "." + DoctorDB.SPECIALIZATION + " FROM "
                        + AppointmentDB.TABLE_NAME + " INNER JOIN " + BookAppointmentDB.TABLE_NAME
                        + " ON " + AppointmentDB.TABLE_NAME + "." + AppointmentDB.ID_APPOINTMENT + "=" + BookAppointmentDB.TABLE_NAME + "." + BookAppointmentDB.ID_APPOINTMENT
                        + " INNER JOIN " + DoctorDB.TABLE_NAME
                        + " ON " + DoctorDB.TABLE_NAME + "." + DoctorDB.ID_DOCTOR + "=" + BookAppointmentDB.TABLE_NAME + "." + BookAppointmentDB.ID_DOCTOR
                        + " INNER JOIN " + PatientDB.TABLE_NAME
                        + " ON " + PatientDB.TABLE_NAME + "." + PatientDB.ID_PATIENT + "=" + BookAppointmentDB.TABLE_NAME + "." + BookAppointmentDB.ID_PATIENT

                , null);

        if (cursorAppointment.moveToFirst()) {
            do {

                int idApp = cursorAppointment.getInt(cursorAppointment.getColumnIndex(AppointmentDB.ID_APPOINTMENT));

                int idPatient = cursorAppointment.getInt(cursorAppointment.getColumnIndex(PatientDB.ID_PATIENT));

                String namePatient = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.FIRST_NAME));

                String appoinDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));

                String drSpeclazation = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.SPECIALIZATION));

                String drName = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME));


                UserModel user = new UserModel(idPatient,namePatient, idApp, drName, drSpeclazation, appoinDate);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }

    public ArrayList<UserModel> getNamePatientListForDoctor() {

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();


        Cursor cursorAppointment = db.rawQuery("SELECT " +
                        PatientDB.TABLE_NAME + "." + PatientDB.FIRST_NAME + "," +
                        PatientDB.TABLE_NAME + "." + PatientDB.ID_PATIENT + "," +
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

                String appoinDate = cursorAppointment.getString(cursorAppointment.getColumnIndex(AppointmentDB.DATE_TIME));

                String phonePatient = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.PHONE_NO));
                String addressPatient = cursorAppointment.getString(cursorAppointment.getColumnIndex(PatientDB.ADDRESS));


                UserModel user = new UserModel(namePatient, idPatient, appoinDate, phonePatient, addressPatient);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }


    public ArrayList<UserModel> getDoctorsNames() {

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();


        Cursor cursorAppointment = db.rawQuery("SELECT " + DoctorDB.FIRST_NAME + "," +
                        DoctorDB.SPECIALIZATION + " FROM " + DoctorDB.TABLE_NAME

                , null);
        if (cursorAppointment.moveToFirst()) {
            do {

                String drName = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.FIRST_NAME));

                String drSpeclazation = cursorAppointment.getString(cursorAppointment.getColumnIndex(DoctorDB.SPECIALIZATION));


                UserModel user = new UserModel(drName, drSpeclazation);

                courseModalArrayList.add(user);


            } while (cursorAppointment.moveToNext());
        }
        cursorAppointment.close();
        return courseModalArrayList;
    }



}
