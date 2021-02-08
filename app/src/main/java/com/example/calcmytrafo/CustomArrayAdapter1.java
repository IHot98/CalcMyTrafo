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


public class CustomArrayAdapter1 extends ArrayAdapter<Sekundar>{
    final private ArrayList<Sekundar> ResSekundari;
   final  private Context mContext;
    int mResource;

    public CustomArrayAdapter1(@NonNull Context context, int resource, ArrayList<Sekundar> resSekundari) {
        super(context, resource, resSekundari);
        ResSekundari = resSekundari;
        mContext=context;
        mResource=resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater =LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView SecondaryWindingNumber=(TextView) convertView.findViewById(R.id.txt_WindingNumber);
        TextView WindingVoltage=(TextView)convertView.findViewById(R.id.txt_WindingVoltage);
        TextView WindingCurrent=(TextView)convertView.findViewById(R.id.txt_WindingCurrent);
        TextView WindingTurns=(TextView)convertView.findViewById(R.id.txt_WindingTurns);
        TextView WireThickness=(TextView)convertView.findViewById(R.id.txt_WireThickness);
        TextView WireLenght=(TextView)convertView.findViewById(R.id.txt_WireLenght);

        SecondaryWindingNumber.setText(String.format("Secondary no.%s", (position + 1)));
        WindingVoltage.setText(String.format("%s %s V", mContext.getString(R.string.Volts), ResSekundari.get(position).getNapon()));
        WindingCurrent.setText(String.format("%s %s A", mContext.getString(R.string.Amps), ResSekundari.get(position).getStruja()));
        WindingTurns.setText(String.format("%s %s",mContext.getString(R.string.NumWind), ResSekundari.get(position).getBrojNamota()));
        WireThickness.setText(String.format("%s %s mm^2", mContext.getString(R.string.WireThick), ResSekundari.get(position).getDebljinaZice()));
        WireLenght.setText(" ");
        return convertView;
    }



}

