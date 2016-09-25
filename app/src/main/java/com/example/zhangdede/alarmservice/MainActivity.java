package com.example.zhangdede.alarmservice;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button start_send = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_send = (Button)findViewById(R.id.startService);
        start_send.setOnClickListener(this);
        SelfReciver reciver =new SelfReciver();
        IntentFilter filter = new IntentFilter("com.example.zhangdede.alarmservice");
        registerReceiver(reciver,filter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction("com.example.zhangdede.alarmservice");
        sendBroadcast(intent);
    }
}
