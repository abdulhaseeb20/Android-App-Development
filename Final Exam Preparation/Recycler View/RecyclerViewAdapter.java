package com.example.smd_classwork.RecyclerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smd_classwork.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>
{
    private ArrayList<Mobile> mobileArrayList;

    public RecyclerViewAdapter(ArrayList<Mobile> mobileArrayList)
    {
        this.mobileArrayList = mobileArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_row, parent, false);
        //viewHolder obj = new viewHolder(view);
        //return obj;
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        Mobile mobile = mobileArrayList.get(position);
        holder.MobileName.setText(mobile.getName());
        holder.MobileCompany.setText(mobile.getCompany());
        holder.MobilePrice.setText(mobile.getPrice());


    }

    @Override
    public int getItemCount()
    {
        return mobileArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView MobileName, MobileCompany, MobilePrice;

        public viewHolder(@NonNull View v) {
            super(v);
            MobileName = v.findViewById(R.id.txtmobilename);
            MobileCompany = v.findViewById(R.id.txtmobilecompany);
            MobilePrice = v.findViewById(R.id.txtmobileprice);


        }
    }
}
