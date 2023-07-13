package com.example.assignment04;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloadService {

    private static final String TAG = "ImageDownloadService";

    public void downloadImage(Context context, String imageUrl, ImageDownloadListener listener) {
        new ImageDownloadTask(context, imageUrl, listener).execute();
    }

    private static class ImageDownloadTask extends AsyncTask<Void, Void, Bitmap> {

        private Context context;
        private String imageUrl;
        private ImageDownloadListener listener;
        private String errorMessage;

        public ImageDownloadTask(Context context, String imageUrl, ImageDownloadListener listener) {
            this.context = context;
            this.imageUrl = imageUrl;
            this.listener = listener;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(input);
            } catch (IOException e) {
                errorMessage = e.getMessage();
                Log.e(TAG, errorMessage);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                listener.onImageDownloaded(result);
            } else {
                listener.onImageDownloadError(errorMessage);
            }
        }
    }
}
