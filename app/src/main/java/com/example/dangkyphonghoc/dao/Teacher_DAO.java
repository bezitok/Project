package com.example.dangkyphonghoc.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dangkyphonghoc.database.Room_Register_Database;
import com.example.dangkyphonghoc.dto.Teacher_DTO;

import java.util.ArrayList;
import java.util.List;

public class Teacher_DAO {

    Room_Register_Database database;
    SQLiteDatabase sqLiteDatabase;

    public Teacher_DAO(Context context) {
        database = new Room_Register_Database(context);
    }

    public List<Teacher_DTO> getAllTeacher(){
        sqLiteDatabase = database.getWritableDatabase();
        sqLiteDatabase = database.getReadableDatabase();
        List<Teacher_DTO> list = new ArrayList<>();
        String sql = "Select * from " + Room_Register_Database.TBL_TEACHER;
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Teacher_DTO teacher_dto = new Teacher_DTO();

            teacher_dto.setId_teacher(cursor.getInt(cursor.getColumnIndex(Room_Register_Database.TBL_TEACHER_ID)));
            teacher_dto.setFullname_teacher(cursor.getString(cursor.getColumnIndex(Room_Register_Database.TBL_TEACHER_FULLNAME)));
            teacher_dto.setDob_teacher(cursor.getString(cursor.getColumnIndex(Room_Register_Database.TBL_TEACHER_DOB)));
            teacher_dto.setGender_teacher(cursor.getString(cursor.getColumnIndex(Room_Register_Database.TBL_TEACHER_GENDER)));
            teacher_dto.setDepartment_teacher(cursor.getString(cursor.getColumnIndex(Room_Register_Database.TBL_TEACHER_DEPARTMENT)));

            list.add(teacher_dto);
            cursor.moveToNext();
        }
        return list;
    }

    public Teacher_DTO getTeacherById(int id){
        sqLiteDatabase = database.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(Room_Register_Database.TBL_TEACHER, new String[]
                        { Room_Register_Database.TBL_TEACHER_ID, Room_Register_Database.TBL_TEACHER_FULLNAME,
                                Room_Register_Database.TBL_TEACHER_DOB, Room_Register_Database.TBL_TEACHER_GENDER,
                                Room_Register_Database.TBL_TEACHER_DEPARTMENT},
                Room_Register_Database.TBL_TEACHER_ID + " = ? ",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Teacher_DTO teacher = new Teacher_DTO(cursor.getInt(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));

        cursor.close();
        sqLiteDatabase.close();
        return teacher;
    }

    public void addTeacher(Teacher_DTO teacher){
        sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Room_Register_Database.TBL_TEACHER_FULLNAME, teacher.getFullname_teacher());
        contentValues.put(Room_Register_Database.TBL_TEACHER_DOB, teacher.getDob_teacher());
        contentValues.put(Room_Register_Database.TBL_TEACHER_GENDER, teacher.getGender_teacher());
        contentValues.put(Room_Register_Database.TBL_TEACHER_DEPARTMENT, teacher.getDepartment_teacher());

        sqLiteDatabase.insert(Room_Register_Database.TBL_TEACHER, null, contentValues);
        sqLiteDatabase.close();
    }

    public int deleteTeacher(Teacher_DTO teacher){
        sqLiteDatabase = database.getWritableDatabase();
        return sqLiteDatabase.delete(Room_Register_Database.TBL_TEACHER, Room_Register_Database.TBL_TEACHER_ID
                + "=?" , new String[] {String.valueOf(teacher.getId_teacher())});
    }

    public void editTeacher(Teacher_DTO teacher){
        sqLiteDatabase =database.getReadableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Room_Register_Database.TBL_TEACHER_FULLNAME, teacher.getFullname_teacher());
        contentValues.put(Room_Register_Database.TBL_TEACHER_DOB, teacher.getDob_teacher());
        contentValues.put(Room_Register_Database.TBL_TEACHER_GENDER, teacher.getGender_teacher());
        contentValues.put(Room_Register_Database.TBL_TEACHER_DEPARTMENT, teacher.getDepartment_teacher());

        sqLiteDatabase.update(Room_Register_Database.TBL_TEACHER, contentValues,
                Room_Register_Database.TBL_TEACHER_ID
                        + "=" + teacher.getId_teacher(), null);
    }
}
