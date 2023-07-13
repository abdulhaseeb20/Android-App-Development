package com.example.smd_classwork.ServiceExamples.BoundServiceExample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;

import androidx.annotation.Nullable;


import com.example.smd_classwork.R;

public class MyBoundService extends Service {
    private final Binder myBinder = new MyBinder();
    public static final String TAG = "TAG";
    public MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.small);
        Log.d(TAG, "onCreate() method is called... ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind called... ");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    public class MyBinder extends Binder
    {
        MyBoundService getServiceMethod()
        {
            return MyBoundService.this;
        }
    }

    public void Play()
    {
        mediaPlayer.start();
    }
    public void Pause()
    {
        mediaPlayer.pause();
    }
    public boolean isPlaying()
    {
        return mediaPlayer.isPlaying();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
