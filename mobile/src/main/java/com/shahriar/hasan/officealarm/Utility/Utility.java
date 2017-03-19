package com.shahriar.hasan.officealarm.Utility;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.Calendar;

public class Utility{

    public static final String TAG = "com.shahriar.hasan.wifi";
    public static long getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        return  calendar.getTimeInMillis();
    }

    public static void stopWifi(Context context){
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if(wifiManager.setWifiEnabled(false)){
            Log.d(TAG, "Wifi disabled ");
        }
    }
}