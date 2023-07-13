package com.example.smd_classwork.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smd_classwork.R;

import java.util.ArrayList;

public class RecyclerViewMainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<Mobile> arrayList = new ArrayList<>();
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        recyclerView = findViewById(R.id.myrecyclerview1);
        insertData();
        adapter = new RecyclerViewAdapter(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void insertData()
    {
        Mobile obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("Note9", "Samsung", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
        obj1 = new Mobile("iPhone14", "Apple", "300000");
        arrayList.add(obj1);
    }

}