package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
    }
    public void click_to_alarm(View view) {
        Intent intent=Functions.put_alarm();
        startActivity(intent);
    }
}