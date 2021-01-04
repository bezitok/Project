package com.example.dangkyphonghoc.dto;

public class Account_DTO {

    public int id_account;
    public String username;
    public String password;

    public Account_DTO(int id_account, String username, String password) {
        this.id_account = id_account;
        this.username = username;
        this.password = password;
    }

    public Account_DTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account_DTO() {
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
