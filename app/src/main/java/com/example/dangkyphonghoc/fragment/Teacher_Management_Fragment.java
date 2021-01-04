package com.example.dangkyphonghoc.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.activities.Add_Teacher_Screen;
import com.example.dangkyphonghoc.activities.Home_Screen;
import com.example.dangkyphonghoc.adapter.Teacher_Adapter;
import com.example.dangkyphonghoc.dao.Teacher_DAO;
import com.example.dangkyphonghoc.dto.Teacher_DTO;

import java.util.ArrayList;
import java.util.List;

public class Teacher_Management_Fragment extends Fragment {

    ListView lv_teacherManagement;
    Teacher_Adapter teacher_adapter;
    FragmentManager fragmentManager;
    Teacher_DAO teacher_dao;
    List<Teacher_DTO> teacher_dtoList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View teacher_management_fragment = inflater.inflate(R.layout.teacher_management_fragment, null);
        setHasOptionsMenu(true);
        ((Home_Screen)getActivity()).getSupportActionBar().setTitle(R.string.teacher_fragment);

        teacher_dao = new Teacher_DAO(getActivity());
        lv_teacherManagement = teacher_management_fragment.findViewById(R.id.lv_listTeacher);
        teacher_dtoList = teacher_dao.getAllTeacher();
        teacher_adapter = new Teacher_Adapter(getActivity(), R.layout.one_teacher, teacher_dtoList);
        lv_teacherManagement.setAdapter(teacher_adapter);

        return teacher_management_fragment;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem menuAddTeacher = menu.add(1, R.id.add_teacher, 1, R.string.add_teacher);
        menuAddTeacher.setIcon(R.drawable.add);
        menuAddTeacher.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }


}
