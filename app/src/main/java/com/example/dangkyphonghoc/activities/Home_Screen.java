package com.example.dangkyphonghoc.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dangkyphonghoc.R;
import com.example.dangkyphonghoc.fragment.Add_Teacher_Fragment;
import com.example.dangkyphonghoc.fragment.Room_Management_Fragment;
import com.example.dangkyphonghoc.fragment.Setting_Fragment;
import com.example.dangkyphonghoc.fragment.Teacher_Management_Fragment;
import com.google.android.material.navigation.NavigationView;

public class Home_Screen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    ActionBar actionBar;
    NavigationView navigationView;
    TextView txt_user;
    FragmentManager fragmentManager;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);



        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.home_screen);
        navigationView = findViewById(R.id.navigation_View);
        View view = navigationView.inflateHeaderView(R.layout.header_layout);
        txt_user = view.findViewById(R.id.drawerLayout_UserName);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(Home_Screen.this, drawerLayout, R.string.open, R.string.close);
        drawerToggle.syncState();

        navigationView.setItemIconTintList(null);

        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        navigationView.setNavigationItemSelectedListener(Home_Screen.this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(Login_Screen.USERNAME);
        txt_user.setText("Welcome: " + userName);

        fragmentManager = getSupportFragmentManager();
        Teacher_Management_Fragment teacher_management_fragment = new Teacher_Management_Fragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, teacher_management_fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.teacher_management:
                Teacher_Management_Fragment teacher_management_fragment = new Teacher_Management_Fragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_layout, teacher_management_fragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.room_management:
                Room_Management_Fragment room_management_fragment = new Room_Management_Fragment();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.content_layout, room_management_fragment);
                fragmentTransaction1.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.setting:
                Setting_Fragment setting_fragment = new Setting_Fragment();
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.replace(R.id.content_layout, setting_fragment);
                fragmentTransaction2.commit();
                drawerLayout.closeDrawers();
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Add_Teacher_Fragment add_teacher_fragment = new Add_Teacher_Fragment();
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.replace(R.id.content_layout, add_teacher_fragment);
        fragmentTransaction1.commit();

        return true;
    }
}
