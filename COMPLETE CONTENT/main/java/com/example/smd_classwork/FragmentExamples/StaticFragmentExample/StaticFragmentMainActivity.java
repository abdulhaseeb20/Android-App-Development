package com.example.smd_classwork.FragmentExamples.StaticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smd_classwork.R;

public class StaticFragmentMainActivity extends AppCompatActivity implements ContactsFragment.ListSelectionListener{
    public static String[] contactsArray;
    public static String[] detailsArray;
    DetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment_main);
        contactsArray = getResources().getStringArray(R.array.contacts_array);
        detailsArray = getResources().getStringArray(R.array.details_array);
        detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsfragment);
    }

    @Override
    public void onSelection(int position) {
        if(detailsFragment.getShownIndex() != position)
        {
            detailsFragment.ContactIndex(position);
        }
    }
}