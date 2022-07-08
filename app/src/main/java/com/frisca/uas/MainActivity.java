package com.frisca.uas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.frisca.uas.tugas.Asynctask;
import com.frisca.uas.tugas.Kamera;
import com.frisca.uas.tugas.Maps;
import com.frisca.uas.tugas.SMS;

public class MainActivity extends AppCompatActivity {

    private CardView btnMaps, btnKamera, btnSms, btnAsynctask, btnFirebase, btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMaps = findViewById(R.id.btn_maps);
        btnKamera = findViewById(R.id.btn_kamera);
        btnSms = findViewById(R.id.btn_sms);
        btnAsynctask = findViewById(R.id.btn_asynctask);
        btnToast = findViewById(R.id.btn_toast);
        btnFirebase = findViewById(R.id.btn_firebase);

        btnAsynctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Asynctask.class));
            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"TERIMA KASIH PAK ATAS BIMBINGANNYA TETAP SEHAT PAK & PANJANG UMUR",Toast.LENGTH_LONG).show();
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SMS.class));
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Kamera.class));
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Maps.class));
            }
        });

        btnFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListViewActivity.ReadActivity.class));
            }
        });

    }
}