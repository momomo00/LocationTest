package com.example.user.locationtest;

import android.Manifest;
import android.content.Context;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Created by USER on 2017/10/17.
 */

public class MyLocation {
    private Context mContext = null;
    private FusedLocationProviderClient mFusedLocationProviderClient = null;

    private final static int MY_PERMISSION_REQUEST_ACCESS_COARSE_LOCATION = 10;
    private final static String[] usePermissions = {Manifest.permission.ACCESS_COARSE_LOCATION};


    public MyLocation(Context context) {
        mContext = context;
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext);
    }

    public void showLastKnownLocation() {
        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location == null) {
                    return;
                }

            }
        });
    }
}
