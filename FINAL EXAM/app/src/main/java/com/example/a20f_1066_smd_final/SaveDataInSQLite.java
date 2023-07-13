package com.example.a20f_1066_smd_final;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class SaveDataInSQLite extends AppCompatActivity {

    EditText name, image, cnic, carmodel, color, engine, city;
    DbQueries dbQueries;
    HashMap<String, String> contact = new HashMap<String, String>();
    int count = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data_in_sqlite);

        setContentView(R.layout.activity_registration_form);
        name = findViewById(R.id.txtupdtatename);
        image = findViewById(R.id.txtupdtatecarimg);
        cnic = findViewById(R.id.txtupdtatecnic);
        carmodel = findViewById(R.id.txtupdtatecarmodel);
        color = findViewById(R.id.txtupdtatecolor2);
        engine = findViewById(R.id.txtupdtateengine);
        city = findViewById(R.id.txtupdtatecityname);
        dbQueries = new DbQueries(getApplicationContext());
    }

    public void SaveRecord(View view) {
        contact.put("Name", name.getText().toString());
        contact.put("CNIC", cnic.getText().toString());
        contact.put("Model", carmodel.getText().toString());
        contact.put("Color", color.getText().toString());
        contact.put("CC", engine.getText().toString());
        contact.put("City", city.getText().toString());
        dbQueries.AddContacts(contact);
        Log.d("TAG", "Data added successfully.");
    }
}