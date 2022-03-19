package com.example.retrofitgeturldemo.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelAnime {

    @SerializedName("title")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("episodes")
    private Integer mEpisodes;
    @SerializedName("score")
    private Float mScore;
    @SerializedName("synopsis")
    private String mDescription;
    @SerializedName("image_url")
    private String mImage;
    @SerializedName("results")
    private List mList;

    public ModelAnime(String mName, String mType, Integer mEpisodes, Float mScore, String mDescription, String mImage, List mList) {
        this.mName = mName;
        this.mType = mType;
        this.mEpisodes = mEpisodes;
        this.mScore = mScore;
        this.mDescription = mDescription;
        this.mImage = mImage;
        this.mList = mList;
    }

    public ModelAnime() {

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public Integer getmEpisodes() {
        return mEpisodes;
    }

    public void setmEpisodes(Integer mEpisodes) {
        this.mEpisodes = mEpisodes;
    }

    public Float getmScore() {
        return mScore;
    }

    public void setmScore(Float mScore) {
        this.mScore = mScore;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public List getmList() {
        return mList;
    }

    public void setmList(List mList) {
        this.mList = mList;
    }
}
