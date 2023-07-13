package com.example.assignments.Task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.assignments.R;

import java.util.ArrayList;

public class Student_Activity_Two extends AppCompatActivity
{
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "saveddata";
    ListView myListView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    String[] myList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_two);
        myListView = findViewById(R.id.showlistview);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);


        String name = sharedPreferences.getString("data_key_name", null);
        String cnic = sharedPreferences.getString("data_key_cnic", null);
        String phone = sharedPreferences.getString("data_key_phone", null);
        String sgpa = sharedPreferences.getString("data_key_sgpa", null);
        String cgpa = sharedPreferences.getString("data_key_cgpa", null);
        myList = new String[]{name,cnic,phone,sgpa,cgpa};
        ArrayAdapter adapter = new ArrayAdapter<String>(Student_Activity_Two.this, android.R.layout.simple_list_item_1, myList);
        myListView.setAdapter(adapter);


    }

}