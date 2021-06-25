package com.example.pandemicshootout.medicine;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.R;

import java.util.ArrayList;

public class AvailableMed extends AppCompatActivity {
    ListView medlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_med);
    medlist=findViewById(R.id.vaccinelist);
    final ArrayList<MedicineView> m=new ArrayList<MedicineView>();
        MedicineAdapter md=new MedicineAdapter(this,m);
        medlist.setAdapter(md);
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));

    }
}