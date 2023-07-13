package com.example.smd_classwork.SensorExample;

import static com.example.smd_classwork.R.id.txtproximitysensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.smd_classwork.R;

public class SensorExampleOneMainActivity extends AppCompatActivity {

    TextView textView;
    SensorManager sensorManager;
    Sensor sensor;
    @SuppressLint({"MissingInflatedId", "ServiceCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_example_one_main);
        textView = findViewById(txtproximitysensor);
        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (sensor == null)
        {
            textView.setText("No sensor value");
        }
        else
        {
            sensorManager.registerListener(proximitySensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY)
            {
                if (event.values[0] == 0)
                {
                    textView.setText("Object is near");
                }
                else
                {
                    textView.setText("Object is away");
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}