package com.example.smd_classwork.ListViewExamples.MultiColumnExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.smd_classwork.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ThreeColumnListViewExample extends AppCompatActivity
{
    ListView listView;
    ArrayList<HashMap<String, String>> arrayList;

    //String[] Name = {"Ali", "Ahmed", "Mujtaba", "Abdullah", "Jabbar"};
    //String[]
    public static final String FirstColumn = "first";
    public static final String SecondColumn = "second";
    public static final String ThirdColumn = "third";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_column_list_view_example);//attach activity with layout function
        listView = findViewById(R.id.lstthreecolumnexample);
        arrayList = new ArrayList<HashMap<String, String>>();
        LoadData();
        MyListAdapter myListAdapter = new MyListAdapter(arrayList, this);
        listView.setAdapter(myListAdapter);
    }

    public void LoadData()
    {
        HashMap<String, String> hashMap1 = new HashMap<String, String>();
        hashMap1.put(FirstColumn, "Ali");
        hashMap1.put(SecondColumn, "Ahmad");
        hashMap1.put(ThirdColumn, "Akhtar");
        arrayList.add(hashMap1);

        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        hashMap2.put(FirstColumn, "Ali Ahmad");
        hashMap2.put(SecondColumn, "Ahmad Ali");
        hashMap2.put(ThirdColumn, "Akhtar Ahmad");
        arrayList.add(hashMap2);

        HashMap<String, String> hashMap3 = new HashMap<String, String>();
        hashMap3.put(FirstColumn, "Ahmad");
        hashMap3.put(SecondColumn, "Aslam");
        hashMap3.put(ThirdColumn, "Rizwan");
        arrayList.add(hashMap3);

    }
}