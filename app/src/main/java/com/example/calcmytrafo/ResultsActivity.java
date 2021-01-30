package com.example.calcmytrafo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity {

    public ArrayList<Sekundar> ResSekundari = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int i=0;i<MainActivity.ListSekundari.size();i++){
            if(!ResSekundari.isEmpty())
            ResSekundari.remove(i);

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView pv=(TextView)findViewById(R.id.PrimaryVoltage);
        TextView pc=(TextView)findViewById(R.id.PrimaryCurrent);
        TextView ca=(TextView)findViewById(R.id.CoreArea);
        TextView ef=(TextView)findViewById(R.id.Efficiency);
        TextView pt=(TextView)findViewById(R.id.PrimaryWindingTurns);
        TextView tp=(TextView)findViewById(R.id.TotalPower);
        TextView pwt=(TextView)findViewById(R.id.txt_PWireThickness);

        Intent intent = getIntent();
        float PrimaryVoltage = intent.getFloatExtra(MainActivity.EXTRA_PrimaryVoltage, 0);
        float PrimaryCurrent = intent.getFloatExtra(MainActivity.EXTRA_PrimaryCurrent, 0);
        float CoreArea = intent.getFloatExtra(MainActivity.EXTRA_CoreArea, 0);
        float Efficiency = intent.getFloatExtra(MainActivity.EXTRA_Efficiency, 0);
        float PrimaryTurns = intent.getFloatExtra(MainActivity.EXTRA_PrimaryTurns, 0);
        float TotalPower = intent.getFloatExtra(MainActivity.EXTRA_TotalOutputPower, 0);
        float PWireThickness = intent.getFloatExtra(MainActivity.EXTRA_PrimaryWireThickness, 0);

         pv.setText(String.format("%s%s V", getString(R.string.PVoltage), PrimaryVoltage));
         pc.setText(String.format("%s%s A", getString(R.string.PCurrent), PrimaryCurrent));
         ca.setText(String.format("%s%s cm^2", getString(R.string.CoreArea), CoreArea));
         ef.setText(String.format("%s%s", getString(R.string.EFF), Efficiency));
         pt.setText(String.format("%s%s", getString(R.string.PWinds), PrimaryTurns));
         tp.setText(String.format("%s%s W", getString(R.string.OutPower), TotalPower));
         pwt.setText(String.format("%s%s mm^2", getString(R.string.WireThick), PWireThickness));

        ResSekundari.addAll(MainActivity.ListSekundari);
         CustomArrayAdapter1 CustomAdapter = new CustomArrayAdapter1 (getApplicationContext(),R.layout.list_item,ResSekundari);

        ListView lv;
        lv = (ListView) findViewById(R.id.List_results);
        lv.setAdapter(CustomAdapter);

    }
}
