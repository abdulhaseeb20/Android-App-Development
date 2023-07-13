package com.example.firebaseassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DisplayReports extends AppCompatActivity {

    ArrayList<StudentRecords> studentRecords;
    RecyclerView recyclerView;
    FirebaseAdapter firebaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_reports);
    }

    public void threeCgpaReport(View view)
    {
        studentRecords = new ArrayList<>();
        recyclerView = findViewById(R.id.fbrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Query query = FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                .getReference("StudentRecord").orderByChild("CGPA").startAt("3.0");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    {
                        StudentRecords records = new StudentRecords();
                        records.setName(snapshot.child("Name").getValue().toString());
                        records.setDept(snapshot.child("Dept").getValue().toString());
                        records.setReg_no(snapshot.child("Reg No").getValue().toString());
                        records.setCgpa(snapshot.child("CGPA").getValue().toString());
                        records.setEmail(snapshot.child("Email").getValue().toString());
                        studentRecords.add(records);
                    }
                    firebaseAdapter = new FirebaseAdapter(studentRecords, getApplicationContext());
                    recyclerView.setAdapter(firebaseAdapter);
                    firebaseAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(DisplayReports.this, "No student found with 3 or greater CGPA", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void lessTwoCgpaReport(View view) {
        studentRecords = new ArrayList<>();
        recyclerView = findViewById(R.id.fbrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Query query = FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                .getReference("StudentRecord").orderByChild("CGPA").endAt("1.99");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    {
                        StudentRecords records = new StudentRecords();
                        records.setName(snapshot.child("Name").getValue().toString());
                        records.setDept(snapshot.child("Dept").getValue().toString());
                        records.setReg_no(snapshot.child("Reg No").getValue().toString());
                        records.setCgpa(snapshot.child("CGPA").getValue().toString());
                        records.setEmail(snapshot.child("Email").getValue().toString());
                        studentRecords.add(records);
                    }
                    firebaseAdapter = new FirebaseAdapter(studentRecords, getApplicationContext());
                    recyclerView.setAdapter(firebaseAdapter);
                    firebaseAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(DisplayReports.this, "No student found with less than 1.99 CGPA", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void seDeptReport(View view) {
        studentRecords = new ArrayList<>();
        recyclerView = findViewById(R.id.fbrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Query query = FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                .getReference("StudentRecord").orderByChild("Dept").equalTo("SE");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    {
                        StudentRecords records = new StudentRecords();
                        records.setName(snapshot.child("Name").getValue().toString());
                        records.setDept(snapshot.child("Dept").getValue().toString());
                        records.setReg_no(snapshot.child("Reg No").getValue().toString());
                        records.setCgpa(snapshot.child("CGPA").getValue().toString());
                        records.setEmail(snapshot.child("Email").getValue().toString());
                        studentRecords.add(records);
                    }
                    firebaseAdapter = new FirebaseAdapter(studentRecords, getApplicationContext());
                    recyclerView.setAdapter(firebaseAdapter);
                    firebaseAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(DisplayReports.this, "No student of SE Dept found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void csDeptReport(View view) {
        studentRecords = new ArrayList<>();
        recyclerView = findViewById(R.id.fbrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Query query = FirebaseDatabase.getInstance("https://fir-assignment-10086-default-rtdb.firebaseio.com/")
                .getReference("StudentRecord").orderByChild("Dept").equalTo("CS");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren())
                    {
                        StudentRecords records = new StudentRecords();
                        records.setName(snapshot.child("Name").getValue().toString());
                        records.setDept(snapshot.child("Dept").getValue().toString());
                        records.setReg_no(snapshot.child("Reg No").getValue().toString());
                        records.setCgpa(snapshot.child("CGPA").getValue().toString());
                        records.setEmail(snapshot.child("Email").getValue().toString());
                        studentRecords.add(records);
                    }
                    firebaseAdapter = new FirebaseAdapter(studentRecords, getApplicationContext());
                    recyclerView.setAdapter(firebaseAdapter);
                    firebaseAdapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(DisplayReports.this, "No student of SE Dept found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}