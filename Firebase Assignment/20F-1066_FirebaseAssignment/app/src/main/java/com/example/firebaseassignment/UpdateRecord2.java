package com.example.firebaseassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UpdateRecord2 extends AppCompatActivity {

    EditText name, dept, reg_no, cgpa, email;
    String convert_name, convert_dept, convert_regno, convert_cgpa, convert_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record2);
        name = findViewById(R.id.txtupdtatename);
        dept = findViewById(R.id.txtupdtatedept);
        reg_no = findViewById(R.id.txtupdtateregno);
        cgpa = findViewById(R.id.txtupdtatecgpa);
        email = findViewById(R.id.txtupdtateemail);
    }

    public void UpdateRecord(View view)
    {
        convert_name = name.getText().toString();
        convert_dept = dept.getText().toString();
        convert_regno = reg_no.getText().toString();
        convert_cgpa = cgpa.getText().toString();
        convert_email = email.getText().toString();
        Query query= FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/").getReference("StudentRecord").orderByChild("Reg No").equalTo(convert_regno);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String key = snapshot.getKey();
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Name").setValue(convert_name);
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Dept").setValue(convert_dept);
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Reg No").setValue(convert_regno);
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("CGPA").setValue(convert_cgpa);
                        FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                                .getReference("StudentRecord").child(key).child("Email").setValue(convert_email);
                    }
                    name.setText("");
                    dept.setText("");
                    reg_no.setText("");
                    cgpa.setText("");
                    email.setText("");
                    Toast.makeText(UpdateRecord2.this, "Record updated successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(UpdateRecord2.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}