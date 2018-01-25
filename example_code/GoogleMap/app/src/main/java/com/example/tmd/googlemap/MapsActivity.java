package com.example.tmd.googlemap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.tmd.googlemap.SavedPlaces.CustomInfoAdapter;
import com.example.tmd.googlemap.SavedPlaces.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Intent mIntent = null;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        addControls();
    }

    private void addControls() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_full_screen);
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

        showNotifyLoading();

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            // khi map được load xong thì mới thực hiện các chức năng (zoom,...)
            @Override
            public void onMapLoaded() {
                mProgressDialog.dismiss();
                mIntent = getIntent();
                Place place = (Place) mIntent.getSerializableExtra("PLACE");
                if (place == null) {// nếu không có place truyền vào thì zoom vị trí mặc định
                    // Add a marker in Sydney and move the camera
                    LatLng sydney = new LatLng(-34, 151);
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                } else {
                    LatLng placeLatLng = new LatLng(place.getLat(), place.getLng());
                    Marker marker = mMap.addMarker(new MarkerOptions().position(placeLatLng).title(place.getName()));

                    mMap.setInfoWindowAdapter(new CustomInfoAdapter(MapsActivity.this, place));
                    marker.showInfoWindow();
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLatLng, 15));
                }
            }
        });

    }

    private void showNotifyLoading() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Thông báo");
        mProgressDialog.setMessage("Đang tải dữ liệu, vui lòng chờ trong ít phút");
        mProgressDialog.show();
    }
}
