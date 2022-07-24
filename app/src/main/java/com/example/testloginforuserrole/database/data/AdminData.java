package com.example.testloginforuserrole.database.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.model.AdminModel;
import com.example.testloginforuserrole.database.table.AdminDB;
import com.example.testloginforuserrole.database.table.DoctorDB;

public class AdminData {

    private MyDatabaseHelper helper;
    private SQLiteDatabase db;

    public AdminData(MyDatabaseHelper helper) {
        this.helper = helper;
        db = helper.getWritableDatabase();
    }

    public void insertAdmin(){
        ContentValues values = new ContentValues();
        values.put(AdminDB.USER_NAME,"ahmed");
        values.put(AdminDB.PASSWORD,"ahmed");
        db.insert(AdminDB.TABLE_NAME,null,values);
    }

    public String Login(String phoneNo){
        db = helper.getReadableDatabase();
        String  query="SELECT user_name,password FROM  "+ AdminDB.TABLE_NAME;
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
