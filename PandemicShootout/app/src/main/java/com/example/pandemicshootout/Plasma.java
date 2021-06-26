package com.example.pandemicshootout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.donor.Availabledonors;

public class Plasma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plasma);

        EditText grp = findViewById(R.id.editTextTextPersonName4);
        EditText pin = findViewById(R.id.editTextNumber8);

        Button submit = findViewById(R.id.button5);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in= new Intent(Plasma.this, Availabledonors.class);
                in.putExtra("bloodGroup",grp.getText().toString());
                in.putExtra("pincode",pin.getText().toString());
                startActivity(in);
            }
        });
    }
    public void pd(View v)
    {
        Intent in= new Intent(Plasma.this, Availabledonors.class);
        startActivity(in);
    }
}