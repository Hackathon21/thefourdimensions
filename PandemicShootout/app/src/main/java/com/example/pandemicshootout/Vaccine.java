package com.example.pandemicshootout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pandemicshootout.vaccine.Available_vaccine;

import java.util.Calendar;

public class Vaccine extends AppCompatActivity {
    DatePickerDialog picker;
    EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
       date=findViewById(R.id.editText1);
        date.setInputType(InputType.TYPE_NULL);

        EditText pin = findViewById(R.id.editTextTextPersonName2);
        Button submit = findViewById(R.id.button3);

        int day2,month2,year2;
       date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Vaccine.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent in=new Intent(Vaccine.this, Available_vaccine.class);
               String k[] = date.getText().toString().split("/");
               in.putExtra("pincode",pin.getText().toString());
               in.putExtra("date",k);
               startActivity(in);
           }
       });

    }
}