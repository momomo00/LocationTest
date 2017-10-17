package com.example.user.locationtest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient mFusedLocationProviderClient;

    private final static int MY_PERMISSION_REQUEST_ACCESS_COARSE_LOCATION = 10;
    private final static String[] usePermissions = {Manifest.permission.ACCESS_COARSE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(RuntimePermissionUtils.hasSelfPermissions(this, usePermissions)) {
//            showLastLocation();
//        } else {
//            ActivityCompat.requestPermissions(this
//                    , usePermissions
//                    , MY_PERMISSION_REQUEST_ACCESS_COARSE_LOCATION);
//        }
    }

//    private void showLastLocation() {
////        int checkPermissionResult = ContextCompat.checkSelfPermission(this, usePermissions[0]);
////
////        if(checkPermissionResult != PackageManager.PERMISSION_GRANTED) {
////            return;
////        }
////        PermissionChecker.checkPermission(this, )
//        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//
//            }
//        });
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch(requestCode) {
//            case MY_PERMISSION_REQUEST_ACCESS_COARSE_LOCATION:
//                if(permissions.length <= 0) {
//                    break;
//                }
//
//                if(RuntimePermissionUtils.checkGrantedResults(grantResults)) {
//
//                } else {
//                    Toast.makeText(this, "権限内です", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            default:
//                break;
//        }
//    }
}
