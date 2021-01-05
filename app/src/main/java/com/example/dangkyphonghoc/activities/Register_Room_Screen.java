package com.example.dangkyphonghoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.dao.Room_DAO;
import com.example.dangkyphonghoc.dao.Teacher_DAO;
import com.example.dangkyphonghoc.dto.Room_DTO;
import com.example.dangkyphonghoc.fragment.Room_Management_Fragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Register_Room_Screen extends AppCompatActivity {

    Spinner spn_teacher_name, spn_teacher_Department;
    Teacher_DAO teacher_dao;
    List<String> listTeacherName, listDepartmentName;
    HashMap<String, String> departmentTeacher;
    Room_DAO room_dao;
    public static final String TEACHER_NAME = "TEACHERNAME";
    public static final String TEACHER_DEPARTMENT = "DEPARTMENT";
    public static final String REGISTER_STATUS = "REGISTER_STATUS";
    public static final String ROOM = "ROOM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_room);
        teacher_dao = new Teacher_DAO(Register_Room_Screen.this);
        room_dao = new Room_DAO(Register_Room_Screen.this);

        spn_teacher_name = findViewById(R.id.spn_teacher_name);
        spn_teacher_Department = findViewById(R.id.spn_teacher_department);
        listTeacherName = teacher_dao.getAllTeacherName();

        ArrayAdapter<String> adapter = new ArrayAdapter(Register_Room_Screen.this, android.R.layout.simple_spinner_item, listTeacherName);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spn_teacher_name.setAdapter(adapter);

        departmentTeacher = teacher_dao.getDEpartmentByName();
        listDepartmentName = new ArrayList<>(departmentTeacher.values());

        ArrayAdapter<String> adapter1 = new ArrayAdapter(Register_Room_Screen.this, android.R.layout.simple_spinner_item, listDepartmentName);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spn_teacher_Department.setAdapter(adapter1);

    }


    public void RegisterRoom(View view) {
        String teacherName = spn_teacher_name.toString();
        String teacherDepartment = spn_teacher_Department.toString();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String room_Name = bundle.getString(Room_Management_Fragment.ROOM_NAME);

        Intent intent1 = new Intent();
        Bundle bundle1 = new Bundle();

        intent1.putExtras(bundle1);
        intent1.putExtra(TEACHER_NAME, teacherName);
        intent1.putExtra(TEACHER_DEPARTMENT, teacherDepartment);
        Room_DTO room_dto = room_dao.getRoomByName(room_Name);
        room_dto.setRegiste_status(true);
        bundle1.putParcelable(ROOM, room_dto);
        intent1.putExtras(bundle1);
        setResult(RESULT_OK, intent1);
        Toast.makeText(Register_Room_Screen.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
        finish();
    }
}
