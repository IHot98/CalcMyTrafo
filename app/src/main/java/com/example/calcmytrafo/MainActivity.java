package com.example.calcmytrafo;


import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import static java.lang.Math.sqrt;

public class MainActivity extends Activity {


    Button Addbutton;
    Button Delbutton;
    Button Calcbutton;
    EditText GetUlazniNapon;
    EditText GetNapon;
    EditText GetStruja;
    EditText GetFrequency;

 public static  ArrayList<Sekundar> ListSekundari = new ArrayList<>();
    public static final String EXTRA_PrimaryVoltage="com.example.calcmytrafo.EXTRA_PrimaryVoltage";
    public static final String EXTRA_PrimaryCurrent="com.example.calcmytrafo.EXTRA_PrimaryCurrent";
    public static final String EXTRA_CoreArea="com.example.calcmytrafo.EXTRA_CoreArea";
    public static final String EXTRA_Efficiency="com.example.calcmytrafo.EXTRA_Efficiency";
    public static final String EXTRA_PrimaryTurns="com.example.calcmytrafo.EXTRA_PrimaryTurns";
    public static final String EXTRA_TotalOutputPower="com.example.calcmytrafo.EXTRA_TotalOutputPower";
    public static final String EXTRA_PrimaryWireThickness="com.example.calcmytrafo.EXTRA_PrimaryWireThickness";

    double CoreArea=0;
    float TotalOutputPower=0;
    float TurnsPerVolt=0;
    float FluxDensity=1;
    float PrimaryCurrent=0;
    double Efficiency=0.85;
    float PrimaryTurns=0;
    float CurrentDensity=2;//Amps per square milimeter
    float PrimaryWireThickness=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Addbutton = (Button) findViewById(R.id.btn_plus);
        Delbutton = (Button) findViewById(R.id.btn_delete);
        Calcbutton = (Button) findViewById(R.id.btn_calc);
        GetNapon = (EditText)findViewById(R.id.edt_napon);
        GetStruja = (EditText)findViewById(R.id.edt_struja);
        GetFrequency = (EditText)findViewById(R.id.edt_frequency);
        GetUlazniNapon = (EditText)findViewById(R.id.edt_UlazniNapon);


        CustomArrayAdapter2 CustomAdapter2 = new CustomArrayAdapter2 (getApplicationContext(),R.layout.items,ListSekundari);

        ListView lv2= (ListView) findViewById(R.id.listView1);
        lv2.setAdapter(CustomAdapter2);


        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ListSekundari.add(new Sekundar(Float.parseFloat(GetNapon.getText().toString()),Float.parseFloat(GetStruja.getText().toString())));
                CustomAdapter2.notifyDataSetChanged();

            }
        });
        Delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=ListSekundari.size()-1;
                if( i>=0){

                    ListSekundari.remove(i);
                    CustomAdapter2.notifyDataSetChanged();
                }

            }
        });
        Calcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {CoreArea=0;
                 TotalOutputPower=0;
                 TurnsPerVolt=0;
                 FluxDensity=1;
                 PrimaryCurrent=0;
                 Efficiency=0.85;
                 PrimaryTurns=0;}
                Log.d("AAAOutputPower", "start");

                for(int i=0;i<ListSekundari.size();i++) { TotalOutputPower = TotalOutputPower+ ListSekundari.get(i).getNapon() * ListSekundari.get(i).getStruja(); }

                CoreArea =1.152 * sqrt(TotalOutputPower);// cm^2
                TurnsPerVolt = 1/ ((float)4.44*(float)0.0001*Float.parseFloat(GetFrequency.getText().toString()) *(float)CoreArea *FluxDensity);
                PrimaryTurns=TurnsPerVolt*Float.parseFloat(GetUlazniNapon.getText().toString());
                PrimaryCurrent=TotalOutputPower/Float.parseFloat(GetUlazniNapon.getText().toString())*(float)Efficiency;
                PrimaryWireThickness=PrimaryCurrent/CurrentDensity;



                {
                    Log.d("AAAOutputPower", String.valueOf(TotalOutputPower));
                    Log.d("AAACoreArea", String.valueOf(CoreArea));
                    Log.d("AAATurnsPerVolt", String.valueOf(TurnsPerVolt));
                    Log.d("AAAPrimaryTurns", String.valueOf(PrimaryTurns));
                    Log.d("AAAPrimaryCurrent", String.valueOf(PrimaryCurrent));
                    Log.d("AAAbrsekundara", "brsekundara= " + ListSekundari.size());
                }

                for(int i=0;i<ListSekundari.size();i++) {
                    Log.d("AAAPrimaryCurrent", String.valueOf(i));
                    ListSekundari.get(i).setBrojNamota((float)1.03* (TurnsPerVolt *ListSekundari.get(i).getNapon()));
                    ListSekundari.get(i).setDebljinaZice(ListSekundari.get(i).getStruja()/CurrentDensity);
                    Log.d("AAASekundari", "napon= "+ListSekundari.get(i).getNapon()+ ", struja= "+ListSekundari.get(i).getStruja()+", brNamota="+ListSekundari.get(i).getBrojNamota());
                }

                OpenResultsActivity();




            }
        });
    }
    public void OpenResultsActivity(){
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra(EXTRA_PrimaryVoltage,Float.parseFloat(GetUlazniNapon.getText().toString()));
        intent.putExtra(EXTRA_PrimaryCurrent,PrimaryCurrent);
        intent.putExtra(EXTRA_PrimaryTurns,PrimaryTurns);
        intent.putExtra(EXTRA_CoreArea,(float)CoreArea);
        intent.putExtra(EXTRA_TotalOutputPower,(float)TotalOutputPower);
        intent.putExtra(EXTRA_PrimaryWireThickness,PrimaryWireThickness);

        intent.putExtra(EXTRA_Efficiency,(float)Efficiency);

        startActivity(intent);
    }
}