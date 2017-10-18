package com.example.user.locationtest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Created by USER on 2017/10/17.
 */

public class GetLastLocationButton extends Fragment {
    private FusedLocationProviderClient mFusedLocationProviderClient = null;

    private final static int MY_PERMISSION_REQUEST_ACCESS_COARSE_LOCATION = 10;
    private final static String[] usePermissions = {Manifest.permission.ACCESS_COARSE_LOCATION};

    private final int   LOCATION_GET_TIME_SEC = 10;
    private final int   LOCATION_GET_TIME_MILLI_SEC = LOCATION_GET_TIME_SEC * 1000;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.get_last_location_button, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkMyPermission();
    }

    private void showLocation() {
        if(ContextCompat.checkSelfPermission(getActivity(), usePermissions[0]) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getActivity(), "位置情報取得機能が許可されていません。", Toast.LENGTH_SHORT).show();
            return;
        }

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location == null) {
                    return;
                }
                double  latitude = location.getLatitude();
                double  longitude = location.getLongitude();

                TextView    tvLatitude = (TextView)getActivity().findViewById(R.id.latitude_data);
                TextView    tvLongitude = (TextView)getActivity().findViewById(R.id.longitude_data);

                tvLatitude.setText(String.valueOf(latitude));
                tvLongitude.setText(String.valueOf(longitude));
            }
        });
    }

    public void checkMyPermission() {
        if(ContextCompat.checkSelfPermission(getActivity(), usePermissions[0]) == PackageManager.PERMISSION_GRANTED) {
            showLocation();
            showLog("onViewCreated: 1");
            return;
        }

        if(shouldShowRequestPermissionRationale(usePermissions[0])) {
            showLog("onViewCreated: 2");

        } else {
            requestPermissions(usePermissions, MY_PERMISSION_REQUEST_ACCESS_COARSE_LOCATION);
            showLog("onViewCreated: 3");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != MY_PERMISSION_REQUEST_ACCESS_COARSE_LOCATION) {
            return;
        }

        if (grantResults.length <= 0) {
            return;
        }

        if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            showLog("onViewCreated: 4");
            return;
        }
        showLocation();
        showLog("onViewCreated: 5");
    }

    private void showLog(String msg) {
        Log.d("MY_APP", msg);
    }
}
