package com.example.smd_classwork.ServiceExamples;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyserviceExampleOne extends Service
{

    @Nullable
    @Override
    //jab tk component bound rahe ga tb tk ye service chalti rahay gi
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "Serivce Started", Toast.LENGTH_SHORT).show();
        Log.d("TAG","Service started");
        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }
}
