package com.example.daniel.convertapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Temperatura extends Activity implements View.OnClickListener {
    EditText etConvTemp;
    Spinner spinTemp1,spinTemp2;
    Button bConvTemp;
    TextView tvResTemp;
    Intent resultIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_temperatura);
        this.setUpUI();
    }
    private void setUpUI() {
        spinTemp1= (Spinner) findViewById(R.id.spinTemp1);
        spinTemp2= (Spinner) findViewById(R.id.spinTemp2);
        tvResTemp= (TextView) findViewById(R.id.tvResTemp);
        bConvTemp= (Button) findViewById(R.id.bConvTemp);
        etConvTemp= (EditText) findViewById(R.id.etConvTemp);
        bConvTemp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double Num1,Num2,Koef;
        String ConvFrom,ConvTo,ConvResult;


        Num1 = Double.parseDouble(etConvTemp.getText().toString());
        ConvFrom=spinTemp1.getSelectedItem().toString();
        ConvTo=spinTemp2.getSelectedItem().toString();

        Koef=getKoefTemp(ConvFrom,ConvTo,Num1);

        Num2=Koef;
        ConvResult=Double.toString(Num1)+ConvFrom+"="+Double.toString(Num2)+ConvTo;
        resultIntent=new Intent();
        resultIntent.setClass(getApplicationContext(),Result.class);
        resultIntent.putExtra("Result",ConvResult);
        resultIntent.putExtra("ResultTitle","Konverter temperature");
        startActivity(resultIntent);

    }

    private double getKoefTemp(String convFrom, String convTo,double Num1) {

        double Res=1;
        if(convFrom.equals("°C")){
            if(convTo.equals("°F"))
                Res=Num1*9/5+32;
            if(convTo.equals("K"))
                Res=Num1+273.15;
        }
        if(convFrom.equals("°F")){
            if(convTo.equals("°C"))
                Res=(Num1-32)*5/9;
            if(convTo.equals("K"))
                Res=((Num1-32)*5/9)+273.15;
        }
        if(convFrom.equals("K")){
            if(convTo.equals("°C"))
                Res=Num1-273.15;
            if(convTo.equals("°F"))
                Res=(Num1-273.15)*9/5+32;
        }
        return Res;
    }
}