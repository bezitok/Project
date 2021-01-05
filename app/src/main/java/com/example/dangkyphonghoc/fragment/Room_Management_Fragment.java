package com.example.dangkyphonghoc.fragment;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View room_management_fragment = inflater.inflate(R.layout.room_management_fragment, null);

        ((Home_Screen)getActivity()).getSupportActionBar().setTitle(R.string.room_management);
        gv_room_management = room_management_fragment.findViewById(R.id.gdv_room_manager);
        room_dao = new Room_DAO(getActivity());
        room_dtoList = room_dao.getAllTableInfo();

        displayRoom();

        gv_room_management.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Register_Room_Screen.class);
                startActivity(intent);
            }
        });

        return room_management_fragment;
    }

    public void displayRoom(){
        room_dtoList.clear();
        if(room_dao.getAllTableInfo().size()==0){
            room_dao.addRoom();
            room_dao.getAllTableInfo();
        }else {
            room_dao.getAllTableInfo();
            room_dtoList = room_dao.getAllTableInfo();
        }
        adapter = new Room_Management_Adapter(getActivity(), R.layout.a_room_layout, room_dtoList);
        gv_room_management.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
