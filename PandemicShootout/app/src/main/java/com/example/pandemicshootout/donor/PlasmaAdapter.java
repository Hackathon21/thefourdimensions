package com.example.pandemicshootout.donor;

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

public class PlasmaAdapter extends ArrayAdapter<PlasmaView> {
    public PlasmaAdapter(@NonNull Activity context, ArrayList<PlasmaView> plasmaViewArrayList) {
        super(context, 0,plasmaViewArrayList);
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

        PlasmaView plasmaView = getItem(position);

        TextView medicineName=listItemView.findViewById(R.id.mn);
        TextView storeName=listItemView.findViewById(R.id.mn2);
        TextView price=listItemView.findViewById(R.id.mn3);
        TextView stock=listItemView.findViewById(R.id.mn4);

        medicineName.setText("Name: "+plasmaView.getName());
        storeName.setText("Blood Group: "+plasmaView.getBloodGroup());
        price.setText("Pincode: "+String.valueOf(plasmaView.getPincode()));
        stock.setText("Phone Number: "+String.valueOf(plasmaView.getPhoneNumber()));

        return listItemView;
    }
}
