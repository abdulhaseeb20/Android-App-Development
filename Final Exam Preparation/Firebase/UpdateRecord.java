package com.example.firebaseassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UpdateRecord extends AppCompatActivity {

    EditText reg_no;
    String convert_regno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        reg_no = findViewById(R.id.txtupdaterecord);
    }

    public void findRecord(View view)
    {
        convert_regno = reg_no.getText().toString();
        Query query= FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/").getReference("StudentRecord").orderByChild("Reg No").equalTo(convert_regno);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    Toast.makeText(UpdateRecord.this, "Reg No found", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateRecord.this, UpdateRecord2.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(UpdateRecord.this, "Reg No not found", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }
}