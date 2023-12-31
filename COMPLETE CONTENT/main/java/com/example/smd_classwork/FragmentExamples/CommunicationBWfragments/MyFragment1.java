package com.example.smd_classwork.FragmentExamples.CommunicationBWfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smd_classwork.R;

public class MyFragment1 extends Fragment {
    ButtonPressListener.OnButtonPressListener buttonPressListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListener = (ButtonPressListener.OnButtonPressListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragmentonelayout, container, false);
       myFunction(viewGroup);
       return viewGroup;
    }

    private void myFunction(ViewGroup viewGroup) {
        TextView textView = viewGroup.findViewById(R.id.fragmentonecontextview);
        textView.setOnClickListener(new View.OnClickListener() {//click listener of textview
            @Override
            public void onClick(View view) {
                buttonPressListener.onButtonPressed("Message from fragment 1...");

            }
        });
    }
}
