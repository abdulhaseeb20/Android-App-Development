package com.example.smd_classwork.BroadcastReceiverExample;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChange extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeOn( context))
        {
            Toast.makeText(context,"Airplane MOde is ON", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"Airplane MOde is OFF", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;//returns 1
    }
}
