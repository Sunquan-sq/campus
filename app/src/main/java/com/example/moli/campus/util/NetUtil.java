package com.example.moli.campus.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by moli on 2019/10/4.
 * 功能：检查当前手机网络
 */

public class NetUtil {
    public static boolean checkNet(Context context) {
        // 判断连接方式
        boolean wifiConnected = isWIFIConnected(context);
        boolean mobileConnected = isMOBILEConnected(context);
        if (wifiConnected == false && mobileConnected == false) {
            // 如果都没有连接返回false，提示用户当前没有网络
            return false;
        }
        return true;
    }

    // 判断手机使用是wifi还是mobile
    /**
     * 判断手机是否采用wifi连接
     */
    public static boolean isWIFIConnected(Context context) {
        // Context.CONNECTIVITY_SERVICE).

        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isMOBILEConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

}
