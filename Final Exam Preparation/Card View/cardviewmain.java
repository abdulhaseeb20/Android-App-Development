package com.example.smd_classwork.CardViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.smd_classwork.R;

import java.util.ArrayList;

public class CardVeiwMainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    public ArrayList<My_Model> arrayList = new ArrayList<>();
    CardViewAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_veiw_main);
        recyclerView = findViewById(R.id.mycardviewrecyclerview);
        adapter = new CardViewAdapter(this, arrayList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        insertData();
    }

    public void insertData()
    {
        int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.forth, R.drawable.fifth};
        My_Model obj = new My_Model("First Picture", 40, images[0]);
        arrayList.add(obj);
        obj = new My_Model("Second Picture", 40, images[1]);
        arrayList.add(obj);
        obj = new My_Model("Third Picture", 40, images[2]);
        arrayList.add(obj);
        obj = new My_Model("Forth Picture", 40, images[3]);
        arrayList.add(obj);
        obj = new My_Model("Fifth Picture", 40, images[4]);
        arrayList.add(obj);

    }
}