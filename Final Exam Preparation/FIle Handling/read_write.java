package com.example.smd_classwork.FileHandlingExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smd_classwork.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileHandlingExampleOne extends AppCompatActivity
{
    EditText editText;
    TextView textView;
    String Filename = "MyTextFile";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling_example_one);
        editText = findViewById(R.id.edtfilehandling);
        textView = findViewById(R.id.txtfilehandling);
    }

    public void SaveText(View view)
    {
        String EditTextValue = editText.getText().toString();
        //for opening a file
        try
        {
            FileOutputStream outputStream = openFileOutput(Filename, Context.MODE_PRIVATE);
            try
            {
                outputStream.write(EditTextValue.getBytes());
                editText.setText("");
                //snackbar can only run in activity toast can be called anywhere
                Snackbar.make(view, "Data Saved", Snackbar.LENGTH_LONG).show();

            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }


    }

    public void ShowText(View view)
    {
        String ReadData = "";
        try
        {
            FileInputStream inputStream = openFileInput(Filename);//for reading data
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            try
            {
                String value = bufferedReader.readLine();
                if(value == null)
                {
                    Toast.makeText(this, "File is empty", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    while(value != null)
                    {
                        ReadData = ReadData + value;
                        value = bufferedReader.readLine();
                    }
                    textView.setText(ReadData);
                    bufferedReader.close();
                    reader.close();
                    inputStream.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }


    }
}