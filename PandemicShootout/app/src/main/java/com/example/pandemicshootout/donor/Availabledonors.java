package com.example.pandemicshootout.donor;

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


public class Availabledonors extends AppCompatActivity {
    ListView plasmalist;
    final ArrayList<PlasmaView> m = new ArrayList<>();
    String url;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availabledonors);
        plasmalist=findViewById(R.id.plasmalist);


        Intent i = getIntent();

        String pincode = i.getExtras().getString("pincode");
        String bloodGroup = i.getExtras().getString("bloodGroup");

        url = Constants.server+"/donor/getPlasmaDonors/"+bloodGroup+"/"+pincode;

        queue = Volley.newRequestQueue(this);

        PlasmaAdapter md=new PlasmaAdapter(this,m);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                plasmalist.setAdapter(md);
                Log.d("RESPONSE",response.toString());
                try {
                    for(int i = 0; i< response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        Log.d("OBJECT",jsonObject.toString());
                        boolean can = jsonObject.getBoolean("enabled");
                        if(can) {
                            String name = jsonObject.getString("name");
                            String bloodGroup = jsonObject.getString("bloodGroup");
                            String pincode = jsonObject.getString("pincode");
                            String phoneNumber = jsonObject.getString("phoneNumber");
                            m.add(new PlasmaView(name, bloodGroup, pincode, phoneNumber));
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(Availabledonors.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Availabledonors.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);



//        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
//        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
//        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
//        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
    }

}