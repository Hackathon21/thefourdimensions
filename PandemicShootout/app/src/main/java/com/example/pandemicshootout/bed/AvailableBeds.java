package com.example.pandemicshootout.bed;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.R;

import java.util.ArrayList;

public class AvailableBeds extends AppCompatActivity {
    ListView bedlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablebeds);
        bedlist=findViewById(R.id.bedlist);
        final ArrayList<bedView> m=new ArrayList<bedView>();
        bedAdapter md=new bedAdapter(this,m);
        bedlist.setAdapter(md);
        m.add(new bedView(30,4,"ICU Bed","CHC1"));
        m.add(new bedView(30,4,"Ventailator Bed","Narouli1"));
        m.add(new bedView(30,4,"Solvin cold","Mystore1"));
        m.add(new bedView(30,4,"Solvin cold","Mystore1"));
        m.add(new bedView(30,4,"Solvin cold","Mystore1"));
    }
}