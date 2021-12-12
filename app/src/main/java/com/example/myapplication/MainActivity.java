package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
     String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open_menu(View view) {
         url="https://corsi.unibo.it/laurea/ElettronicaTelecomunicazioni/orario-lezioni/@@orario_reale_json?anno=3&curricula=995-000";
        open_request();
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void open_request() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        S stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            save_json(response);
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }
    private void save_json(String http) throws IOException {
        //inizializzo il file

        //String filepath="/storage/emulated/0/Android/data/Mydir";
       // String filename="Myfile.txt";
       // File myfile=new File(getExternalFilesDir(filepath),filename);
       // FileOutputStream fos=null;
        //fos=new FileOutputStream(myfile);
       // fos.write(http.getBytes());
    }
}