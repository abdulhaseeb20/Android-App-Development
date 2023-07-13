package com.example.smd_classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("A1");
        String value2 = intent.getStringExtra("A2");

        textView = findViewById(R.id.txtintent);
        textView.setText(value1 + " " + value2);

    }
}