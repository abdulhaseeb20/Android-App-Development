package com.example.a20f_1066_smd_final;

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

    ArrayList<StudentRecords> vehicleRecordsArrayList;
    Context context;

    public FirebaseAdapter(ArrayList<StudentRecords> studentRecordsArrayList, Context context) {
        this.vehicleRecordsArrayList = studentRecordsArrayList;
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
        holder.Name.setText(vehicleRecordsArrayList.get(position).getName());
        holder.city.setText(vehicleRecordsArrayList.get(position).getDept());
        holder.color.setText(vehicleRecordsArrayList.get(position).getReg_no());
        holder.cc.setText(vehicleRecordsArrayList.get(position).getCgpa());
        holder.model.setText(vehicleRecordsArrayList.get(position).getEmail());

        System.out.println(vehicleRecordsArrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return vehicleRecordsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Name, city, color, cc, model;
        ImageView imageView;
        public ViewHolder(@NonNull View view) {
            super(view);
            Name = view.findViewById(R.id.txtname);
            city = view.findViewById(R.id.txtdept);
            color = view.findViewById(R.id.txtregno);
            cc = view.findViewById(R.id.txtcgpa);
            model = view.findViewById(R.id.txtemail);
        }
    }
}
