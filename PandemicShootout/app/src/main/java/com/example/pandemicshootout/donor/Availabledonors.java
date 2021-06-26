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
        final ArrayList<PlasmaView> m=new ArrayList<PlasmaView>();
        PlasmaAdapter md=new PlasmaAdapter(this,m);
        plasmalist.setAdapter(md);
        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
        m.add(new PlasmaView("Xyz","B-positive","fvfgiurwegiufer","244412","354358734"));
    }

}