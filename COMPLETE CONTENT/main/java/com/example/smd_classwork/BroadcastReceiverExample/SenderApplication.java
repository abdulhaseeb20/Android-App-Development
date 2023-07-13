package com.example.smd_classwork.BroadcastReceiverExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.smd_classwork.R;

public class SenderApplication extends AppCompatActivity {

    private BroadcastReceiver MyBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.example.smd_classwork.BroadcastReceiverExample.ACTION_SEND".equals(intent.getAction()))
            {
                Log.d("TAG", "This is my own BroadcastReceiver");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_application);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("com.example.smd_classwork.BroadcastReceiverExample.ACTION_SEND");
        registerReceiver(MyBroadcastReceiver, intentFilter);
    }

    public void SendBroadcast(View view)
    {
        Intent intent = new Intent("com.example.smd_classwork.BroadcastReceiverExample.ACTION_SEND");
        String key = "com.example.smd_classwork.BroadcastReceiverExample.EXTRA";
        intent.putExtra(key, "I am from sender Application");
        sendBroadcast(intent);
    }
}