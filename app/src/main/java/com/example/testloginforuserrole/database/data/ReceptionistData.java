package com.example.testloginforuserrole.database.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.ReceptionistModel;
import com.example.testloginforuserrole.database.table.ReceptionistDB;

public class ReceptionistData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public ReceptionistData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public long addReceptionist(ReceptionistModel receptionistModel){
        ContentValues values = new ContentValues();
        values.put(ReceptionistDB.ID_RECEPTIONIST,receptionistModel.getIdPersonal());
        values.put(ReceptionistDB.FIRST_NAME,receptionistModel.getFirstName());
        values.put(ReceptionistDB.MIDDLE_NAME,receptionistModel.getMiddleName());
        values.put(ReceptionistDB.LAST_NAME,receptionistModel.getLastName());
        values.put(ReceptionistDB.PHONE_NO,receptionistModel.getPhoneNo());
        values.put(ReceptionistDB.GENDER,receptionistModel.getGender());
        long id =  db.insert(ReceptionistDB.TABLE_NAME,null,values);
        return id;
    }

    public long removeReceptionistById(int id){
        long idp = db.delete(ReceptionistDB.TABLE_NAME,ReceptionistDB.ID_RECEPTIONIST + " =?", new String[] {Integer.toString(id)});
        return idp;
    }

    public void updateReceptionist(int id, ReceptionistModel receptionistModel){
        ContentValues values = new ContentValues();
        values.put(ReceptionistDB.FIRST_NAME,receptionistModel.getFirstName());
        values.put(ReceptionistDB.MIDDLE_NAME,receptionistModel.getMiddleName());
        values.put(ReceptionistDB.LAST_NAME,receptionistModel.getLastName());
        db.update(ReceptionistDB.TABLE_NAME,values,ReceptionistDB.ID_RECEPTIONIST + " =?", new String[] {Integer.toString(id)});
    }

    public Cursor readAllDataFromReceptionist(){
        String query = "SELECT * FROM " + ReceptionistDB.TABLE_NAME;
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    public String Login(String phoneNo){
        db = helper.getReadableDatabase();
        String query = "SELECT phone_no,id_receptionist FROM  " + ReceptionistDB.TABLE_NAME;
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
        return phone;
    }

}
