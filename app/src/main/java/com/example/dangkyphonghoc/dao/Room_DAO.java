package com.example.dangkyphonghoc.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.database.Room_Register_Database;
import com.example.dangkyphonghoc.dto.Room_DTO;

import java.util.ArrayList;
import java.util.List;

public class Room_DAO {

    SQLiteDatabase sqLiteDatabase;
    Room_Register_Database room_register_database;

    public Room_DAO(Context context){
        room_register_database = new Room_Register_Database(context);
    }

    public void addRoom(){

        sqLiteDatabase = room_register_database.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "401");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "402");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "403");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "404");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "405");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "406");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "407");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "408");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "409");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "410");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "411");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "412");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Room_DTO> getAllTableInfo(){

        sqLiteDatabase = room_register_database.getWritableDatabase();
        sqLiteDatabase = room_register_database.getReadableDatabase();

        List<Room_DTO> roomDtoList = new ArrayList<>();

        String query = "Select * from " + Room_Register_Database.TBL_ROOM;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Room_DTO room_dto = new Room_DTO();
            room_dto.setId_room(cursor.getInt(cursor.getColumnIndex(Room_Register_Database.TBL_ROOM_ID)));
            room_dto.setName_room(cursor.getString(cursor.getColumnIndex(Room_Register_Database.TBL_ROOM_NAME)));
            roomDtoList.add(room_dto);
            cursor.moveToNext();
        }

        return roomDtoList;
    }

    public void deleteAllRoom(){
        sqLiteDatabase = room_register_database.getWritableDatabase();
        String sql = "Delete from " + Room_Register_Database.TBL_ROOM;
        sqLiteDatabase.execSQL(sql);
    }

}
