package com.shahriar.hasan.officealarm.Manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.shahriar.hasan.officealarm.Receiver.AlarmReceiver;
import com.shahriar.hasan.officealarm.Utility.Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by USER on 3/12/2017.
 */

public class AlarmTimeManager {

    public static final int ALARM_ID = 1910;
    public static final String ALARM_INDEX = "ALARM_INDEX";
    private static AlarmTimeManager alarmTimeManagerInstance = null;
    int hourArray[] = {2, 4,10, 14};


    AlarmManager alarmManager;
    Context context;

    private AlarmTimeManager(Context context){
        this.context = context;
        alarmManager = (AlarmManager) context.getApplicationContext().getSystemService(ALARM_SERVICE);
    }

    public static AlarmTimeManager getAlarmTimeManagerInstance(Context context){
        if (alarmTimeManagerInstance == null){
            synchronized (AlarmTimeManager.class){
                alarmTimeManagerInstance = new AlarmTimeManager(context);
            }
        }
        return alarmTimeManagerInstance;
    }

    public  void setAlarm (int index, boolean isTomorrow){
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis();
        calendar.set(Calendar.HOUR_OF_DAY, hourArray[index]);
        long time = calendar.getTimeInMillis();
        Log.d(Utility.TAG, "Current time " + currentTime + " requested time " + time);
        if (isTomorrow || (time < currentTime)) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            time = calendar.getTimeInMillis();
            Log.d(Utility.TAG, "Current time " + currentTime + " Updated requested time " + time);
        }
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String tomorrowAsString = dateFormat.format(tomorrow);
        Log.d(Utility.TAG, "Set alarm for index " + index + " With time " + tomorrowAsString);
        SharedPreferenceManager.setAlarmId(context,index,ALARM_ID+index);
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        alarmIntent.putExtra(ALARM_INDEX,index);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ALARM_ID + index, alarmIntent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
    }

    public  void cancelAlarm (int index){
        Log.d(Utility.TAG, "Cancel alarm for index " + index);
        SharedPreferenceManager.setAlarmId(context,index,-1);
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ALARM_ID + index, alarmIntent, 0);
        alarmManager.cancel(pendingIntent);
    }
}
