package com.example.a20f_1066_smd_final;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistrationForm extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    EditText name, image, cnic, carmodel, color, engine, city;
    int i = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        name = findViewById(R.id.txtupdtatename);
        image = findViewById(R.id.txtupdtatecarimg);
        cnic = findViewById(R.id.txtupdtatecnic);
        carmodel = findViewById(R.id.txtupdtatecarmodel);
        color = findViewById(R.id.txtupdtatecolor2);
        engine = findViewById(R.id.txtupdtateengine);
        city = findViewById(R.id.txtupdtatecityname);

        database = FirebaseDatabase.getInstance("https://f-1066-smd-final-f5c99-default-rtdb.firebaseio.com/");
        databaseReference = database.getReference("VehicleRecord");
        databaseReference.setValue("This is a database for vehicle records");
    }

    public void SaveRecord(View view)
    {
        String[] students = {"Student 1", "Student 2", "Student 3", "Student 4", "Student 5"};
        Map<String, Object> studentdata = new HashMap<>();
        studentdata.put("Name", name.getText().toString());
        studentdata.put("CC", engine.getText().toString());
        //studentdata.put("CNIC", image.getText().toString());
        studentdata.put("CNIC", cnic.getText().toString());
        studentdata.put("Model", carmodel.getText().toString());
        studentdata.put("Color", color.getText().toString());
        studentdata.put("City", city.getText().toString());
        databaseReference.child(students[i]).setValue(studentdata);
        i++;
        // databaseReference.setValue(studentdata);
        if (studentdata == null)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
        }

    }

    public void UpdateRecord(View view)
    {

    }
}