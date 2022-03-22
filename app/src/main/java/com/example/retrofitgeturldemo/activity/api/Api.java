package com.example.retrofitgeturldemo.activity.api;

import android.annotation.SuppressLint;

import androidx.annotation.ArrayRes;

import com.example.retrofitgeturldemo.activity.model.AnimeResponse;
import com.example.retrofitgeturldemo.activity.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("anime")
    Call<AnimeResponse> getAllAnime(@Query("q") String search);



}
