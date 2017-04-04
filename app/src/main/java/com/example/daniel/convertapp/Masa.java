package com.example.daniel.convertapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Masa extends Activity implements View.OnClickListener {
    EditText etConvMasa= (EditText) findViewById(R.id.etConvMasa);
    Spinner spinMasa1,spinMasa2;
    Button bConvMasa= (Button) findViewById(R.id.bConvMasa);
    TextView tvResBrz= (TextView) findViewById(R.id.tvResMas);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa);
       this.setUpUI();
    }
    private void setUpUI() {
        spinMasa1= (Spinner) findViewById(R.id.spinMasa1);
        spinMasa2= (Spinner) findViewById(R.id.spinMasa2);
        bConvMasa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double Num1,Num2,Koef;
        String ConvFrom,ConvTo,ConvResult;


        Num1 = Double.parseDouble(etConvMasa.getText().toString());
        ConvFrom=spinMasa1.getSelectedItem().toString();
        ConvTo=spinMasa2.getSelectedItem().toString();

        Koef=getKoefMas(ConvFrom,ConvTo);

        Num2=Num1*(Koef);
        ConvResult=Double.toString(Num1)+ConvFrom+"="+Double.toString(Num2)+ConvTo;
        tvResBrz.setText(ConvResult);

    }

    private double getKoefMas(String convFrom, String convTo) {

        double Res=1;
        if(convFrom.equals("t")){
            if(convTo.equals("kg"))
                Res=(double)1000;
            if(convTo.equals("gr"))
                Res=(double)1000*1000;
        }
        if(convFrom.equals("kg")){
            if(convTo.equals("t"))
                Res=(double)1/1000;
            if(convTo.equals("gr"))
                Res=(double)1000;
        }
        if(convFrom.equals("gr")){
            if(convTo.equals("t"))
                Res=(double)1/(1000*1000);
            if(convTo.equals("kg"))
                Res=(double)1/1000;
        }
        return Res;
    }
}
