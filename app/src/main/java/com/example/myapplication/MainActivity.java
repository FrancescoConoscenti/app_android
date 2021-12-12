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
     String url,datot;
     String [] inizio;
     String [] orario;
     TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inizio=new String [300];
        orario=new String [300];
        url="https://corsi.unibo.it/laurea/ElettronicaTelecomunicazioni/orario-lezioni/@@orario_reale_json?anno=3&curricula=995-000";
        tw=(TextView) findViewById(R.id.textView1);
        open_request();
    }

    public void open_menu(View view) {

        open_request();
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);

    }

    public void open_request() {
        // Instantiate the RequestQueue.
        tw.append("open");
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url,
               new Response.Listener<JSONArray>() {
                   @Override
                   public void onResponse(JSONArray response) {
                       int i,j;
                       tw.append("  on+");
                       try{
                       for (j=0, i=0;i<response.length();i++)
                       {
                           tw.append("for");

                           JSONObject datoO=response.getJSONObject(i);

                           //  datot= datoO.getString("start");
                            inizio[i]= datoO.getString("start");;
                            orario[i]= datoO.getString("time");
                            tw.append(inizio[i]);
                          // j++;
                       }
                       } catch (JSONException e) {
                           tw.append("errore volley");
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
               tw.append("errore volley");

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