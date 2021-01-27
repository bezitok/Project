package com.example.dangkyphonghoc.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.activities.Add_Teacher_Screen;
import com.example.dangkyphonghoc.activities.Edit_Teacher_Screen;
import com.example.dangkyphonghoc.activities.Home_Screen;
import com.example.dangkyphonghoc.adapter.Teacher_Adapter;
import com.example.dangkyphonghoc.dao.Teacher_DAO;
import com.example.dangkyphonghoc.dto.Teacher_DTO;

import java.util.ArrayList;
import java.util.List;

public class Teacher_Management_Fragment extends Fragment {
    public static final String TEACHER = "TEACHER";
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
        lv_teacherManagement.setOnItemClickListener((adapterView, view, position, l) -> {
            Teacher_DTO teacher = teacher_dtoList.get(position);
            Intent intent = new Intent(getActivity(), Edit_Teacher_Screen.class);
            intent.putExtra(TEACHER,teacher);
            startActivity(intent);
            getActivity().finish();
        });
        lv_teacherManagement.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) (adapterView, view, position, l) -> {
            Teacher_DTO teacher = teacher_dtoList.get(position);

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Warning");
            builder.setMessage("Xác nhận xóa giảng viên này");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    teacher_dao.deleteTeacher(teacher);
                    teacher_dtoList.clear();
                    teacher_dtoList = teacher_dao.getAllTeacher();
                    teacher_adapter.notifyDataSetChanged();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        });
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
