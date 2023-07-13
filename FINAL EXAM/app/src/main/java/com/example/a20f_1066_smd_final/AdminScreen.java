package com.example.a20f_1066_smd_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
    }


    public void MoveToDefaulter(View view) {
       // Intent intent = new Intent(this, Defaulter.class);
      //  startActivity(intent);
    }

    public void MoveToRequests(View view) {
        Intent intent = new Intent(this, AllRequests.class);
        startActivity(intent);
    }
}