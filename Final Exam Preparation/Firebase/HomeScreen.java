package com.example.firebaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void AddRecord(View view) {
        Intent intent = new Intent(this, AddRecord.class);
        startActivity(intent);
    }

    public void DeleteRecord(View view)
    {
        Intent intent = new Intent(this, DeleteRecord.class);
        startActivity(intent);
    }

    public void UpdateRecord(View view)
    {
        Intent intent = new Intent(this, UpdateRecord.class);
        startActivity(intent);
    }

    public void CheckReports(View view)
    {
        Intent intent = new Intent(this, DisplayReports.class);
        startActivity(intent);
    }
}