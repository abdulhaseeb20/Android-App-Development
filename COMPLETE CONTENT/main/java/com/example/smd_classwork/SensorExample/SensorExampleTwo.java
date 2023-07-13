package com.example.smd_classwork.SensorExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smd_classwork.R;

public class SensorExampleTwo extends AppCompatActivity  implements SensorEventListener {

    SensorManager sensorManager;
    boolean color = false;
    View view;
    long lastTimeUpdate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_example_two);
        lastTimeUpdate = System.currentTimeMillis();
        view = findViewById(R.id.txtsensorexampletwo);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            getMyAccelerometerValues(event);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

   public void getMyAccelerometerValues(SensorEvent sensorEvent)
   {
       float[] value = sensorEvent.values;
       float x = value[0];
       float y = value[1];
       float z = value[2];
       float acceleration = (x*x + y*y + z*z)
               /(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
       long currentTime = sensorEvent.timestamp;
       if (acceleration >= 2)
       {
           if (currentTime - lastTimeUpdate < 150)
           {
               return;
           }
           lastTimeUpdate = currentTime;
           Toast.makeText(this, "Device was moved",
                   Toast.LENGTH_SHORT).show();
           if(color)
           {
               view.setBackgroundColor(Color.RED);
           }
           else
           {
               view.setBackgroundColor(Color.GREEN);

           }
           color = !color;
       }
   }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}