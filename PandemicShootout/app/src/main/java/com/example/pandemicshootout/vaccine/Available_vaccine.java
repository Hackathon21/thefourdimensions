package com.example.pandemicshootout.vaccine;

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pandemicshootout.Constants;
import com.example.pandemicshootout.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Available_vaccine extends AppCompatActivity {
    ListView vacclist;
    final ArrayList<VaccineView> m=new ArrayList<VaccineView>();
    String url;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_vaccine);
        vacclist=findViewById(R.id.vaccinelist);


        Intent in = getIntent();
        String pincode = in.getExtras().getString("pincode");
        String date[] = in.getExtras().getStringArray("date");

        Log.d("pincode",pincode);

        for(String s:date){
            Log.d("DAte- -- ","GO-----"+s);
        }

        ///covid?pincode=?&exday=?&month=?
        url = Constants.node_server+"/covid?pincode="+pincode+"&day="+date[0]+"&month="+date[1];

        queue = Volley.newRequestQueue(this);

        VaccineAdapter md=new VaccineAdapter(this,m);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        vacclist.setAdapter(md);
                        Log.d("RESPONSE",response.toString());
                        try {
                            JSONArray jsonArray = response.getJSONArray("sessions");
                            for(int i = 0; i< jsonArray.length(); i++){
                                JSONObject k = (JSONObject) jsonArray.get(i);
                                Log.d("OBJECT",k.toString());
                                String name = k.getString("name");
                                String vac_name = k.getString("vaccine");
                                int available = k.getInt("available_capacity");
                                long age_limit = k.getLong("min_age_limit");

                                m.add(new VaccineView(name,available,age_limit,vac_name));
                            }
                        } catch (Exception e) {
                            Toast.makeText(Available_vaccine.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });


        queue.add(jsonObjectRequest);


        vacclist.setAdapter(md);

    }
}