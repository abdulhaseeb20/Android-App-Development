package com.example.a20f_1066_smd_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a20f_1066_smd_final.R;

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
    }

    public void MoveToUser(View view) {
        Intent intent = new Intent(this, User.class);
        startActivity(intent);
    }

    public void MoveToAdmin(View view) {
        Intent intent = new Intent(this, AdminScreen.class);
        startActivity(intent);
    }
}