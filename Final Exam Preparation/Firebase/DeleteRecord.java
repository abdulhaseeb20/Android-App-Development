package com.example.firebaseassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DeleteRecord extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    EditText reg_no;
    String convert_regno;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_record);
        reg_no = findViewById(R.id.txtdeleteregno);
        database = FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/");
        databaseReference = database.getReference("StudentRecord");
    }

    @SuppressLint("NotConstructor")
    public void DeleteRecord(View view)
    {
        convert_regno = reg_no.getText().toString();
        Query query = FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                .getReference("StudentRecord")
                .orderByChild("Reg No").equalTo(convert_regno);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    {
                        String key = snapshot.getKey();
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Name").removeValue();
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Dept").removeValue();
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Reg No").removeValue();
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("CGPA").removeValue();
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Email").removeValue();
                    }
                    reg_no.setText("");
                    Toast.makeText(DeleteRecord.this, "Record deleted", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(DeleteRecord.this, "Reg No not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}