package com.example.pandemicshootout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.medicine.AvailableMed;

public class Medicen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicen);

        EditText medicineName = findViewById(R.id.editTextTextPersonName2);
        EditText pincode = findViewById(R.id.editTextNumber);
        Button submit = findViewById(R.id.button2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I=new Intent(Medicen.this, AvailableMed.class);
                I.putExtra("name",medicineName.getText().toString());
                I.putExtra("pincode",medicineName.getText().toString());
                startActivity(I);
            }
        });


    }
    public void sk(View v)
    {
        Intent I=new Intent(Medicen.this,Medicn_stock.class);
        startActivity(I);
    }

}