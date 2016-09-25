package com.example.zhangdede.alarmservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by zhangdede on 2016/9/25.
 */
public class SelfService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("selfservice:","onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("service->time: ",new Date().toString());
            }
        }).start();
        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent i = new Intent(this,SelfReciver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,i,0);
        alarm.set(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+10*1000,pi);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
