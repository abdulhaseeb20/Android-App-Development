package com.example.smd_classwork.FragmentExamples.StaticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smd_classwork.R;

public class DetailsFragment extends Fragment {
    public TextView textView;
    int currentIndex = -1;
    int arrayLength;

    public int getShownIndex()
    {
        return currentIndex;
    }
    public void ContactIndex(int position)
    {
        if(position < 0 || position >= arrayLength)
        {
            return;
        }
        currentIndex = position;
        textView.setText(StaticFragmentMainActivity.detailsArray[position]);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactdetails, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = getActivity().findViewById(R.id.contactdetailtextview);
        arrayLength = StaticFragmentMainActivity.detailsArray.length;
    }
}
