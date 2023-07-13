package com.example.smd_classwork.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smd_classwork.R;

import java.util.HashMap;

public class NewContactMainActivity extends AppCompatActivity {

    EditText firstName,secondName,phoneNumber,emailAddress,homeAddress;
    DbQueries dbQueries;
    HashMap<String, String> contact = new HashMap<String, String>();
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact_main);

        firstName = findViewById(R.id.edtfirstname);
        secondName = findViewById(R.id.edtsecondname);
        phoneNumber = findViewById(R.id.edtphonenumber);
        emailAddress = findViewById(R.id.edtemail);
        homeAddress = findViewById(R.id.edthomeaddress);
        dbQueries = new DbQueries(getApplicationContext());
    }

    public void SaveContact(View view) {
        contact.put("firstName", firstName.getText().toString());
        contact.put("secondName", secondName.getText().toString());
        contact.put("phoneNumber", phoneNumber.getText().toString());
        contact.put("emailAddress", emailAddress.getText().toString());
        contact.put("homeAddress", homeAddress.getText().toString());
        dbQueries.AddContacts(contact);
        Log.d("TAG","Data added successfully.");
    }

}