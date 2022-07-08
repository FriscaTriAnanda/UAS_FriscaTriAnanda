package com.frisca.uas.tugas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.frisca.uas.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        maps = googleMap;

        LatLng Rumah = new LatLng(-6.379601, 106.667797);
        maps.addMarker(new MarkerOptions().position(Rumah).title("Jl. Cendrawasih 15, Gunung Sindur, Bogor Regency, West Java 16340"));
        maps.setMaxZoomPreference(1000);
        maps.setMinZoomPreference(10);
        maps.moveCamera(CameraUpdateFactory.newLatLng(Rumah));

    }
}