package com.example.assignment04;

import android.graphics.Bitmap;

public interface ImageDownloadListener {
    void onImageDownloaded(Bitmap bitmap);
    void onImageDownloadError(String message);
}
