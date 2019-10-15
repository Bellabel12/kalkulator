package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_dua extends AppCompatActivity {

    private TextView txtviewday,txtviewmonth,txtviewyear,txtviewtime,hasil_esteh;
    private Button btnbatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        hasil_esteh = findViewById(R.id.hasil_esteh);

//        Time today = new Time(Time.getCurrentTimezone());
//        today.setToNow();
//        txtviewday.setText(today.monthDay + "");             // Day of the month (1-31)
//        txtviewmonth.setText(today.month + "");              // Month (0-11)iy
//        txtviewyear.setText(today.year + "");                // Year
//        txtviewtime.setText(today.format("%k:%M:%S"));  // Current time

        Intent i = getIntent();
        String jml_esteh = i.getStringExtra("jml");

        int total_esthe = Integer.parseInt(jml_esteh)*3000;
        hasil_esteh.setText(jml_esteh+" Es Teh "+jml_esteh+"x3000 "+total_esthe);
    }
}
