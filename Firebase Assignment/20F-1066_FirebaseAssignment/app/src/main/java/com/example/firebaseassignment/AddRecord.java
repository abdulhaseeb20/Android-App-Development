package com.example.firebaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddRecord extends AppCompatActivity {

   FirebaseDatabase database;
   DatabaseReference databaseReference;
    EditText name, dept, reg_no, cgpa, email;
    int i = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        name = findViewById(R.id.txtupdtatename);
        dept = findViewById(R.id.txtupdtatedept);
        reg_no = findViewById(R.id.txtupdtateregno);
        cgpa = findViewById(R.id.txtupdtatecgpa);
        email = findViewById(R.id.txtupdtateemail);

        database = FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/");
        databaseReference = database.getReference("StudentRecord");
        databaseReference.setValue("This is a database for student records");
    }

    public void SaveRecord(View view)
    {
        String[] students = {"Student 1", "Student 2", "Student 3", "Student 4", "Student 5"};
        Map<String, Object> studentdata = new HashMap<>();
        studentdata.put("Name", name.getText().toString());
        studentdata.put("Dept", dept.getText().toString());
        studentdata.put("Reg No", reg_no.getText().toString());
        studentdata.put("CGPA", cgpa.getText().toString());
        studentdata.put("Email", email.getText().toString());
        databaseReference.child(students[i]).setValue(studentdata);
        i++;
        // databaseReference.setValue(studentdata);
        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();

    }

    public void UpdateRecord(View view)
    {

    }
}