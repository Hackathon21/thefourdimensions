package com.example.pandemicshootout.medicine;

import android.content.Intent;
import android.os.Bundle;
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

public class AvailableMed extends AppCompatActivity {
    ListView medlist;
    final ArrayList<MedicineView> m=new ArrayList<MedicineView>();
    String url;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_med);
        medlist=findViewById(R.id.vaccinelist);

        Intent i = getIntent();

        String name = i.getExtras().getString("name");
        String pincode = i.getExtras().getString("pincode");

        url = Constants.server+name+"/"+pincode;
        requestQueue = Volley.newRequestQueue(this);
        getData();

        MedicineAdapter md=new MedicineAdapter(this,m);
        medlist.setAdapter(md);
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));

    }

    private void getData(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONArray jsonArray = response;
                try {
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        float price = (float) jsonObject.getDouble("price");
                        long stock = (long) jsonObject.getLong("stock");
                        String name = jsonObject.getString("name");
                        String store = jsonObject.getString("storeName");
                        m.add(new MedicineView(price,stock,name,store));
                    }
                } catch (Exception e) {
                    Toast.makeText(AvailableMed.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AvailableMed.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}