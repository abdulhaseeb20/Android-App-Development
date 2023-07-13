package com.example.assignments.Task2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignments.R;

public class Student_Activity_One extends AppCompatActivity
{
    SharedPreferences sharedPreferences;
    EditText getNameData, getCnicData, getPhoneData, getSgpaData, getCgpaData;
    Button saveButton;

    private static final String SHARED_PREF_NAME = "saveddata";
    private static final String DATA_name = "data_key_name";
    private static final String DATA_cnic = "data_key_cnic";
    private static final String DATA_phone = "data_key_phone";
    private static final String DATA_sgpa = "data_key_sgpa";
    private static final String DATA_cgpa = "data_key_cgpa";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_one);
        getNameData = findViewById(R.id.getnamedata);
        getCnicData = findViewById(R.id.getcnicdata);
        getPhoneData = findViewById(R.id.getphonedata);
        getSgpaData = findViewById(R.id.getsgpadata);
        getCgpaData = findViewById(R.id.getcgpadata);
        saveButton = findViewById(R.id.savesharedpref);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String name = getNameData.getText().toString().trim();
                String cnic = getCnicData.getText().toString().trim();
                String phone = getPhoneData.getText().toString().trim();
                String sgpa = getSgpaData.getText().toString().trim();
               String cgpa = getCgpaData.getText().toString().trim();

                if (name.isEmpty() || cnic.isEmpty() || phone.isEmpty() || sgpa.isEmpty() || cgpa.isEmpty())
                {
                    Toast.makeText(Student_Activity_One.this, "Please enter complete data", Toast.LENGTH_SHORT).show();
                } else
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(DATA_name, name);
                    editor.putString(DATA_cnic, cnic);
                    editor.putString(DATA_phone, phone);
                    editor.putString(DATA_cgpa, cgpa);
                    editor.putString(DATA_sgpa, sgpa);
                    editor.commit();
                    Toast.makeText(Student_Activity_One.this, "Data saved successfully", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(Student_Activity_One.this, Student_Activity_Two.class);
                startActivity(intent);
            }
        });
    }
}