package com.example.daniel.convertapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Result extends Activity {
TextView tvResResult,tvResultTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result);
        this.setUpUI();
    }

    private void setUpUI() {
        tvResResult= (TextView) findViewById(R.id.tvResResult);
        tvResultTitle= (TextView) findViewById(R.id.tvResResultTitle);
        Bundle extras = getIntent().getExtras();
        String Result=extras.getString("Result");
        String ResultTitle=extras.getString("ResultTitle");
        tvResResult.setText(Result);
        tvResultTitle.setText(ResultTitle);
    }
}
