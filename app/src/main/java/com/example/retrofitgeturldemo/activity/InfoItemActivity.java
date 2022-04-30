package com.example.retrofitgeturldemo.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.retrofitgeturldemo.R;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.internal.Utils;

public class InfoItemActivity extends AppCompatActivity {
    ImageView sbackImg,mAnimePhoto;
    TextView mShowName,mInformation;
    public String mReciName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_item);
        Log.d("done","activity onCreate 1 ");

        sbackImg = findViewById(R.id.img_back);
        mAnimePhoto = findViewById(R.id.img_showitem);
        mShowName = findViewById(R.id.tv_showname);
        mInformation = findViewById(R.id.tv_showDescription);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.drak));
        }

        sbackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoItemActivity.this,HomeActivity.class);
                intent.putExtra("rep",mReciName);
                intent.putExtra("pass",true);
                startActivity(intent);
            }
        });

        mShowName.setText(getIntent().getStringExtra("name"));
        mInformation.setText(getIntent().getStringExtra("information"));
        mReciName = getIntent().getStringExtra("req");

        DrawableCrossFadeFactory factory =
                new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        String mUrl = getIntent().getStringExtra("photo");

        Glide.with(getApplicationContext())
                .load(mUrl)
                .placeholder(R.drawable.load)
                .error(R.drawable.error)
                .transform(new RoundedCorners(50))
                .transition( DrawableTransitionOptions.withCrossFade(factory))
                .into(mAnimePhoto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("done","activity onResume 3 ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("done","activity onStart 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("done","activity onPause 4");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("done","activity onStop 5");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("done","activity onRestart 6");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("done","activity onDestroy 7");
    }
}