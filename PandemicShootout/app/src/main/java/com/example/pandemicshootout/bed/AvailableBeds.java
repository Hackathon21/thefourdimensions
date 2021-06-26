package com.example.pandemicshootout.bed;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.pandemicshootout.Constants;
import com.example.pandemicshootout.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AvailableBeds extends AppCompatActivity {

    ListView bedlist;
    final ArrayList<BedView> m=new ArrayList<BedView>();
    String url;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablebeds);
        bedlist=findViewById(R.id.bedlist);

        Intent in = getIntent();
        String pincode = in.getExtras().getString("pincode");

        url = Constants.node_server+"/covid/beds/?pincode="+pincode;

        queue = Volley.newRequestQueue(this);

        BedAdapter md=new BedAdapter(this,m);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                bedlist.setAdapter(md);
                Log.d("RESPONSE",response.toString());
                try {
                    for(int i = 0; i< response.length(); i++){
                        JSONObject k = response.getJSONObject(i);
                        Log.d("OBJECT",k.toString());
                        String name = k.getString("HospitalName");
                                String phone = k.getString("Contact");
                                long beds = k.getLong("Toalbeds");
                                String oxygen = k.getString("Oxygenleft");

                                m.add(new BedView(name,phone,beds,oxygen));
                    }
                } catch (Exception e) {
                    Toast.makeText(AvailableBeds.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AvailableBeds.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
        bedlist.setAdapter(md);
    }
}