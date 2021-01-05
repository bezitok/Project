package com.example.dangkyphonghoc.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Room_Register_Database extends SQLiteOpenHelper {

    public static final String DB_NAME = "BOOK_ROOM";
    public static final int DB_VERSION = 1;

    public static final String TBL_TABLE_ID = "ID";

    public static final String TBL_ACCOUNT = "ACCOUNT";
    public static final String TBL_ACCOUNT_ID = "ID_ACCOUNT";
    public static final String TBL_ACCOUNT_USERNAME = "USERNAME";
    public static final String TBL_ACCOUNT_PASSWORD = "PASSWORD";

    public static final String TBL_TEACHER = "TEACHER";
    public static final String TBL_TEACHER_ID = "ID_TEACHER";
    public static final String TBL_TEACHER_FULLNAME = "FULLNAME_TEACHER";
    public static final String TBL_TEACHER_DOB = "DOB_TEACHER";
    public static final String TBL_TEACHER_GENDER = "GENDER_TEACHER";
    public static final String TBL_TEACHER_DEPARTMENT = "DEPARTMENT_TEACHER";

    public static final String TBL_ROOM = "ROOM";
    public static final String TBL_ROOM_ID = "ID_ROOM";
    public static final String TBL_ROOM_NAME = "ROOM_NAME";
    public static final String TBL_ROOM_SELECTED = "ROOM_SELECTED";
    public static final String TBL_ROOM_REGISTE_STATUS = "REGISTE_STATUS";

    String sqlCreateAccountTable = "Create table " + TBL_ACCOUNT + " ( "
            + TBL_ACCOUNT_ID + " integer primary key, "
            + TBL_ACCOUNT_USERNAME + " text, "
            + TBL_ACCOUNT_PASSWORD + " text " + " ) ";

    String sqlCreateTeacherTable = "Create table " + TBL_TEACHER + " ( "
            + TBL_TEACHER_ID + " integer primary key, "
            + TBL_TEACHER_FULLNAME + " text, "
            + TBL_TEACHER_DOB + " text, "
            + TBL_TEACHER_GENDER + " text, "
            + TBL_TEACHER_DEPARTMENT + " text " + " ) ";

    String sqlCreateRoomTable = "Create table " + TBL_ROOM + " ( " +
            TBL_ROOM_ID + " integer primary key, " +
            TBL_ROOM_NAME + " text, " +
            TBL_ROOM_SELECTED + " text, " +
            TBL_ROOM_REGISTE_STATUS + " text " + " ) ";


    public Room_Register_Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreateAccountTable);
        sqLiteDatabase.execSQL(sqlCreateTeacherTable);
        sqLiteDatabase.execSQL(sqlCreateRoomTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists " + TBL_ACCOUNT);
        sqLiteDatabase.execSQL("Drop table if exists " + TBL_TEACHER);
        sqLiteDatabase.execSQL("Drop table if exists " + TBL_ROOM);
        onCreate(sqLiteDatabase);
    }

}
