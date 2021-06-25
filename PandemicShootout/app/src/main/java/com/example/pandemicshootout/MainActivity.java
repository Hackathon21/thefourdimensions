package com.example.pandemicshootout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void vac(View v)
    {
        Intent in =new Intent(MainActivity.this,Vaccine.class);
        startActivity(in);
    }
    public void pla(View v)
    {
        Intent in =new Intent(MainActivity.this,Plasma.class);
        startActivity(in);
    }
    public void bed(View v)
    {
        Intent in =new Intent(MainActivity.this,Beds.class);
        startActivity(in);
    }
    public void med(View v)
    {
        Intent in =new Intent(MainActivity.this,Medicen.class);
        startActivity(in);
    }
}
