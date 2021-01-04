package com.example.dangkyphonghoc.dto;

import java.util.Date;

public class Teacher_DTO {

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
}
