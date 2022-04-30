package com.example.retrofitgeturldemo.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitgeturldemo.R;
import com.example.retrofitgeturldemo.activity.adapter.AdapterAnime;
import com.example.retrofitgeturldemo.activity.adapter.RetrofitAnime;
import com.example.retrofitgeturldemo.activity.api.Api;
import com.example.retrofitgeturldemo.activity.model.AnimeResponse;
import com.example.retrofitgeturldemo.activity.model.Result;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity implements AdapterAnime.onAnimeClickListener{

    public TextView mNameInput;
    private Button mSubmitButton;
    public RecyclerView mViewRecycler;
    public AdapterAnime mAnimeAdapter;
    ArrayList<Result> mResult;
    public String mAnimeNamepass;//Url;
    Call<AnimeResponse> call;
    public String mSendName;
    Boolean mEnter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d("done","homeactivity onCreate 1");


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.drak));
        }

        mNameInput = findViewById(R.id.et_input);
        mSubmitButton = findViewById(R.id.btn_submit);
        mViewRecycler = findViewById(R.id.rv_item);


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Url = "https://api.jikan.moe/v3/search/anime?q="+mAnimeNamepass;
                if(mNameInput.getText().toString().equals("")){
                    Toast.makeText(HomeActivity.this,"pleses enter Anime name ",Toast.LENGTH_LONG).show();
                    Log.d("ok","input null "  );
                }else{
                    mSendName = mNameInput.getText().toString();
                    mAnimeNamepass = mNameInput.getText().toString();
                    Api  api = RetrofitAnime.getmRetrofitAnime().create(Api.class);
                    call= api.getAllAnime(mAnimeNamepass);//naruto
                    showAnimesDetalis();
                }
            }
        });
    }

    private void showAnimesDetalis() {
        call.enqueue(new Callback<AnimeResponse>() {
            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {

                try {
                    AnimeResponse animeResponse = response.body();
                    mResult = new ArrayList<>(Arrays.asList(animeResponse.getResults()));
                    getAnimeDatashow(mResult);
                }catch (Exception e){
                    Toast.makeText(HomeActivity.this, " ! pleses enter right Anime name" , Toast.LENGTH_SHORT).show();
                    Log.d("ok", " Exception inter ");
                }
            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "error in respones (internet)" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ok", "response falied " + t.getMessage());
            }
        });
    }

    private void getAnimeDatashow(ArrayList<Result> body) {
        mAnimeAdapter = new AdapterAnime( body,HomeActivity.this,this::onAnimeClick);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mViewRecycler.setLayoutManager(layoutManager);
        mViewRecycler.setAdapter(mAnimeAdapter);

    }

    @Override
    public void onAnimeClick(String mName,String mUrlPhoto,String mInformation) {
        Intent intent = new Intent(HomeActivity.this,InfoItemActivity.class);
        intent.putExtra("name",mName);
        intent.putExtra("photo",mUrlPhoto);
        intent.putExtra("information",mInformation);
        intent.putExtra("req",mSendName);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mEnter = getIntent().getBooleanExtra("pass",false);
        if(mEnter==true) {
            mSendName = getIntent().getStringExtra("rep");
            mNameInput.setText(mSendName);
            mAnimeNamepass = mNameInput.getText().toString();
            Api  api = RetrofitAnime.getmRetrofitAnime().create(Api.class);
            call= api.getAllAnime(mAnimeNamepass);//naruto
            showAnimesDetalis();
        }
        Log.d("done","homeactivity onResume 3 ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("done","homeactivity onStart 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("done","homeactivity onPause 4");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("done","homeactivity onStop 5");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("done","homeactivity onRestart 6");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("done","homeactivity onDestroy 7");
    }
}


