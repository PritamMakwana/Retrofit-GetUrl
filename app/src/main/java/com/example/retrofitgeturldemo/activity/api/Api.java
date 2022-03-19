package com.example.retrofitgeturldemo.activity.api;

import android.util.Log;

import com.example.retrofitgeturldemo.activity.model.ModelAnime;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

//    @Headers({"application-id: MY-APPLICATION-ID",
//            "secret-key: MY-SECRET-KEY",
//            "application-type: REST"})
    @GET("anime?q=naruto")
    Call<ArrayList<ModelAnime>> getAllAnime();

}
