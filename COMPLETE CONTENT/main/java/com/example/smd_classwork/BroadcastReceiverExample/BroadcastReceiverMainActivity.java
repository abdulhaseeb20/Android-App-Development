package com.example.smd_classwork.BroadcastReceiverExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.smd_classwork.R;

public class BroadcastReceiverMainActivity extends AppCompatActivity {

    AirplaneModeChange obj = new AirplaneModeChange();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(obj, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(obj);
    }
}