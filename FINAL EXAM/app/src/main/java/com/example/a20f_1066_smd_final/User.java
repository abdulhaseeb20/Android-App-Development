package com.example.a20f_1066_smd_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    public void RegisterForm(View view) {

        Intent intent = new Intent(this, RegistrationForm.class);
        startActivity(intent);
    }

}