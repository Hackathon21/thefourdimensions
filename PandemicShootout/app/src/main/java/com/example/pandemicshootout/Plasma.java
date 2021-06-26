package com.example.pandemicshootout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.donor.Availabledonors;

public class Plasma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plasma);
    }
    public void pd(View v)
    {
        Intent in= new Intent(Plasma.this, Availabledonors.class);
        startActivity(in);
    }
}