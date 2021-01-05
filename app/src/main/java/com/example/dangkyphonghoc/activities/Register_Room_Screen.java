package com.example.dangkyphonghoc.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.dao.Teacher_DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Register_Room_Screen extends AppCompatActivity {

    Spinner spn_teacher_name, spn_teacher_Department;
    Teacher_DAO teacher_dao;
    List<String> listTeacherName, listDepartmentName;
    HashMap<String, String> departmentTeacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_room);
        teacher_dao = new Teacher_DAO(Register_Room_Screen.this);

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


}
