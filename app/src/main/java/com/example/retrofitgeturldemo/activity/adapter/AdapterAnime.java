package com.example.retrofitgeturldemo.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitgeturldemo.R;
import com.example.retrofitgeturldemo.activity.model.AnimeResponse;
import com.example.retrofitgeturldemo.activity.model.Result;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterAnime extends RecyclerView.Adapter<AdapterAnime.AnimeViewHolder> {

    private ArrayList<Result> mModelAnimes;
    private Context mContext;

    public AdapterAnime(ArrayList<Result> mModelAnimes, Context mContext) {
        this.mModelAnimes = mModelAnimes;
        this.mContext = mContext;
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
        holder.mEpisode.setText(positionAnime.getEpisodes());
        holder.mType.setText(positionAnime.getType());
        holder.mRatingBar.setRating(positionAnime.getScore());

//        Picasso.Builder builder = new Picasso.Builder(mContext);
//        builder.downloader(new OkHttp3Downloader(mContext));
//        builder.build().load(positionAnime.getImageUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mModelAnimes.size();
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
            mRatingBar = (itemView).findViewById(R.id.rb_star);
            mImageView = (itemView).findViewById(R.id.img_item);

        }
    }
}
