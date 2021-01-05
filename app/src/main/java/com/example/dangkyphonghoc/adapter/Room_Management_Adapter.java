package com.example.dangkyphonghoc.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.dto.Room_DTO;

import java.util.List;

public class Room_Management_Adapter extends BaseAdapter implements View.OnClickListener{

    Context context;
    int layout;
    List<Room_DTO>  list;
    ViewHolder viewHolder;

    public Room_Management_Adapter(Context context, int layout, List<Room_DTO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId_room();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.a_room_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.a_room_name = convertView.findViewById(R.id.a_room_name);
            viewHolder.a_room_img = convertView.findViewById(R.id.a_room_img);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        if(list.get(position).isRoom_Selected()){
//            displayPopupRegister();
//        }

        Room_DTO room_dto = list.get(position);
        viewHolder.a_room_name.setText(room_dto.getName_room());
        viewHolder.a_room_img.setTag(position);
        viewHolder.a_room_img.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        viewHolder = (ViewHolder) ((View) v.getParent()).getTag();
        switch (id) {
            case R.id.a_room_img:
                int pos = (int) v.getTag();
                list.get(pos).setRoom_Selected(true);
//                displayPopupRegister();
                break;
        }
    }

    public class ViewHolder{
        ImageView a_room_img;
        TextView a_room_name;
    }
}
