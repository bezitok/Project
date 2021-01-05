package com.example.dangkyphonghoc.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.database.Room_Register_Database;
import com.example.dangkyphonghoc.dto.Room_DTO;
import com.example.dangkyphonghoc.dto.Teacher_DTO;

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
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "402");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "403");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "404");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "405");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "406");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "407");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "true");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "408");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "409");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "true");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "410");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "411");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "true");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);

        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, "412");
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, "false");
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "false");

        sqLiteDatabase.insert(Room_Register_Database.TBL_ROOM, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Room_DTO> getAllRoom(){

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

    public Room_DTO getRoomByName(String name){
        sqLiteDatabase = room_register_database.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Room_Register_Database.TBL_ROOM, new String[]
                        { Room_Register_Database.TBL_ROOM_ID, Room_Register_Database.TBL_ROOM_NAME,
                                Room_Register_Database.TBL_ROOM_SELECTED, Room_Register_Database.TBL_ROOM_REGISTE_STATUS},
                Room_Register_Database.TBL_ROOM_NAME + " = ? ",
                new String[] {String.valueOf(name)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        boolean room_Selected = cursor.getInt(2) > 0;
        boolean register_Status = cursor.getInt(3) > 0;

        Room_DTO room_dto = new Room_DTO(cursor.getInt(0), cursor.getString(1), room_Selected, register_Status);

        cursor.close();
        sqLiteDatabase.close();
        return room_dto;
    }

    public void updateRegisterStatus(Room_DTO room_dto){
        sqLiteDatabase = room_register_database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(Room_Register_Database.TBL_ROOM_ID, room_dto.getId_room());
        contentValues.put(Room_Register_Database.TBL_ROOM_NAME, room_dto.getName_room());
        contentValues.put(Room_Register_Database.TBL_ROOM_SELECTED, room_dto.isRoom_Selected());
        contentValues.put(Room_Register_Database.TBL_ROOM_REGISTE_STATUS, "true");

        sqLiteDatabase.update(Room_Register_Database.TBL_ROOM, contentValues,
                Room_Register_Database.TBL_ROOM_ID
                        + "=" + room_dto.getId_room(), null);
//        var a = this;
        List<Room_DTO> list = this.getAllRoom();
    }

}
