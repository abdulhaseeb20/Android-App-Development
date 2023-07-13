package com.example.smd_classwork.FragmentExamples.CommunicationBWfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smd_classwork.R;

public class MyFragment2 extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentonelayout, container, false);
        return view;
    }

    public void onFragmentInteraction(String message)
    {
        TextView textView1 = view.findViewById(R.id.fragmentonecontextview);
        textView1.setText(message);
    }
}
