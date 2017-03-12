package com.shahriar.hasan.officealarm;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by USER on 3/2/2017.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {

    private NotificationManager alarmNotificationManager;
    @Override
    public void onReceive(Context context, Intent intent) {
//        AlarmActivity instance = AlarmActivity.getInstance();
//        instance.setAlarmText("Alarm!!!");
        Log.d("AlarmActivity", "AlarmReceiver onReceive");
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
