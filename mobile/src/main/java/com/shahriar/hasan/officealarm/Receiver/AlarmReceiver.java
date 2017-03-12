package com.shahriar.hasan.officealarm.Receiver;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.shahriar.hasan.officealarm.Manager.AlarmTimeManager;
import com.shahriar.hasan.officealarm.Service.AlarmService;

/**
 * Created by USER on 3/2/2017.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {

    private NotificationManager alarmNotificationManager;
    @Override
    public void onReceive(Context context, Intent intent) {
//        AlarmActivity instance = AlarmActivity.getInstance();
//        instance.setAlarmText("Alarm!!!");
        int index = intent.getIntExtra(AlarmTimeManager.ALARM_INDEX, 0);
        Log.d("AlarmActivity", "AlarmReceiver onReceive");
        AlarmTimeManager.getAlarmTimeManagerInstance(context).setAlarm(index,true);
//        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//        if (alarmUri == null) {
//            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        }
//        Ringtone ringtone = RingtoneManager.getRingtone(context.getApplicationContext(), alarmUri);
//        Log.d("AlarmActivity", "ringtone Set " + ringtone);
//        ringtone.play();

        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);

//        Intent myIntent = new Intent(context, AlarmDialogActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(
//                context,
//                0,
//                myIntent,
//                0);
//
//        Notification myNotification = new NotificationCompat.Builder(context)
//                .setContentTitle("Exercise of Notification!")
//                .setContentText("Do Something...")
//                .setTicker("Notification!")
//                .setWhen(System.currentTimeMillis())
//                .setContentIntent(pendingIntent)
//                .setDefaults(Notification.DEFAULT_SOUND)
//                .setAutoCancel(true)
//                .setSmallIcon(R.drawable.abc)
//                .build();
//
//        alarmNotificationManager =
//                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
//        alarmNotificationManager.notify(1, myNotification);

    }
}
