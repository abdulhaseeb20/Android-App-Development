package com.example.smd_classwork.ServiceExamples.BoundServiceExample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.smd_classwork.R;
public class BoundServiceExampleMainActivity extends AppCompatActivity {
    public MyBoundService myBoundServicePlayer;
    public boolean myBoundServiceFlag = false;
    private ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundServicePlayer = myBinder.getServiceMethod();
            myBoundServiceFlag = true;
            Log.d("TAG", "Connection Created...");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_example_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, myServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(myBoundServiceFlag == true)
        {
            unbindService(myServiceConnection);
        }
    }

    public void Play_Pause(View view) {
        if(myBoundServiceFlag == true)
        {
            if(myBoundServicePlayer.isPlaying())
            {
                myBoundServicePlayer.Pause();
            }
            else
            {
                myBoundServicePlayer.Play();
            }
        }
    }
}