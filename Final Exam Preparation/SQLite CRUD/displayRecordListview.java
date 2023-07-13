package com.example.smd_classwork.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.smd_classwork.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactListMainActivity extends AppCompatActivity {
    ListView listView;
    DbQueries dbQueries;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list_main);
        dbQueries = new DbQueries(getApplicationContext());
        listView = findViewById(R.id.lstmaincontactlist);
        textView = findViewById(R.id.getidtxtview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<HashMap<String, String>> contactList = dbQueries.getAllContacts();
        SimpleAdapter adapter = new SimpleAdapter(this, contactList, R.layout.sqlnewlayout,
                new String[]{"firstName", "secondName", "phoneNumber", "emailAddress", "homeAddress"},
                new int[]{R.id.txtfirstname, R.id.txtsecondname, R.id.txtphoneno, R.id.txtemailaddress, R.id.txthomeaddress});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(ContactListMainActivity.this, EditContactEntery.class);
                intent.putExtra("id", String.valueOf(position+1));
                startActivity(intent);
            }
        });
    }

    public void AddContact(View view) {
        Intent intent = new Intent(this, NewContactMainActivity.class);
        startActivity(intent);
    }

    public void UpdateContact(View view) {
    }

   public void DeleteContact(View view) {
        Intent intent = new Intent(this, NewContactMainActivity.class);
        startActivity(intent);
    }

}