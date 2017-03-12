package com.shahriar.hasan.officealarm.Service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by USER on 2/26/2017.
 */

public class AlarmService extends IntentService {
    private NotificationManager alarmNotificationManager;

    public AlarmService() {
        super("AlarmService");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Wake Up! Wake Up!");
    }

    private void sendNotification(String msg) {
        Log.d("AlarmActivity", "Preparing to send notification...: " + msg);

        // Disable wifi
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if(wifiManager.setWifiEnabled(false)){
            Log.d(TAG, "Wifi disabled ");
        }


//        alarmNotificationManager = (NotificationManager) this
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//
//        Intent activityIntent =  new Intent(this, AlarmDialogActivity.class);
//        activityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
//                | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//        activityIntent.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
//                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
//                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
//                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
//        startActivity(activityIntent);



        /*Prepare notification with pending intent*/

//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
//                activityIntent, 0);
//
//        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
//                this).setContentTitle("Alarm").setSmallIcon(R.drawable.abc)
//                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
//                .setContentText(msg);
//
//
//        alamNotificationBuilder.setContentIntent(contentIntent);
//        Notification notification = alamNotificationBuilder.build();
//        notification.flags |= Notification.FLAG_AUTO_CANCEL;
//        alarmNotificationManager.notify(0, notification);
        Log.d("AlarmActivity", "Notification sent.");
    }
}






//public class AlarmService extends Service {
//
//    private MediaPlayer mediaPlayer = null;
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        try {
////          String path = "/raw/mac_gyver.mp3";//Environment.getExternalStorageDirectory().getPath()+
////          Uri uri = Uri.parse(path);
//            mediaPlayer = MediaPlayer.create(this,R.raw.mac_gyver );
//            if (mediaPlayer != null)
//                Log.d(TAG, "AlarmService: mediaPlayer true");
//            else
//                Log.d(TAG, "AlarmService: mediaPlayer false");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private  void startMusic(){
//        try {
//            mediaPlayer.setLooping(true);
//            PlayTask playTask = new PlayTask();
//            playTask.execute();
////                        mediaPlayer.start();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        // Let it continue running until it is stopped.
//        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
//        startMusic();
//        return START_STICKY;
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
//    }
//
//    private class PlayTask extends AsyncTask
//    {
//        @Override
//        protected Object doInBackground(Object[] params) {
//            mediaPlayer.start();
//            return null;
//        }
//    }
//}
