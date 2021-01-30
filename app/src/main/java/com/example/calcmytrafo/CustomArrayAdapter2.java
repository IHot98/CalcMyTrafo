package com.example.calcmytrafo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CustomArrayAdapter2 extends ArrayAdapter<Sekundar>{
   final private ArrayList<Sekundar> ResSecondary;
   final private Context mContext;
    int mResource;

    public CustomArrayAdapter2(@NonNull Context context, int resource, ArrayList<Sekundar> resSecondary) {
        super(context, resource, resSecondary);
        ResSecondary = resSecondary;
        mContext=context;
        mResource=resource;
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView WindingVoltage=(TextView)convertView.findViewById(R.id.txt_list_Napon);
        TextView WindingCurrent=(TextView)convertView.findViewById(R.id.txt_list_Struja);



        WindingVoltage.setText(String.format("%s %s V", mContext.getString(R.string.Volts), ResSecondary.get(position).getNapon()));
        WindingCurrent.setText(String.format("%s %s A", mContext.getString(R.string.Amps), ResSecondary.get(position).getStruja()));

        return convertView;
    }
}

