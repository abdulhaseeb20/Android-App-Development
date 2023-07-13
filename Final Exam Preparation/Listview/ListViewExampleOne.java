package com.example.smd_classwork.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.smd_classwork.R;

public class ListViewExampleOne extends AppCompatActivity {

    ListView myListView;
    ImageView myImageView;
    Integer[] mobileList = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.forth, R.drawable.fifth, R.drawable.one};
    String[] myList = {"Samsung", "Oppo", "Apple", "Infinix", "RedMi", "OnePlus", "Google Pixel"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example_one);
        myListView = findViewById(R.id.mylistviewexampleone);
        myImageView = findViewById(R.id.mylstimageview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(ListViewExampleOne.this, "Clicked at position " + i, Toast.LENGTH_SHORT).show();
                if(position >= 0 && position <= 5)
                {
                    myImageView.setImageResource(mobileList[position]);
                }

            }
        });
    }
}