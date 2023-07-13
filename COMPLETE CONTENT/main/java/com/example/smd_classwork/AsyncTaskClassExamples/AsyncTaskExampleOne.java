package com.example.smd_classwork.AsyncTaskClassExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.smd_classwork.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class AsyncTaskExampleOne extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_example_one);
        imageView = findViewById(R.id.imgasynctask);
    }

    public void Download_Image(View view)
    {
        String imageLink = "https://static.guim.co.uk/sys-images/Books/Pix/pictures/2013/12/19/1387464412548/fluffy-cats-009.jpg";
        DownloadImage obj = new DownloadImage();
        try {
           Bitmap bitmap = obj.execute(imageLink).get();
           imageView.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap>//Bitmap is return value that server will return
    {
        @Override
        //return type upr wly parameter(Bitmap) ke accrding hoga
        protected Bitmap doInBackground(String... strings)
        {
            try
            {
                URL url = new URL(strings[0]);
                try
                {
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    Log.d("TAG", "doInBackground in progress");
                    return bitmap;
                } catch (IOException e)
                {
                    throw new RuntimeException(e);

                }
            } catch (MalformedURLException e)
            {
                throw new RuntimeException(e);
            }

        }
    }
}