package com.example.smd_classwork.RestAPIExamples;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    public static Retrofit retrofit;
    public static String url = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getRetrofit()
    {
        if (retrofit == null)
        {
            retrofit =  new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
