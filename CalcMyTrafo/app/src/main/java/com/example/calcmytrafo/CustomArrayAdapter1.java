package com.example.calcmytrafo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter1 extends ArrayAdapter<Sekundar>{
    private ArrayList<Sekundar> ResSekundari;
    private Context mContext;
    int mResource;

    public CustomArrayAdapter1(@NonNull Context context, int resource, ArrayList<Sekundar> resSekundari) {
        super(context, resource, resSekundari);
        ResSekundari = resSekundari;
        mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         float Napon=getItem(position).getNapon();
         float Struja=getItem(position).getStruja();
         float BrojNamota=getItem(position).getBrojNamota();
        Sekundar sekundar=new Sekundar(Napon,Struja,BrojNamota);

        LayoutInflater inflater =LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView SecondaryWindingNumber=(TextView) convertView.findViewById(R.id.txt_WindingNumber);
        TextView WindingVoltage=(TextView)convertView.findViewById(R.id.txt_WindingVoltage);
        TextView WindingCurrent=(TextView)convertView.findViewById(R.id.txt_WindingCurrent);
        TextView WindingTurns=(TextView)convertView.findViewById(R.id.txt_WindingTurns);
        TextView WireThickness=(TextView)convertView.findViewById(R.id.txt_WireThickness);
        TextView WireLenght=(TextView)convertView.findViewById(R.id.txt_WireLenght);

        SecondaryWindingNumber.setText("Secondary no."+String.valueOf(position+1));
        WindingVoltage.setText(String.valueOf(ResSekundari.get(position).getNapon()));
        WindingCurrent.setText(String.valueOf(ResSekundari.get(position).getStruja()));
        WindingTurns.setText(String.valueOf(ResSekundari.get(position).getBrojNamota()));
        WireThickness.setText("debljina žice");
        WireLenght.setText("Duljina žice");
        return convertView;
    }



 /*@NonNull
    @Override
   /* public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        TextView SecondaryWindingNumber=convertView.findViewById(R.id.txt_WindingNumber);
        TextView WindingVoltage=convertView.findViewById(R.id.txt_WindingVoltage);
        TextView WindingCurrent=convertView.findViewById(R.id.txt_WindingCurrent);
        TextView WindingTurns=convertView.findViewById(R.id.txt_WindingTurns);
        TextView WireThickness=convertView.findViewById(R.id.txt_WireThickness);
        TextView WireLenght=convertView.findViewById(R.id.txt_WireLenght);

         SecondaryWindingNumber.setText("Secondary no."+String.valueOf(position));
         WindingVoltage.setText(String.valueOf(ResSekundari.get(position).getNapon()));
         WindingCurrent.setText(String.valueOf(ResSekundari.get(position).getStruja()));
         WindingTurns.setText(String.valueOf(ResSekundari.get(position).getBrojNamota()));
         WireThickness.setText("debljina žice");
         WireLenght.setText("Duljina žice");

        return convertView;
    }*/

}

