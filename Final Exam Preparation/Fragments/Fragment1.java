package com.example.assignment04;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment1 extends Fragment {

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        imageView = view.findViewById(R.id.image_view1);

        if (imageView == null) {
            throw new IllegalStateException("imageView is null");
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageView.getVisibility() == View.VISIBLE) {
                    imageView.setVisibility(View.GONE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }



    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalStateException("bitmap is null");
        }
        if (imageView != null) {


            imageView.setImageBitmap(bitmap);
        } else {
            throw new IllegalStateException("imageView is null");
        }
    }
}
