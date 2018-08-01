package com.vishal.altimeter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;


import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Vibrator;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class MyService extends Service {

    final static String MY_ACTION = "MY_ACTION";
    String initData;
    private final Handler handler = new Handler();

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        initData = intent.getStringExtra("INIT_DATA");
        runnable.run();
        return super.onStartCommand(intent, flags, startId);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            toastHandler.sendEmptyMessage(0);
                handler.postDelayed(this, 1000);

        }
    };

    private final Handler toastHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
                Intent intent = new Intent();
                intent.setAction(MY_ACTION);

                Calendar cal = Calendar.getInstance();
                Date currentLocalTime = cal.getTime();
                DateFormat date = new SimpleDateFormat("HH:mm");
                String localTime = date.format(currentLocalTime);

                if (initData.equals(localTime)) {
                    intent.putExtra("DATA_BACK", initData);

                    sendBroadcast(intent);
                    stopSelf();
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                    v.vibrate(500);
                    handler.removeCallbacks(runnable);

                }
        }
    };

}
