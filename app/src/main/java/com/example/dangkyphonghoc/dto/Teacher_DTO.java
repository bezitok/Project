package com.example.dangkyphonghoc.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Teacher_DTO implements Parcelable {

    public int id_teacher;
    public int avt_teacher;
    public String fullname_teacher;
    public String dob_teacher;
    public String gender_teacher;
    public String department_teacher;

    public Teacher_DTO(int avt_teacher, String fullname_teacher, String dob_teacher, String gender_teacher, String department_teacher) {
        this.avt_teacher = avt_teacher;
        this.fullname_teacher = fullname_teacher;
        this.dob_teacher = dob_teacher;
        this.gender_teacher = gender_teacher;
        this.department_teacher = department_teacher;
    }

    public Teacher_DTO(String fullname_teacher, String dob_teacher, String gender_teacher, String department_teacher) {
        this.fullname_teacher = fullname_teacher;
        this.dob_teacher = dob_teacher;
        this.gender_teacher = gender_teacher;
        this.department_teacher = department_teacher;
    }

    public Teacher_DTO() {
    }

    protected Teacher_DTO(Parcel in) {
        id_teacher = in.readInt();
        avt_teacher = in.readInt();
        fullname_teacher = in.readString();
        dob_teacher = in.readString();
        gender_teacher = in.readString();
        department_teacher = in.readString();
    }

    public static final Creator<Teacher_DTO> CREATOR = new Creator<Teacher_DTO>() {
        @Override
        public Teacher_DTO createFromParcel(Parcel in) {
            return new Teacher_DTO(in);
        }

        @Override
        public Teacher_DTO[] newArray(int size) {
            return new Teacher_DTO[size];
        }
    };

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public int getAvt_teacher() {
        return avt_teacher;
    }

    public void setAvt_teacher(int avt_teacher) {
        this.avt_teacher = avt_teacher;
    }

    public String getFullname_teacher() {
        return fullname_teacher;
    }

    public void setFullname_teacher(String fullname_teacher) {
        this.fullname_teacher = fullname_teacher;
    }

    public String getDob_teacher() {
        return dob_teacher;
    }

    public void setDob_teacher(String dob_teacher) {
        this.dob_teacher = dob_teacher;
    }

    public String getGender_teacher() {
        return gender_teacher;
    }

    public void setGender_teacher(String gender_teacher) {
        this.gender_teacher = gender_teacher;
    }

    public String getDepartment_teacher() {
        return department_teacher;
    }

    public void setDepartment_teacher(String department_teacher) {
        this.department_teacher = department_teacher;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_teacher);
        parcel.writeInt(avt_teacher);
        parcel.writeString(fullname_teacher);
        parcel.writeString(dob_teacher);
        parcel.writeString(gender_teacher);
        parcel.writeString(department_teacher);
    }
}
