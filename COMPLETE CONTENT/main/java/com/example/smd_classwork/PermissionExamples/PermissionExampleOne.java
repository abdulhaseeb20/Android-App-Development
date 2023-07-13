package com.example.smd_classwork.PermissionExamples;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smd_classwork.R;

public class PermissionExampleOne extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_example_one);
    }

    public void Check_For_Permission(View view)
    {
        if(CheckPremission())
        {
            Toast.makeText(this,"Permission Already Granted", Toast.LENGTH_SHORT ).show();
        }
        else
        {
            Toast.makeText(this,"Request for Permission Granted", Toast.LENGTH_SHORT ).show();
        }

    }

    public void Request_For_Permission(View view)
    {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION, CAMERA}, 101 );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show(); //double tab shortcut

        }

    }


    public boolean CheckPremission()
    {
        int result_p1 = ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION);
        int result_p2 = ContextCompat.checkSelfPermission(this, CAMERA);
        return result_p1 == PackageManager.PERMISSION_GRANTED && result_p2 == PackageManager.PERMISSION_GRANTED;
    }
}