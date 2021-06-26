package com.example.pandemicshootout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.bed.AvailableBeds;

public class Beds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beds);
    }
    public void ab(View v)
    {
        Intent in=new Intent(Beds.this, AvailableBeds.class);
        startActivity(in);
    }
}