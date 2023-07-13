package com.example.smd_classwork.intentExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smd_classwork.MainActivity;
import com.example.smd_classwork.R;

public class intentExample01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example01);
    }

    public void GotoSecondActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("A1", "FAST");
        intent.putExtra("A2", "National");
        intent.putExtra("A3", "University");
        startActivity(intent);
    }
}