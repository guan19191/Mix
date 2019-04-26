package com.fly.mix.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by jady on 2017/2/6.
 */
public class NetworkUtils {
    public static boolean isNetworkConnected(Context context) {
        try {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager != null ? mConnectivityManager.getActiveNetworkInfo() : null;
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}