package com.example.zhangdede.alarmservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by zhangdede on 2016/9/25.
 */
public class SelfReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SelfReciver","onReceive is exected");
        Intent i = new Intent(context,SelfService.class);
        context.startService(i);
    }
}
