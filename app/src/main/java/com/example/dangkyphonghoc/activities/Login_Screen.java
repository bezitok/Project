package com.example.dangkyphonghoc.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.dao.Account_DAO;

public class Login_Screen extends AppCompatActivity {

    EditText edt_user, edt_pass;
    Button btn_login;
    public static final String USERNAME = "username";
    Account_DAO account_dao = new Account_DAO(Login_Screen.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        initWidget();
    }

    public void Login(View v){
        final String user = edt_user.getText().toString();
        final String pass = edt_pass.getText().toString();

        if(user.isEmpty() || pass.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(Login_Screen.this);
            builder.setCancelable(false);
            builder.setTitle("Alert");
            builder.setMessage("Fields can't be empty. Please try again");
            builder.setPositiveButton("OK", null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else{
            boolean check = account_dao.processLogin(user, pass);
            if(check){
                SystemClock.sleep(700);
                Toast.makeText(Login_Screen.this, "Log In Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Login_Screen.this, Home_Screen.class);
                intent.putExtra(USERNAME, user);
                startActivity(intent);
                finish();
            }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(Login_Screen.this);
            builder.setCancelable(false);
            builder.setTitle("Alert");
            builder.setMessage("Username or password is incorrect. Please try again.");
            builder.setPositiveButton("OK", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        }
    }

    public void initWidget(){
        edt_user = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);
        btn_login = findViewById(R.id.btn_login);
    }

    public void Register(View view) {
        Intent intent = new Intent(Login_Screen.this, Sign_Screen.class);
        startActivity(intent);
        finish();
    }
}