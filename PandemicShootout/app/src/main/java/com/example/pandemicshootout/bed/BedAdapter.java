package com.example.pandemicshootout.bed;

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

public class BedAdapter extends ArrayAdapter<BedView> {
    public BedAdapter(@NonNull Activity context, ArrayList<BedView> bedViewArrayList) {
        super(context, 0,bedViewArrayList);
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

        BedView bedView = getItem(position);

        TextView medicineName=listItemView.findViewById(R.id.mn);
        TextView storeName=listItemView.findViewById(R.id.mn2);
        TextView price=listItemView.findViewById(R.id.mn3);
        TextView stock=listItemView.findViewById(R.id.mn4);
        stock.setVisibility(View.GONE);

        medicineName.setText("Name: "+bedView.getName());
        storeName.setText("Blood Group: "+bedView.getContact());
        price.setText("Pincode: "+String.valueOf(bedView.getBeds()));

        return listItemView;
    }
}
