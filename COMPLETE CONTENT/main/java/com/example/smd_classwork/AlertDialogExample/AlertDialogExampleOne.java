package com.example.smd_classwork.AlertDialogExample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.smd_classwork.R;
import com.google.android.material.snackbar.Snackbar;

public class AlertDialogExampleOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_example_one);
    }

    public void OPenAlertDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure").setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Snackbar.make(view, "Ok Pressed", Snackbar.LENGTH_LONG).show();
            }
        })
                .setNegativeButton("Cancel", null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}