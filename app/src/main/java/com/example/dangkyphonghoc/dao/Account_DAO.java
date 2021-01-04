package com.example.dangkyphonghoc.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dangkyphonghoc.database.Room_Register_Database;
import com.example.dangkyphonghoc.dto.Account_DTO;

public class Account_DAO {

    Room_Register_Database database;
    SQLiteDatabase sqLiteDatabase;

    public Account_DAO(Context context) {
        database = new Room_Register_Database(context);
    }

    public void createNewAccount(Account_DTO account){

        sqLiteDatabase = database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Room_Register_Database.TBL_ACCOUNT_USERNAME, account.getUsername());
        contentValues.put(Room_Register_Database.TBL_ACCOUNT_PASSWORD, account.getPassword());

        sqLiteDatabase.insert(Room_Register_Database.TBL_ACCOUNT, null, contentValues);

        sqLiteDatabase.close();
    }

    public boolean processLogin(String username, String password){
        sqLiteDatabase = database.getWritableDatabase();
        sqLiteDatabase = database.getReadableDatabase();

        String sql = "Select * from " +Room_Register_Database.TBL_ACCOUNT + " where " +
                Room_Register_Database.TBL_ACCOUNT_USERNAME + " = " + " '" + username + "' " + " and " +
                Room_Register_Database.TBL_ACCOUNT_PASSWORD + " = " + " '" + password + "' ";

        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if(cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }
}
