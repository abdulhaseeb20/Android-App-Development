package com.example.smd_classwork.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.smd_classwork.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseMainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    TextView textView;
    DatabaseReference reference;//performs all crud operations
    ArrayList<Fast_Student> studentArrayList;
    RecyclerView recyclerView;
    FirebaseAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);
        recyclerView =findViewById(R.id.firebaserecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        database = FirebaseDatabase.getInstance("https://smd-classwork-61b3d-default-rtdb.firebaseio.com/");
        reference = database.getReference("MyDatabase");
        studentArrayList = new ArrayList<>();
        ReadDataFromFirebase();
        //reference.setValue("This is my first database");
        String id = reference.push().getKey();
        reference.child(id).setValue("Ali");
        reference.removeValue();//remove all value
       // reference.child("Student").child("Name").setValue("Ali");

        //reading data
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //textView.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void ReadDataFromFirebase() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Fast_Student student = new Fast_Student();
                    student.setName(snapshot.child("Name").getValue().toString());
                    student.setUrl(snapshot.child("Picture").getValue().toString());
                    studentArrayList.add(student);
                }
                //adapter = new FirebaseAdapter(studentArrayList,getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}