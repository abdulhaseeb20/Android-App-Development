package com.example.smd_classwork.AsyncTaskClassExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.smd_classwork.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class DownloadWebContent extends AppCompatActivity
{
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_web_content);
        textView = findViewById(R.id.txtasynctask);
    }

    public void Download_Web_Content(View view)
    {
        DownloadMyWebContent obj = new DownloadMyWebContent();
        try
        {
            String webContent = obj.execute("https://www.google.com/").get();
            textView.setText(webContent);
            Log.d("TAG", "Back in Main");
        } catch (ExecutionException e)
        {
            throw new RuntimeException(e);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public class DownloadMyWebContent extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... strings)
        {
            Log.d("TAG", "doInBackground in progress");
            try
            {
                URL url = new URL(strings[0]);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();
                String webcontent = "";
                while(data != -1)
                {
                    char ch = (char) data;
                    webcontent += ch;
                    data = reader.read();

                }
                return webcontent;
            } catch (MalformedURLException e)
            {
                throw new RuntimeException(e);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}