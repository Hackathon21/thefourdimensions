package com.example.pandemicshootout.medicine;

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

public class MedicineAdapter extends ArrayAdapter<MedicineView> {
    public MedicineAdapter(@NonNull Activity context, ArrayList<MedicineView> medicineViewArrayList) {
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

        MedicineView medicineView = getItem(position);

        TextView medicineName=listItemView.findViewById(R.id.mn);
        TextView storeName=listItemView.findViewById(R.id.mn2);
        TextView price=listItemView.findViewById(R.id.mn3);
        TextView stock=listItemView.findViewById(R.id.mn4);

        medicineName.setText("Medicine Name: "+medicineView.getName());
        storeName.setText("Store Name: "+medicineView.getStoreName());
        price.setText("Price: "+String.valueOf(medicineView.getPrice()));
        stock.setText("Stock: "+String.valueOf(medicineView.getStock()));

        return listItemView;
    }
}
