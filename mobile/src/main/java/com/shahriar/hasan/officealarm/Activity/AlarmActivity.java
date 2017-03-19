package com.shahriar.hasan.officealarm.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shahriar.hasan.officealarm.Custom_UI.CustomCheckbox;
import com.shahriar.hasan.officealarm.Interfaces.CheckBoxListener;
import com.shahriar.hasan.officealarm.Manager.AlarmTimeManager;
import com.shahriar.hasan.officealarm.Manager.SharedPreferenceManager;
import com.shahriar.hasan.officealarm.R;
import com.shahriar.hasan.officealarm.Utility.Utility;

/**
 * Created by USER on 3/1/2017.
 */

public class AlarmActivity extends Activity implements CheckBoxListener {

    CustomCheckbox checkBox[]= new CustomCheckbox[4];



    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity);
       // alarmTimePicker = (TimePicker)findViewById(R.id.alarmTimePicker);
//        alarmTextView = (TextView) findViewById(R.id.alarmText);
        checkBox[0] = (CustomCheckbox)findViewById(R.id.Checkbox1);
        checkBox[1] = (CustomCheckbox)findViewById(R.id.Checkbox2);
        checkBox[2] = (CustomCheckbox)findViewById(R.id.Checkbox3);
        checkBox[3] = (CustomCheckbox)findViewById(R.id.Checkbox4);
        for(int i = 0; i<4 ; i++){
            checkBox[i].setTag(i);
            checkBox[i].setCheckBoxListener(this);
            if (SharedPreferenceManager.getAlarmId(this,i) != -1){
                checkBox[i].setChecked(true);
            }
        }
//        ToggleButton alarmToggle  = (ToggleButton)findViewById(R.id.alarmToggle);
    }

    public void onToggleClicked (View view){
        CustomCheckbox checkBox = (CustomCheckbox) view;

        if (checkBox.isChecked()){
            AlarmTimeManager alarmTimeManager = AlarmTimeManager.getAlarmTimeManagerInstance(AlarmActivity.this.getApplicationContext());
            alarmTimeManager.setAlarm((int)checkBox.getTag(),false);
        }
        else {
            Log.d(Utility.TAG, "Alarm off");
            AlarmTimeManager alarmTimeManager = AlarmTimeManager.getAlarmTimeManagerInstance(AlarmActivity.this.getApplicationContext());
            alarmTimeManager.cancelAlarm((int)checkBox.getTag());
        }
//
//        if ((()view).isChecked()) {
//            Log.d(Utility.TAG, "Alarm On");
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                calendar.set(Calendar.HOUR_OF_DAY, 21);
//                calendar.set(Calendar.MINUTE, 26);
////                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getHour());
////                calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());
////                setAlarmText("Alarm Set to " + alarmTimePicker.getHour() + " Hour " + alarmTimePicker.getMinute() + " Minute");
//            } else {
//                calendar.set(Calendar.HOUR_OF_DAY, 21);
//                calendar.set(Calendar.MINUTE, 26);
////                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
////                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
////                setAlarmText("Alarm Set to " + alarmTimePicker.getCurrentHour() + " Hour " + alarmTimePicker.getCurrentMinute() + " Minute");
//            }
//
//
//        }
//        else{
//
//        }
    }

//    public void onCalled (View view){
//        ComponentName comp = new ComponentName(this.getPackageName(),
//                AlarmService.class.getName());
//        startWakefulService(this, (intent.setComponent(comp)));
//        setResultCode(Activity.RESULT_OK);
//    }
}
