package com.example.smd_classwork.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smd_classwork.MainActivity;
import com.example.smd_classwork.R;

import java.util.HashMap;

public class EditContactEntery extends AppCompatActivity {
    EditText editFirstName, editSecondName, editPhoneNumber, editEmailAddress, editHomeAddress;
    HashMap<String, String> singleContact;
    DbQueries dbQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_entery);
        editFirstName = findViewById(R.id.editfirstname);
        editSecondName = findViewById(R.id.editsecondname);
        editPhoneNumber = findViewById(R.id.editphonenumber);
        editEmailAddress = findViewById(R.id.editemailaddress);
        editHomeAddress = findViewById(R.id.edithomeaddress);
        dbQueries = new DbQueries(getApplicationContext());
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        singleContact = dbQueries.getSingleContact(id);
        Log.d("TAG", "The next work will be done by me");

        //dbQueries.DeleteContact(id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        editFirstName.setText(singleContact.get("firstName"));
        editSecondName.setText(singleContact.get("secondName"));
        editPhoneNumber.setText(singleContact.get("phoneNumber"));
        editEmailAddress.setText(singleContact.get("emailAddress"));
        editHomeAddress.setText(singleContact.get("homeAddress"));
    }

    public void DeleteRecord(View view) {
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        dbQueries.deleteContact(id);
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
        Log.d("TAG","Deleted with id = " +id);
    }

    public void UpdateRecord(View view) {
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        HashMap<String,String> updateContact = new HashMap<String, String>();
        updateContact.put("firstName",editFirstName.getText().toString());
        updateContact.put("secondName",editSecondName.getText().toString());
        updateContact.put("phoneNumber",editPhoneNumber.getText().toString());
        updateContact.put("emailAddress",editEmailAddress.getText().toString());
        updateContact.put("homeAddress",editHomeAddress.getText().toString());
        dbQueries.updateContact(updateContact,id);
        Log.d("TAG","Data Updated Successfully with ID="+id);
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}