package com.example.dangkyphonghoc.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.dao.Account_DAO;
import com.example.dangkyphonghoc.database.Room_Register_Database;
import com.example.dangkyphonghoc.dto.Account_DTO;
import com.google.android.material.textfield.TextInputEditText;

public class Sign_Screen extends AppCompatActivity {

    Account_DAO account_dao;
    Room_Register_Database database;
    SQLiteDatabase sqLiteDatabase;
    TextInputEditText edt_user, edt_password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_screen);
        edt_user = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);

        account_dao = new Account_DAO(Sign_Screen.this);
    }


    public void Register(View view) {

        String username = edt_user.getText().toString();
        String password = edt_password.getText().toString();

        Account_DTO account = new Account_DTO();

        account.setUsername(username);
        account.setPassword(password);
        account_dao.createNewAccount(new Account_DTO(username, password));

        Toast.makeText(Sign_Screen.this, "Create account successfully", Toast.LENGTH_LONG).show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Sign_Screen.this, Login_Screen.class);
                startActivity(intent);
                finish();
            }
        },500);

    }
}
