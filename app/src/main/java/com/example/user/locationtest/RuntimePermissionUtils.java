package com.example.user.locationtest;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by USER on 2017/10/12.
 */

public class RuntimePermissionUtils {
    public RuntimePermissionUtils() {

    }

    public static boolean hasSelfPermissions(Context context, String[] permissions) {
        boolean checkResult = true;

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        for(String permission: permissions) {
            if(context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                checkResult = false;
                break;
            }
        }

        return checkResult;
    }

    public static boolean checkGrantedResults(int[] grantResults) {
        boolean checkResult = true;

        if(grantResults.length == 0) {
            throw new IllegalArgumentException("GrantResult is empty");
        }

        for(int grantResult: grantResults) {
            if(grantResult != PackageManager.PERMISSION_GRANTED) {
                checkResult = false;
                break;
            }
        }

        return checkResult;
    }
}
