package com.example.retrofitgeturldemo.activity.adapter;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.HttpHeaders;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAnime {

    private static Retrofit mRetrofit;
    private static String BASH_URL ="https://api.jikan.moe/v3/search/";




    public static Retrofit getmRetrofitAnime(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(2000, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS);


        if(mRetrofit==null){
            Log.d("ok","ok m retrofit ");
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASH_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Log.d("ok","ok m retrofit full ");

        }

        return mRetrofit;
    }



}
