package com.example.daniel.convertapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Brzina extends Activity implements View.OnClickListener {
    EditText etConvBrzina;
    Spinner spinBrzina1,spinBrzina2;
    Button bConvBrzina;
    TextView tvResBrz;
    Intent resultIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_brzina);
        this.setUpUI();
    }

    private void setUpUI() {
        spinBrzina1= (Spinner) findViewById(R.id.spinBrzina1);
        spinBrzina2= (Spinner) findViewById(R.id.spinBrzina2);
        tvResBrz= (TextView) findViewById(R.id.tvResBrz);
        etConvBrzina= (EditText) findViewById(R.id.etConvBrzina);
        bConvBrzina= (Button) findViewById(R.id.bConvBrzina);
        bConvBrzina.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double Num1,Num2,Koef;
        String ConvFrom,ConvTo,ConvResult;


        Num1 = Double.parseDouble(etConvBrzina.getText().toString());
        ConvFrom=spinBrzina1.getSelectedItem().toString();
        ConvTo=spinBrzina2.getSelectedItem().toString();

        Koef=getKoefBrz(ConvFrom,ConvTo);

        Num2=Num1*(Koef);
        ConvResult=Double.toString(Num1)+ConvFrom+"="+Double.toString(Num2)+ConvTo;
        resultIntent=new Intent();
        resultIntent.setClass(getApplicationContext(),Result.class);
        resultIntent.putExtra("Result",ConvResult);
        resultIntent.putExtra("ResultTitle","Konverter brzine");
        startActivity(resultIntent);


    }

    private double getKoefBrz(String convFrom, String convTo) {
        double Res=1;
        if(convFrom.equals("km/h")){
            if(convTo.equals("m/s"))
                Res=(double)1000/3600;
            if(convTo.equals("miles/h"))
                Res=(double)1/1.61;
        }
        if(convFrom.equals("m/s")){
            if(convTo.equals("km/h"))
                Res=3.6;
            if(convTo.equals("miles/h"))
                Res=(3.6*(1/1.61));
        }
        if(convFrom.equals("miles/h")){
            if(convTo.equals("m/s"))
                Res=(1.61*(1000/3600));
            if(convTo.equals("km/h"))
                Res=1.61;
        }
        return Res;
    }
}
