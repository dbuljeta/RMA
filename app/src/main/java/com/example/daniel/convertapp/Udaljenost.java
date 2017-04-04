package com.example.daniel.convertapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Udaljenost extends Activity implements View.OnClickListener {
    Spinner spinner1,spinner2;
    Button bConvert;
    TextView pokazi;
    EditText etConvUdaljenost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udaljenost);
        setUpUI();
    }
    private void setUpUI() {
        spinner1= (Spinner) findViewById(R.id.spinner1);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        bConvert= (Button) findViewById(R.id.bConvUdaljenost);
        etConvUdaljenost= (EditText) findViewById(R.id.etConvUdaljenost);
        pokazi= (TextView) findViewById(R.id.tvdaj);
        bConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double Num1,Num2,Koef;
        String ConvFrom,ConvTo,ConvResult;


        Num1 = Double.parseDouble(etConvUdaljenost.getText().toString());
        ConvFrom=spinner1.getSelectedItem().toString();
        ConvTo=spinner2.getSelectedItem().toString();

        Koef=getKoefUdalj(ConvFrom,ConvTo);

        Num2=Num1*(Koef);
        ConvResult=Double.toString(Num1)+ConvFrom+"="+Double.toString(Num2)+ConvTo;


        //Intent convertResult=new Intent();
       // convertResult.setClass(getApplicationContext(),ConvertResult.class);
        pokazi.setText(ConvResult);

       // this.startActivity(convertResult);

    }

    public double getKoefUdalj(String convFrom, String convTo) {

        double res=1;

        if( convFrom.equals("km")){
            if(convTo.equals("m"))
                res= 1000;
            if(convTo.equals("dm"))
                res=1000*10;
            if(convTo.equals("cm"))
                res=1000*1000;
            if(convTo.equals("mm"))
                res=10000*10;}
        if( convFrom.equals("m")){
            if(convTo.equals("km"))
                res= (double)1/1000;
            if(convTo.equals("dm"))
                res=10;
            if(convTo.equals("cm"))
                res=100;
            if(convTo.equals("mm"))
                res=100*10;}
        if( convFrom.equals("dm")){
            if(convTo.equals("km"))
                res= (double)1/(10*1000);
            if(convTo.equals("m"))
                res=(double)1/10;
            if(convTo.equals("cm"))
                res=10;
            if(convTo.equals("mm"))
                res=10*10;}
        if( convFrom.equals("cm")){
            if(convTo.equals("km"))
                res= (double)1/(100*1000);
            if(convTo.equals("dm"))
                res=(double)1/10;
            if(convTo.equals("m"))
                res=(double)1/100;
            if(convTo.equals("mm"))
                res=10;}
        if(convFrom.equals("mm")){
            if(convTo.equals("km"))
                res= (double)1/(10*100*1000);
            if(convTo.equals("dm"))
                res=(double)1/(10*10);
            if(convTo.equals("cm"))
                res=(double)1/10;
            if(convTo.equals("m"))
                res=(double)1/(10*100);
        }
        return res;}
}