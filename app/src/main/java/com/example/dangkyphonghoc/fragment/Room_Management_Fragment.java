package com.example.dangkyphonghoc.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.activities.Home_Screen;
import com.example.dangkyphonghoc.activities.Register_Room_Screen;
import com.example.dangkyphonghoc.adapter.Room_Management_Adapter;
import com.example.dangkyphonghoc.dao.Room_DAO;
import com.example.dangkyphonghoc.dto.Room_DTO;

import java.util.List;

public class Room_Management_Fragment extends Fragment  {

    Room_DAO room_dao;
    List<Room_DTO> room_dtoList;
    GridView gv_room_management;
    Room_Management_Adapter adapter;
    public static int REQUEST_CODE = 1;
    public static String ROOM_NAME = "ROOM_NAME";
    String teacherName = "";
    String teacherDepartment = "";
    Room_DTO room_dto ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View room_management_fragment = inflater.inflate(R.layout.room_management_fragment, null);

        ((Home_Screen)getActivity()).getSupportActionBar().setTitle(R.string.room_management);
        gv_room_management = room_management_fragment.findViewById(R.id.gdv_room_manager);
        room_dao = new Room_DAO(getActivity());
        room_dtoList = room_dao.getAllRoom();


        displayRoom();

        gv_room_management.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Register_Room_Screen.class);
                intent.putExtra(ROOM_NAME, room_dtoList.get(position).getName_room());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        gv_room_management.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                room_dto = room_dtoList.get(position);
                if(room_dto.isRegiste_status()==false){
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Trạng thái đăng ký phòng")
                            .setMessage("Phòng chưa được đăng ký bởi giáo viên nào")
                            .create()
                            .show();
                }else{
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Trạng thái đăng ký phòng")
                            .setMessage("Phòng được đăng ký" + "\n" + "Giảng viên: " + teacherName + "\n" + "Bộ môn: " + teacherDepartment)
                            .create()
                            .show();
                }
                return false;
            }
        });



        return room_management_fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            teacherName =data.getStringExtra(Register_Room_Screen.TEACHER_NAME);
            teacherDepartment = data.getStringExtra(Register_Room_Screen.TEACHER_DEPARTMENT);
            room_dto = data.getParcelableExtra(Register_Room_Screen.ROOM);
            room_dao.updateRegisterStatus(room_dto);
            room_dtoList.clear();
            room_dtoList = room_dao.getAllRoom();
            int a = 0;
        }
    }

    public void displayRoom(){
        if(room_dao.getAllRoom().size()==0){
            room_dao.addRoom();
            room_dao.getAllRoom();
        }else {
            room_dao.getAllRoom();
            room_dtoList = room_dao.getAllRoom();
        }
        adapter = new Room_Management_Adapter(getActivity(), R.layout.a_room_layout, room_dtoList);
        gv_room_management.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
