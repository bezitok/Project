package com.example.dangkyphonghoc.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.dao.Teacher_DAO;
import com.example.dangkyphonghoc.dto.Teacher_DTO;
import com.example.dangkyphonghoc.fragment.Teacher_Management_Fragment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Edit_Teacher_Screen extends AppCompatActivity {
    Teacher_DAO teacher_dao;
    Button btn_edit_teacher;
    TextInputEditText tpedt_teacherDOB, tpedt_teacherFullname;
    RadioGroup rdg_teacher_gender;
    RadioButton rdb_male_teacher, rdb_female_teacher;
    Spinner spn_teacher_department;
    DatePickerDialog datePickerDialog;
    Teacher_DTO teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_teacher_screen);

        teacher_dao = new Teacher_DAO(Edit_Teacher_Screen.this);

        btn_edit_teacher = this.findViewById(R.id.btn_edit_teacher);
        tpedt_teacherFullname = this.findViewById(R.id.tpedt_teacher_fullname_edit);
        tpedt_teacherDOB = this.findViewById(R.id.tpedt_teacher_dob_edit);
        rdg_teacher_gender = this.findViewById(R.id.rdg_teacher_gender_edit);
        rdb_male_teacher = this.findViewById(R.id.rdb_female_teacher_edit);
        rdb_female_teacher = this.findViewById(R.id.rdb_male_teacher_edit);
        spn_teacher_department = this.findViewById(R.id.spn_teacher_department_edit);

        Intent intent = getIntent();
        teacher = intent.getParcelableExtra(Teacher_Management_Fragment.TEACHER);
        tpedt_teacherFullname.setText(teacher.getFullname_teacher());
        tpedt_teacherDOB.setText(teacher.getDob_teacher());
        if(teacher.getGender_teacher().equals(rdb_male_teacher.getText().toString())){
            rdg_teacher_gender.check(rdb_male_teacher.getId());
        }else{
            rdg_teacher_gender.check(rdb_female_teacher.getId());
        }

        String[] spn_arr_items = {"Khoa học máy tính", "Hệ thống thông tin", "Công nghệ phần mềm", "Công nghệ đa phương tiện", "Kiến trúc & Mạng máy tính"};

        List<String> departmentList = new ArrayList<>();
        departmentList.add("Khoa học máy tính");
        departmentList.add("Hệ thống thông tin");
        departmentList.add("Công nghệ phần mềm");
        departmentList.add("Công nghệ đa phương tiện");
        departmentList.add("Kiến trúc & Mạng máy tính");

        ArrayAdapter<String> adapter = new ArrayAdapter(Edit_Teacher_Screen.this, android.R.layout.simple_spinner_item, departmentList);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spn_teacher_department.setAdapter(adapter);


        for(int i = 0;i<spn_arr_items.length;i++){
            if(spn_arr_items[i].compareToIgnoreCase(teacher.getDepartment_teacher()) == 0){
                spn_teacher_department.setSelection(i);
            }
        }

        btn_edit_teacher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String teacher_fullname = tpedt_teacherFullname.getText().toString();
                String teacher_dob = tpedt_teacherDOB.getText().toString();

                int id = rdg_teacher_gender.getCheckedRadioButtonId();
                RadioButton radioButton = Edit_Teacher_Screen.this.findViewById(id);
                String teacher_gender = radioButton.getText().toString();

                String teacher_department = spn_teacher_department.getSelectedItem().toString();
                teacher.setFullname_teacher(teacher_fullname);
                teacher.setDob_teacher(teacher_dob);
                teacher.setGender_teacher(teacher_gender);
                teacher.setDepartment_teacher(teacher_department);
                teacher_dao.editTeacher(teacher);

                Toast.makeText(Edit_Teacher_Screen.this, "Sửa thành công", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Edit_Teacher_Screen.this,Home_Screen.class);
                startActivity(intent);
                Edit_Teacher_Screen.this.finish();
            }
        });
        tpedt_teacherDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTeacherDOB();
            }
        });
    }
    public void getTeacherDOB(){
        tpedt_teacherDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog  = new DatePickerDialog(Edit_Teacher_Screen.this, (view, year, monthOfYear, dayOfMonth) -> {
                    // TODO Auto-generated method stub
                    tpedt_teacherDOB.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
}
