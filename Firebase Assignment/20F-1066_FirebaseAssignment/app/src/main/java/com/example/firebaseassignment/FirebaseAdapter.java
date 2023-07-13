package com.example.firebaseassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.ViewHolder> {

    ArrayList<StudentRecords> studentRecordsArrayList;
    Context context;

    public FirebaseAdapter(ArrayList<StudentRecords> studentRecordsArrayList, Context context) {
        this.studentRecordsArrayList = studentRecordsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reports,parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Name.setText(studentRecordsArrayList.get(position).getName());
        holder.Dept.setText(studentRecordsArrayList.get(position).getDept());
        holder.Reg_no.setText(studentRecordsArrayList.get(position).getReg_no());
        holder.Cgpa.setText(studentRecordsArrayList.get(position).getCgpa());
        holder.Email.setText(studentRecordsArrayList.get(position).getEmail());

        System.out.println(studentRecordsArrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return studentRecordsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Dept, Reg_no, Cgpa, Email;
        ImageView imageView;
        public ViewHolder(@NonNull View view) {
            super(view);
            Name = view.findViewById(R.id.txtname);
            Dept = view.findViewById(R.id.txtdept);
            Reg_no = view.findViewById(R.id.txtregno);
            Cgpa = view.findViewById(R.id.txtcgpa);
            Email = view.findViewById(R.id.txtemail);
        }
    }
}
