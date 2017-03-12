package com.shahriar.hasan.officealarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

/**
 * Created by USER on 3/1/2017.
 */

public class AlarmActivity extends Activity {

    AlarmManager alarmManager;
    private TimePicker alarmTimePicker;
    private TextView alarmTextView;
    PendingIntent pendingIntent;

    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity);
        alarmTimePicker = (TimePicker)findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
//        ToggleButton alarmToggle  = (ToggleButton)findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 1911, alarmIntent, 0);

    }

    public void onToggleClicked (View view){

        if (((ToggleButton)view).isChecked()) {
            Log.d("AlarmActivity", "Alarm On");
            Calendar calendar = Calendar.getInstance();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());
                setAlarmText("Alarm Set to " + alarmTimePicker.getHour() + " Hour " + alarmTimePicker.getMinute() + " Minute");
            } else {
                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                setAlarmText("Alarm Set to " + alarmTimePicker.getCurrentHour() + " Hour " + alarmTimePicker.getCurrentMinute() + " Minute");
            }

            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+15000, pendingIntent);
        }
        else{
            Log.d("AlarmActivity", "Alarm off");
            alarmManager.cancel(pendingIntent);
            setAlarmText("");
        }
    }
    public void onStopClicked (View view){
        Intent alarmIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 1911, alarmIntent, 0);
        Log.d("AlarmActivity", "Alarm stopped " + pendingIntent);
        alarmManager.cancel(pendingIntent);
        setAlarmText("Alarm Stopped!!");
    }

//    public void onCalled (View view){
//        ComponentName comp = new ComponentName(this.getPackageName(),
//                AlarmService.class.getName());
//        startWakefulService(this, (intent.setComponent(comp)));
//        setResultCode(Activity.RESULT_OK);
//    }
    public void setAlarmText(String alarmText){
        alarmTextView.setText(alarmText);
    }
}
