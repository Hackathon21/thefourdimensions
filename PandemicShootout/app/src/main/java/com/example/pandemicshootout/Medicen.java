package com.example.pandemicshootout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.medicine.AvailableMed;

public class Medicen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicen);
    }
    public void sk(View v)
    {
        Intent I=new Intent(Medicen.this,Medicn_stock.class);
        startActivity(I);
    }
    public void am(View v)
    {
        Intent I=new Intent(Medicen.this, AvailableMed.class);
        startActivity(I);
    }

}