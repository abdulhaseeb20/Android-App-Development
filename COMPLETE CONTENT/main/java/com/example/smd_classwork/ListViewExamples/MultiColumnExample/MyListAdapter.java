package com.example.smd_classwork.ListViewExamples.MultiColumnExample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smd_classwork.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListAdapter extends BaseAdapter
{
    ArrayList<HashMap<String, String>> arrayList;
    public static final String FirstColumn = "first";
    public static final String SecondColumn = "second";
    public static final String ThirdColumn = "third";
    Activity activity;

    public MyListAdapter(ArrayList<HashMap<String, String>> arrayList, Activity activity)
    {
        this.arrayList = arrayList;
        this.activity = activity;
    }

    @Override
    public int getCount()
    {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
       LayoutInflater inflater = activity.getLayoutInflater();//attach java class with a layout
        ViewHolder viewHolder = new ViewHolder();
        if (view == null)
        {
            view = inflater.inflate(R.layout.threecolumnnewlayout, null);
            viewHolder.textView1 = view.findViewById(R.id.txtmcone);
            viewHolder.textView2 = view.findViewById(R.id.txtmctwo);
            viewHolder.textView3 = view.findViewById(R.id.txtmcthree);
            view.setTag(viewHolder);

        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap = arrayList.get(position);
        viewHolder.textView1.setText(hashMap.get(FirstColumn));
        viewHolder.textView2.setText(hashMap.get(SecondColumn));
        viewHolder.textView3.setText(hashMap.get(ThirdColumn));
        return view;
    }


    public class ViewHolder
    {
        TextView textView1, textView2, textView3;

    }
}

