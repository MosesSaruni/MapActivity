package com.example.mapapplication1;

import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.mapapplication1.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//import static com.google.maps.android.MathUtil.*;
import com.google.maps.android.SphericalUtil;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

//    public void distance_two_cities(LatLng a, LatLng b){
//
//        double distance = SphericalUtil.computeDistanceBetween(a.getPosition(), b.getPosition());
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng muscat = new LatLng(23.5880, 58.3829);
        mMap.addMarker(new MarkerOptions().position(muscat).title("Marker in Muscat"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng nairobi = new LatLng(-1.2921, 36.8219);
        mMap.addMarker(new MarkerOptions().position(nairobi).title("Marker in Nairobi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nairobi));

        LatLng kabul = new LatLng(35.5553, 69.2075);
        mMap.addMarker(new MarkerOptions().position(kabul).title("Marker in Kabul"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(kabul));

        String template = "Distance 1 between %s and %s is %s KM";
        String loc1 = "Nairobi";
        String loc2 = "Kabul";

        float[] result = new float[1];
        Location.distanceBetween(nairobi.latitude, nairobi.longitude, kabul.latitude, kabul.longitude, result);
        String dist = String.valueOf((result[0])/1000);
        String msg = String.format(template, loc1, loc2 ,dist);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

//    public void distance_two_cities(LatLng a, LatLng b){
//        double distance = SphericalUtil.computeDistanceBetween(a.getPosition(), b.getPosition());
//    }
}