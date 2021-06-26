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
        final ArrayList<BedView> m=new ArrayList<BedView>();
        BedAdapter md=new BedAdapter(this,m);
        bedlist.setAdapter(md);
        m.add(new BedView("ICU Bed","437568436543",4,"45.55","56.55"));
        m.add(new BedView("ICU Bed","437568436543",4,"45.55","56.55"));
        m.add(new BedView("ICU Bed","437568436543",4,"45.55","56.55"));
        m.add(new BedView("ICU Bed","437568436543",4,"45.55","56.55"));
    }
}