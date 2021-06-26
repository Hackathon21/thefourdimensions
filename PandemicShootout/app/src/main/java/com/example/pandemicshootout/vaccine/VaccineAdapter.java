package com.example.pandemicshootout.vaccine;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pandemicshootout.R;

import java.util.ArrayList;

public class VaccineAdapter extends ArrayAdapter<VaccineView> {
    public VaccineAdapter(@NonNull Activity context, ArrayList<VaccineView> medicineViewArrayList) {
        super(context, 0,medicineViewArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view,parent,false
            );
        }

        VaccineView vaccineView = getItem(position);

        TextView vaccineName=listItemView.findViewById(R.id.mn);
        TextView storeName=listItemView.findViewById(R.id.mn2);
        TextView price=listItemView.findViewById(R.id.mn3);
        TextView stock=listItemView.findViewById(R.id.mn4);

       vaccineName.setText("Center Name: "+vaccineView.getName());
        storeName.setText("Available: "+vaccineView.getAvailable_capacity());
        price.setText("Age Limit: "+String.valueOf(vaccineView.getAge_limit()));
        stock.setText("Vaccine: "+String.valueOf(vaccineView.getVaccine()));

        return listItemView;
    }
}
