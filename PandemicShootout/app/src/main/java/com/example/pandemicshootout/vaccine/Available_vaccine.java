package com.example.pandemicshootout.vaccine;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.R;
import com.example.pandemicshootout.medicine.MedicineAdapter;
import com.example.pandemicshootout.medicine.MedicineView;

import java.util.ArrayList;

public class Available_vaccine extends AppCompatActivity {
ListView vacclist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_vaccine);
        vacclist=findViewById(R.id.vaccinelist);
        final ArrayList<MedicineView> m=new ArrayList<MedicineView>();
        MedicineAdapter md=new MedicineAdapter(this,m);
        vacclist.setAdapter(md);
        m.add(new MedicineView(30,4,"Covaxin","CHC1"));
        m.add(new MedicineView(30,4,"Covishield","Narouli1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));
        m.add(new MedicineView(30,4,"Solvin cold","Mystore1"));

    }
}