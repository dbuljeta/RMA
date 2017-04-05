package com.example.daniel.convertapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageButton ibTemperatura,ibMasa,ibUdaljenost,ibBrzina;
    Intent converter=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        this.setUpUI();
    }

    private void setUpUI() {
        this.ibTemperatura= (ImageButton) findViewById(R.id.ib_temperatura);
        this.ibMasa= (ImageButton) findViewById(R.id.ib_masa);
        this.ibUdaljenost= (ImageButton) findViewById(R.id.ib_udaljenost);
        this.ibBrzina= (ImageButton) findViewById(R.id.ib_brzina);

        this.ibTemperatura.setOnClickListener(this);
        this.ibMasa.setOnClickListener(this);
        this.ibUdaljenost.setOnClickListener(this);
        this.ibBrzina.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
Intent converter=null;
        switch(v.getId())
        {
            case (R.id.ib_temperatura):
                converter=new Intent();
                converter.setClass(getApplicationContext(), Temperatura.class);
                this.startActivity(converter);

                break;
          case (R.id.ib_masa):
              converter=new Intent();
                converter.setClass(getApplicationContext(), Masa.class);

                this.startActivity(converter);

                break;
         case (R.id.ib_udaljenost):
             converter=new Intent();
                converter.setClass(getApplicationContext(), Udaljenost.class);
                this.startActivity(converter);
                break;
              case (R.id.ib_brzina):
                  converter=new Intent();
                converter.setClass(getApplicationContext(), Brzina.class);

                this.startActivity(converter);
                break;
        }
    }


}
