package com.example.testloginforuserrole.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.testloginforuserrole.database.table.AdminDB;
import com.example.testloginforuserrole.database.table.AppointmentDB;
import com.example.testloginforuserrole.database.table.BookAppointmentDB;
import com.example.testloginforuserrole.database.table.BookForPatientDB;
import com.example.testloginforuserrole.database.table.ChatDB;
import com.example.testloginforuserrole.database.table.CoordinateDB;
import com.example.testloginforuserrole.database.table.DiagnoseDB;
import com.example.testloginforuserrole.database.table.DoctorDB;
import com.example.testloginforuserrole.database.table.PatientDB;
import com.example.testloginforuserrole.database.table.ReceptionistDB;
import com.example.testloginforuserrole.database.table.RecordDB;
import com.example.testloginforuserrole.database.table.ViewRecordDB;
import com.example.testloginforuserrole.database.table.VirtualClinicDB;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public Context context;
    private final static String DATABASE_NAME = "Users.db";
    private final static int DATABASE_VERSION = 88;

    public MyDatabaseHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DoctorDB.CREATE_DOCTOR_TABLE);
        db.execSQL(ReceptionistDB.CREATE_RECEPTIONIST_TABLE);
        db.execSQL(PatientDB.CREATE_PATIENT_TABLE);
        db.execSQL(AppointmentDB.CREATE_APPOINTMENT_TABLE);
        db.execSQL(BookAppointmentDB.CREATE_BOOK_APPOINTMENT_TABLE);
        db.execSQL(CoordinateDB.CREATE_COORDINATE_TABLE);
        db.execSQL(AdminDB.CREATE_ADMIN_TABLE);

        //   db.execSQL(RecordDB.CREATE_RECORD_TABLE);
        //  db.execSQL(DiagnoseDB.CREATE_DIAGNOSE_TABLE);
        //  db.execSQL(ChatDB.CREATE_CHAT_TABLE);
        //  db.execSQL(VirtualClinicDB.CREATE_VIRTUAL_CLINIC_TABLE);
        //   db.execSQL(BookForPatientDB.CREATE_BOOK_FOR_PATIENT_TABLE);
        //   db.execSQL(ViewRecordDB.CREATE_VIEW_RECORD_TABLE);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DoctorDB.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ReceptionistDB.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PatientDB.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AppointmentDB.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BookAppointmentDB.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CoordinateDB.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AdminDB.TABLE_NAME);



        //   db.execSQL("DROP TABLE IF EXISTS " + RecordDB.TABLE_NAME);
    //    db.execSQL("DROP TABLE IF EXISTS " + DiagnoseDB.TABLE_NAME);
    //    db.execSQL("DROP TABLE IF EXISTS " + ChatDB.TABLE_NAME);
      //  db.execSQL("DROP TABLE IF EXISTS " + VirtualClinicDB.TABLE_NAME);
     //   db.execSQL("DROP TABLE IF EXISTS " + BookForPatientDB.TABLE_NAME);
     //   db.execSQL("DROP TABLE IF EXISTS " + ViewRecordDB.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.disableWriteAheadLogging();
       // db.execSQL("PRAGMA foreign_keys=ON");
    }

    /*  @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }*/






  /*  public int delete(String uname) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {uname};

        int count = db.delete(DoctorDB.TABLE_NAME, DoctorDB.FIRST_NAME + " = ?", whereArgs);
        return count;
    }

   */

    /*

    public int updatePhone(String oldPhoneNo, String newPhoneNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DoctorDB.PHONE_NO, newPhoneNo);
        String[] whereArgs = {oldPhoneNo};
        int count = db.update(DoctorDB.TABLE_NAME, contentValues, DoctorDB.PHONE_NO + " = ?", whereArgs);
        return count;
    }

     */
}

