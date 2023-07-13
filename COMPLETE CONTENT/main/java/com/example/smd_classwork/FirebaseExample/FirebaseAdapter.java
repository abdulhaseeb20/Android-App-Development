package com.example.smd_classwork.FirebaseExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smd_classwork.R;

import java.util.ArrayList;

public class FirebaseAdapter extends  RecyclerView.Adapter<FirebaseAdapter.ViewHolder>{

    ArrayList<Fast_Student> studentArrayList;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_list,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(studentArrayList.get(position).getName());
        Glide.with(context).load(studentArrayList.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View view) {
            super(view);
            textView = view.findViewById(R.id.firebasetextview);
            imageView = view.findViewById(R.id.firebaseimageview);

        }
    }

}
