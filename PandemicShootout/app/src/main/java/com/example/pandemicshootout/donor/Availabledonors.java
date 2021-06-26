package com.example.pandemicshootout.donor;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.R;

import java.util.ArrayList;

public class Availabledonors extends AppCompatActivity {
    ListView plasmalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availabledonors);
        plasmalist=findViewById(R.id.plasmalist);
        final ArrayList<plasmaView> m=new ArrayList<plasmaView>();
        plasmaAdapter md=new plasmaAdapter(this,m);
        plasmalist.setAdapter(md);
        m.add(new plasmaView(30,4,"ICU Bed","CHC1"));
        m.add(new plasmaView(30,4,"Ventailator Bed","Narouli1"));
        m.add(new plasmaView(30,4,"Solvin cold","Mystore1"));
        m.add(new plasmaView(30,4,"Solvin cold","Mystore1"));
        m.add(new plasmaView(30,4,"Solvin cold","Mystore1"));
    }

}