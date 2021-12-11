package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Functions {



    public static Intent put_alarm() {
        int hour=8;
        int minute=0;
        //Creo un arraylist con i giorni della settimana in cui voglio che la sveglia sia messa

        final ArrayList<Integer> days=new ArrayList<>();
        days.add(Calendar.DATE);
        days.add(Calendar.DATE+1);
        days.add(Calendar.DATE+2);

        Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,minute);
        intent.putExtra(AlarmClock.EXTRA_DAYS,days);

        return intent;
    }


    // public JSONArray load_json(){
    //   return
    //}
}