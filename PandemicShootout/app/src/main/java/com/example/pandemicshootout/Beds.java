package com.example.pandemicshootout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.bed.AvailableBeds;

public class Beds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beds);

        EditText pin = findViewById(R.id.editTextTextPersonName2);

        Button submit = findViewById(R.id.button3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Beds.this, AvailableBeds.class);
                in.putExtra("pincode",pin.getText().toString());
                startActivity(in);
            }
        });
    }
}