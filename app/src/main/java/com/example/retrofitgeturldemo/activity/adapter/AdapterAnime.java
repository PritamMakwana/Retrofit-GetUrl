package com.example.retrofitgeturldemo.activity.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.retrofitgeturldemo.R;
import com.example.retrofitgeturldemo.activity.model.Result;
//import com.jakewharton.picasso.OkHttp3Downloader;


import java.util.ArrayList;

public class AdapterAnime extends RecyclerView.Adapter<AdapterAnime.AnimeViewHolder> {

    private ArrayList<Result> mModelAnimes;
    private Context mContext;
    onAnimeClickListener mOnAnimeClickListener;


    public AdapterAnime(ArrayList<Result> mModelAnimes, Context mContext, onAnimeClickListener mOnAnimeClickListener) {
        this.mModelAnimes = mModelAnimes;
        this.mContext = mContext;
        this.mOnAnimeClickListener = mOnAnimeClickListener;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Result positionAnime = mModelAnimes.get(position);
        holder.mName.setText(positionAnime.getTitle());
        holder.mEpisode.setText("Episodes : " + String.valueOf(positionAnime.getEpisodes()));
        holder.mType.setText("Type : " +positionAnime.getType());


         holder.mRatingBar.setNumStars(5);
         holder.mRatingBar.setMax(5);
         holder.mRatingBar.setStepSize((float) 0.1);
//        LayerDrawable stars = (LayerDrawable) holder.mRatingBar.getProgressDrawable();
//        stars.getDrawable(2).setColorFilter(ContextCompat.getColor(mContext, R.color.Gold), PorterDuff.Mode.SRC_ATOP);
        float num = positionAnime.getScore()/2;
        holder.mRatingBar.setRating(num);

        DrawableCrossFadeFactory factory =
                new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        Glide.with(mContext)
                 .load(positionAnime.getImageUrl())
                 .skipMemoryCache(true)
                 .diskCacheStrategy(DiskCacheStrategy.ALL)
                 .priority(Priority.IMMEDIATE)
                 .placeholder(R.drawable.load)
                 .error(R.drawable.error)
                .transform(new RoundedCorners(50))
                .transition(DrawableTransitionOptions.withCrossFade(factory))
                .into(holder.mImageView);

//        Picasso.Builder builder = new Picasso.Builder(mContext);
//        builder.downloader(new OkHttp3Downloader(mContext));
//        builder.build().load(positionAnime.getImageUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.mImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnAnimeClickListener.onAnimeClick(positionAnime.getTitle(),positionAnime.getImageUrl(),positionAnime.getSynopsis());
            }
        });
    }


    @Override
    public int getItemCount() {
        return mModelAnimes.size();
    }

    public interface onAnimeClickListener {
        void onAnimeClick(String mName,String mUrlPhoto,String mInformation);
    }

    public class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mName,mType,mEpisode;
        RatingBar mRatingBar;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = (itemView).findViewById(R.id.tv_name);
            mType = (itemView).findViewById(R.id.tv_type);
            mEpisode = (itemView).findViewById(R.id.tv_episodes);
            mImageView = (itemView).findViewById(R.id.img_item);
            mRatingBar = (itemView).findViewById(R.id.rb_star);
        }
    }
}
