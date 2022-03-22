package com.example.retrofitgeturldemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitgeturldemo.R;
import com.example.retrofitgeturldemo.activity.adapter.AdapterAnime;
import com.example.retrofitgeturldemo.activity.adapter.RetrofitAnime;
import com.example.retrofitgeturldemo.activity.api.Api;
import com.example.retrofitgeturldemo.activity.model.AnimeResponse;
import com.example.retrofitgeturldemo.activity.model.Result;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    public TextView mNameInput;
    private Button mSubmitButton;
    public RecyclerView mViewRecycler;
    public AdapterAnime mAnimeAdapter;
    ArrayList<Result> mResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNameInput = findViewById(R.id.tv_name);
        mSubmitButton = findViewById(R.id.btn_submit);
        mViewRecycler = findViewById(R.id.rv_item);



        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });


        Api  api = RetrofitAnime.getmRetrofitAnime().create(Api.class);
            Log.d("ok"," api");

        Log.d("ok","api connection " );

        Call<AnimeResponse> call= api.getAllAnime("naruto");

        Log.d("ok","call with api and restadpter " );

        call.enqueue(new Callback<AnimeResponse>() {

            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {

                    AnimeResponse animeResponse = response.body();
                    mResult = new ArrayList<>(Arrays.asList(animeResponse.getResults()));
                    getAnimeDatashow(mResult);

            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "error  in respones " + t.getMessage(), Toast.LENGTH_SHORT).show();
               Log.d("ok","response falied " + t.getMessage() );
            }
        });


    }

    private void getAnimeDatashow(ArrayList<Result> body) {
        mAnimeAdapter = new AdapterAnime( body,HomeActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mViewRecycler.setLayoutManager(layoutManager);
        mViewRecycler.setAdapter(mAnimeAdapter);
        mAnimeAdapter.notifyDataSetChanged();

    }
}