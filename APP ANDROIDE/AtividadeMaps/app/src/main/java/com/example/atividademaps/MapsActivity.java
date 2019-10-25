package com.example.atividademaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {

    public SupportMapFragment mapFragment;

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                iniciarMapa(googleMap);
            }
        });
    }

    private void iniciarMapa(GoogleMap map) {
// Configura o tipo do mapa
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
// Add a marker
        LatLng fafica = new LatLng(-8.298635, -35.974063);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(fafica,18);
       // map.animateCamera(update);
        map.animateCamera(update, 10*1000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Mapa chegou ao ponto desejado", Toast.LENGTH_LONG).show();
            } @
                    Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Animação cancelada", Toast.LENGTH_LONG).show();
            }
        });
    }
}
