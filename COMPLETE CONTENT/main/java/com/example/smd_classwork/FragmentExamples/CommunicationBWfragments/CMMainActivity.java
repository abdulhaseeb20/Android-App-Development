package com.example.smd_classwork.FragmentExamples.CommunicationBWfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smd_classwork.R;

public class CMMainActivity extends AppCompatActivity implements ButtonPressListener.OnButtonPressListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmmain);
    }

    @Override
    public void onButtonPressed(String Message) {
        MyFragment2 obj = (MyFragment2) getSupportFragmentManager().findFragmentById(R.id.frag2);
        obj.onFragmentInteraction(Message);
    }
}