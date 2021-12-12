package com.example.myapplication;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
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
     String [] inizio;
     String [] orario;
     TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inizio=new String [200];
        orario=new String [200];
        url="https://corsi.unibo.it/laurea/ElettronicaTelecomunicazioni/orario-lezioni/@@orario_reale_json?anno=3&curricula=995-000";
        tw=(TextView) findViewById(R.id.textView);
    }

    public void open_menu(View view) {

        open_request();
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void open_request() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
               new Response.Listener<JSONArray>() {
                   @Override
                   public void onResponse(JSONArray response) {
                       try{
                       for (int i=0;i<response.length();i++)
                       {


                           JSONObject datoO=response.getJSONObject(i);

                            inizio[i]= datoO.getString("start");
                            orario[i]= datoO.getString("time");
                            tw.append(inizio[i]);

                       }
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               }
               // new Response.Listener<JSONArray>()
               /*{
                   @Override
                   public void onResponse(JSONArray response) {
                        try {
                            for (int i=0;i<response.length();i++)
                            {

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }*/, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {


           }
       });
        queue.add(jsonArrayRequest);
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