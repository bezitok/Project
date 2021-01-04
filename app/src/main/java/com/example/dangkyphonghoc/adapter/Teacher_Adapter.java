package com.example.dangkyphonghoc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.dto.Teacher_DTO;

import java.util.ArrayList;
import java.util.List;

public class Teacher_Adapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Teacher_DTO> list = new ArrayList<>();

    public Teacher_Adapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.one_teacher, null);

            viewHolder = new ViewHolder();
            viewHolder.avt_teacher = convertView.findViewById(R.id.avt_teacher);
            viewHolder.fullname_teacher = convertView.findViewById(R.id.fullname_teacher);
            viewHolder.dob_teacher = convertView.findViewById(R.id.dob_teacher);
            viewHolder.department_teacher = convertView.findViewById(R.id.department_teacher);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Teacher_DTO teacher_dto = list.get(position);
        viewHolder.fullname_teacher.setText("Họ tên: " + teacher_dto.getFullname_teacher() + " - " + "Giới tính: " + teacher_dto.getGender_teacher());
        viewHolder.dob_teacher.setText("Ngày sinh: "+teacher_dto.getDob_teacher());
        viewHolder.department_teacher.setText("Bộ môn: " + teacher_dto.getDepartment_teacher());

        return convertView;
    }

    public class ViewHolder{
        ImageView avt_teacher;
        TextView fullname_teacher, dob_teacher, gender_teacher, department_teacher;
    }
}
