package com.example.smd_classwork.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.smd_classwork.R;

public class MultiColumnListViewExample extends AppCompatActivity {

    ListView listView;
    String[] Name = {"Jannat", "Alizay", "Rija", "Shanzeh", "Rabia", "Rumesha"};
    String[] Text = {"Hasnain fariq ho", "Parh lia kro", "Haseeb kese ho", "Sir course muhkal aye", "Guy from lahore"};
    int Image[] = {R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon,R.drawable.icon,R.drawable.icon,};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view_example);
        listView = findViewById(R.id.lstmulticolumn);
        MyAdapterMultiColumn adapterMultiColumn = new MyAdapterMultiColumn(this, Name, Text, Image);
        listView.setAdapter(adapterMultiColumn);

    }
}