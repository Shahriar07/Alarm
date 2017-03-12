package com.shahriar.hasan.officealarm.Manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by USER on 3/12/2017.
 */


public class SharedPreferenceManager {

    public static final String ALARM_KEY = "ALARM_KEY";

    public static void setAlarmId(Context context, int index, int id){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(ALARM_KEY + index, id);
        editor.commit();
    }

    public static int getAlarmId(Context context, int index){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPref.getInt(ALARM_KEY + index,-1);
    }

}
