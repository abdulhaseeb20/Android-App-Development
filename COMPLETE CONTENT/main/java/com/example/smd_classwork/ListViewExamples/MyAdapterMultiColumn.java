package com.example.smd_classwork.ListViewExamples;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smd_classwork.R;

public class MyAdapterMultiColumn extends ArrayAdapter<String> {
    Activity activity;
    String[] Name;
    String[] Text;
    int[] Image;

    public MyAdapterMultiColumn(@NonNull Activity activity, String[] name, String[] text, int[] image) {
        super(activity, R.layout.imageandtext, text);
        this.activity = activity;
        Name = name;
        Text = text;
        Image = image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View viewHolder = inflater.inflate(R.layout.imageandtext, null);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView name = viewHolder.findViewById(R.id.txtname);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView text = viewHolder.findViewById(R.id.txtmessage);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = viewHolder.findViewById(R.id.imglistview);
        name.setText(Name[position]);
        name.setText(Text[position]);
        imageView.setImageResource(Image[position]);
        return viewHolder;
    }
}
