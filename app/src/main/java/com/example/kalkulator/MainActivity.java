package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnteh,btnjeruk,btnpecel,btnrawon,btnbyr,btnbtl;
    int jmlesteh = 0,jmlesjeruk,jmlpecel,jmlrawon = 0,jmlbayar;
    private TextView textharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnteh=(Button)findViewById(R.id.btnesteh);
        btnjeruk=(Button)findViewById(R.id.btnesjeruk);
        btnpecel=(Button)findViewById(R.id.btnnasipecel);
        btnrawon=(Button)findViewById(R.id.btnnasirawon);
        btnbyr= (Button)findViewById(R.id.btnbayar);
        btnbtl=(Button)findViewById(R.id.btnbatal);
        textharga=(TextView)findViewById(R.id.txtjmlbarang);

        btnteh.setOnClickListener(this);

        btnjeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlesjeruk++;
                btnjeruk.setText("Es Jeruk ("+jmlesjeruk+")");
                jmlbayar=jmlesteh*3000+jmlesjeruk*4000+jmlpecel*10000+jmlrawon*12000;
                textharga.setText(""+jmlbayar);
            }
        });

        btnpecel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jmlpecel++;
                btnpecel.setText("Nasi Pecel ("+jmlpecel+")");
                jmlbayar=jmlesteh*3000+jmlesjeruk*4000+jmlpecel*10000+jmlrawon*12000;
                textharga.setText(""+jmlbayar);
            }
        });

        btnrawon.setOnClickListener(this);

        btnbyr.setOnClickListener(this);

        btnbtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,activity_dua.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == btnteh){
            jmlesteh++;
            btnteh.setText("Es Teh ("+jmlesteh+")");
            jmlbayar=jmlesteh*3000+jmlesjeruk*4000+jmlpecel*10000+jmlrawon*12000;
            textharga.setText(""+jmlbayar);
        }else if(view == btnbyr){
            Intent i = new Intent(MainActivity.this,activity_dua.class);
            i.putExtra("jml_teh", jmlesteh+"");
            i.putExtra("jml_rawon", jmlrawon+"");
            startActivity(i);
        }else if(view == btnrawon){
            jmlrawon++;
            btnrawon.setText("Nasi Rawon ("+jmlrawon+")");
            jmlbayar=jmlesteh*3000+jmlesjeruk*4000+jmlpecel*10000+jmlrawon*12000;
            textharga.setText(""+jmlbayar);
        }
    }
}
