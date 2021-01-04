package com.example.dangkyphonghoc.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.activities.Home_Screen;
import com.example.dangkyphonghoc.dao.Teacher_DAO;
import com.example.dangkyphonghoc.dto.Teacher_DTO;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Add_Teacher_Fragment extends Fragment {

    Teacher_DAO teacher_dao;
    Button btn_add_teacher;
    TextInputEditText tpedt_teacherDOB, tpedt_teacherFullname;
    RadioGroup rdg_teacher_gender;
    RadioButton rdb_male_teacher, rdb_female_teacher;
    Spinner spn_teacher_department;
    DatePickerDialog datePickerDialog;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View add_teacher_fragment = inflater.inflate(R.layout.add_teacher_fragment, null);
        setHasOptionsMenu(false);

        ((Home_Screen)getActivity()).getSupportActionBar().setTitle(R.string.add_teacher_fragment);

        teacher_dao = new Teacher_DAO(getActivity());

        btn_add_teacher = add_teacher_fragment.findViewById(R.id.btn_add_teacher);
        tpedt_teacherFullname = add_teacher_fragment.findViewById(R.id.tpedt_teacher_fullname_edit);
        tpedt_teacherDOB = add_teacher_fragment.findViewById(R.id.tpedt_teacher_dob_edit);
        rdg_teacher_gender = add_teacher_fragment.findViewById(R.id.rdg_teacher_gender_edit);
        rdb_male_teacher = add_teacher_fragment.findViewById(R.id.rdb_male_teacher);
        rdb_female_teacher = add_teacher_fragment.findViewById(R.id.rdb_female_teacher);
        spn_teacher_department = add_teacher_fragment.findViewById(R.id.spn_teacher_department_edit);

        btn_add_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teacher_fullname = tpedt_teacherFullname.getText().toString();
                String teacher_dob = tpedt_teacherDOB.getText().toString();

                int id = rdg_teacher_gender.getCheckedRadioButtonId();
                RadioButton radioButton = getActivity().findViewById(id);
                String teacher_gender = radioButton.getText().toString();

                String teacher_department = spn_teacher_department.getSelectedItem().toString();

                Teacher_DTO teacher_dto = new Teacher_DTO(teacher_fullname, teacher_dob, teacher_gender, teacher_department);
                teacher_dao.addTeacher(teacher_dto);

                Toast.makeText(getActivity(), "Thêm thành công", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),Home_Screen.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        tpedt_teacherDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTeacherDOB();
            }
        });


        List<String> departmentList = new ArrayList<>();
        departmentList.add("Khoa học máy tính");
        departmentList.add("Hệ thống thông tin");
        departmentList.add("Công nghệ phần mềm");
        departmentList.add("Công nghệ đa phương tiện");
        departmentList.add("Kiến trúc & Mạng máy tính");

        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, departmentList);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spn_teacher_department.setAdapter(adapter);

        return add_teacher_fragment;
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
                datePickerDialog  = new DatePickerDialog(getActivity(), (view, year, monthOfYear, dayOfMonth) -> {
                    // TODO Auto-generated method stub
                    tpedt_teacherDOB.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

}
