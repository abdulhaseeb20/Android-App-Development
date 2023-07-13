package com.example.smd_classwork.CardViewExample;

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

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<My_Model> modelArrayList;

    public CardViewAdapter(Context context, ArrayList<My_Model> modelArrayList)
    {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //receive data and pass it to the 3 widgets created(image count etc)
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {

        My_Model my_model = modelArrayList.get(position);
        holder.name.setText(my_model.getName());
        holder.count.setText(String.valueOf(my_model.getCount()));
        Glide.with(context).load(my_model.getThumbnails()).into(holder.thumbnails);
    }

    @Override
    public int getItemCount()
    {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView thumbnails;
        TextView name, count;
        public ViewHolder(@NonNull View v)
        {
            super(v);
            thumbnails = v.findViewById(R.id.imgcardview);
            name = v.findViewById(R.id.txt1_cardview);
            count = v.findViewById(R.id.txt2cardview);
        }
    }
}
