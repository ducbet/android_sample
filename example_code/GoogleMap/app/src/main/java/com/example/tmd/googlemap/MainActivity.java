package com.example.tmd.googlemap;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NONE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_TERRAIN;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ArrayList<String> mListMapType;
    private ArrayAdapter<String> mAdapterMapType;
    private Spinner mSpnMapType;

    private ProgressDialog mProgressDialog;

    private LatLng myLocation = null;
    private boolean needShowMyLocation = true;

    private GoogleMap.OnMyLocationChangeListener mMyLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            // Hàm này được gọi liên tục
            // Nên dùng 1 biến needShowMyLocation, khi nào cần zoom mới đặt = true

            myLocation = new LatLng(location.getLatitude(), location.getLongitude());
            Toast.makeText(MainActivity.this, "myLocation: " + location.getLatitude() + ", " + location.getLongitude(), Toast.LENGTH_SHORT).show();
            zoomInMyPositonAutomaticly();

        }
    };

    private void zoomInMyPositonAutomaticly() {
        if (mMap != null && needShowMyLocation) {
            mMap.clear();// xóa hết các marker khác
            mMap.addMarker(new MarkerOptions().
                    position(myLocation).
                    title("My Location").
                    snippet("I'm here"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 17));// 0-18
            needShowMyLocation = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }


    private void addEvents() {
        mSpnMapType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeMapType(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void changeMapType(int position) {
        switch (position) {
            case 0:
                mMap.setMapType(MAP_TYPE_NORMAL);
                break;
            case 1:
                mMap.setMapType(MAP_TYPE_SATELLITE);
                break;
            case 2:
                mMap.setMapType(MAP_TYPE_TERRAIN);
                break;
            case 3:
                mMap.setMapType(MAP_TYPE_HYBRID);
                break;
            default:
                mMap.setMapType(MAP_TYPE_NONE);
                break;
        }
    }

    private void addControls() {
        // Map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Spinner
        mSpnMapType = (Spinner) findViewById(R.id.spinner_choose_map_types);
        mAdapterMapType = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                Arrays.asList(getResources().getStringArray(R.array.map_types))
        );
        mAdapterMapType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnMapType.setAdapter(mAdapterMapType);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        showNotifyLoading();

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            // khi map được load xong thì mới thực hiện các chức năng (zoom,...)
            @Override
            public void onMapLoaded() {
                mProgressDialog.dismiss();

                // hiện vị trí thủ công:
//                LatLng home = new LatLng(21.044564, 105.851230);
//                mMap.addMarker(new MarkerOptions().
//                        position(home).
//                        title("My house").
//                        snippet("Nhà Đức"));
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 13));// 0-18

                // hiện vị trí hiện tại tự động:
                getMyLocation();
            }
        });

    }

    private void getMyLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationChangeListener(mMyLocationChangeListener);
    }


    private void showNotifyLoading() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Thông báo");
        mProgressDialog.setMessage("Đang tải dữ liệu, vui lòng chờ trong ít phút");
        mProgressDialog.show();
    }
}
