package com.example.assignment04;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    int count=0;
    private EditText linkEditText;
    private ImageDownloadService imageDownloadService;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkEditText = findViewById(R.id.link1);
        Button downloadButton = findViewById(R.id.dld1);

        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment_1);
        fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment_2);
        fragment3 = (Fragment3) getSupportFragmentManager().findFragmentById(R.id.fragment_3);
        fragment4 = (Fragment4) getSupportFragmentManager().findFragmentById(R.id.fragment_4);

        imageDownloadService = new ImageDownloadService();

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl = linkEditText.getText().toString();
                if (!TextUtils.isEmpty(imageUrl)) {
                    imageDownloadService.downloadImage(MainActivity.this, imageUrl, new ImageDownloadListener() {
                        @Override
                        public void onImageDownloaded(Bitmap bitmap) {
                            if (bitmap != null) {
                                Toast.makeText(MainActivity.this, "Image Downloded", Toast.LENGTH_SHORT).show();
                                   count++;
                                showImage(bitmap);
                            } else {
                                Toast.makeText(MainActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onImageDownloadError(String message) {
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }


    private void showImage(Bitmap bitmap) {
        if(count==1) {
            if (fragment1.isVisible()) {
                if (fragment1 != null) {
                    fragment1.setImage(bitmap);
                } else {
                    throw new IllegalStateException("fragment1 is null");
                }


            }
        }
        if(count==2) {
            if (fragment2.isVisible()) {
                if (fragment2 != null) {
                    fragment2.setImage(bitmap);
                } else {
                    throw new IllegalStateException("fragment1 is null");
                }
            }
        }
        if(count==3){
        if (fragment3.isVisible()) {
            if (fragment3 != null) {
                fragment3.setImage(bitmap);
            } else {
                throw new IllegalStateException("fragment1 is null");
            }
        } }
        if(count==4) {
            if (fragment4.isVisible()) {
                if (fragment4 != null) {
                    fragment4.setImage(bitmap);
                } else {
                    throw new IllegalStateException("fragment1 is null");
                }
            }
        }
    }
}
