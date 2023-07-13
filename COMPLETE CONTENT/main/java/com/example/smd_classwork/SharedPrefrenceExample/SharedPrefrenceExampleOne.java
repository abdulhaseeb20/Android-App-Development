package com.example.smd_classwork.SharedPrefrenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smd_classwork.R;

import java.util.ArrayList;

public class SharedPrefrenceExampleOne extends AppCompatActivity
{
    SharedPreferences sharedPreferences;
    ListView myListview;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrence_example_one);
        sharedPreferences = getSharedPreferences("MyFile", 0);
        textView = findViewById(R.id.txtSharedPref);
        myListview = findViewById(R.id.mylistviewsharedpref);
    }

    public void Save_My_Preference(View view)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("A", 100);
        editor.putString("C", "Ahmad");
        editor.putString("D", "Umair");
        editor.putString("E", "Ammmar");
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void Show_My_Preference(View view)
    {
         int a = sharedPreferences.getInt("A", 0);
         String b = sharedPreferences.getString("B", null);
        //textView.setText(a + " " + b);
        String c = sharedPreferences.getString("C", null);
        String d = sharedPreferences.getString("D", null);
        String e = sharedPreferences.getString("E", null);
        ArrayList<String> myNameList = new ArrayList<>();
        myNameList.add(String. valueOf(a));
        myNameList.add(b);
        myNameList.add(c);
        myNameList.add(d);
        myNameList.add(e);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myNameList);
        myListview.setAdapter(adapter);
    }
}