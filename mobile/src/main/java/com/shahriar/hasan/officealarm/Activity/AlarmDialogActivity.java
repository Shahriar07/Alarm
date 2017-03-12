package com.shahriar.hasan.officealarm.Activity;

import android.app.Activity;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shahriar.hasan.officealarm.R;

/**
 * Created by USER on 3/11/2017.
 */

public class AlarmDialogActivity extends Activity {

    Ringtone ringtone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AlarmDialogActivity", "ringtone Set " + ringtone);
        setContentView(R.layout.alarm_dialog_activity);
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(this.getApplicationContext(), alarmUri);
        Log.d("AlarmActivity", "ringtone Set " + ringtone);
        ringtone.play();
//            setAlarmText("Alarm Set!! ");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onStopClicked (View view){
//        Intent alarmIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
//        pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 1911, alarmIntent, 0);
//        Log.d("AlarmActivity", "Alarm stopped " + pendingIntent);
//        alarmManager.cancel(pendingIntent);
//        setAlarmText("Alarm Stopped!!");
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        // ringtone = RingtoneManager.getRingtone(this.getApplicationContext(), alarmUri);
        Log.d("AlarmActivity", "ringtone Set " + ringtone);
        ringtone.stop();
        finish();
    }

}
