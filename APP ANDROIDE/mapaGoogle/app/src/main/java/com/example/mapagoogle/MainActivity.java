package com.example.mapagoogle;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.security.Provider;
import java.text.SimpleDateFormat;

import static android.Manifest.permission_group.LOCATION;

public class MainActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {

    SupportMapFragment mapFragment;

    /**
     * Responsável por disponibilizar a localização do smartphone.smartphone
     */
    private GoogleApiClient mGoogleApiClient;

    /**
     * Guarda a ultima posição do smartphone.
     */
    private Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                iniciarMapa(googleMap);
            }
        });

        // Vamos instanciar o GoogleApiClient, caso seja nulo
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this) // Interface ConnectionCallbacks
                    .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this) //Interface OnConnectionFailedListener
                    .addApi(LOCATION) // Vamos a API do LocationServices
                    .build();
        }
    }
    /*
     * Ao iniciar, connectamos !
     */
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    /*
     * Ao finalizar, desconectamos!
     */
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    public void iniciarMapa(GoogleMap map) {
        //configure o tipo do mapa
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

//        //add a markeer
       LatLng fafica = new LatLng(-8.298635, -35.974063);

        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(fafica, 18);
        map.animateCamera(update);


           }



    @Override
    public void onMapClick(LatLng latLng) {

    }
}
