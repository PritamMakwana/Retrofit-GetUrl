
package com.example.retrofitgeturldemo.activity.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimeResponse {

    @SerializedName("request_hash")
    @Expose
    private String requestHash;
    @SerializedName("request_cached")
    @Expose
    private Boolean requestCached;
    @SerializedName("request_cache_expiry")
    @Expose
    private Integer requestCacheExpiry;
    @SerializedName("API_DEPRECATION")
    @Expose
    private Boolean apiDeprecation;
    @SerializedName("API_DEPRECATION_DATE")
    @Expose
    private String apiDeprecationDate;
    @SerializedName("API_DEPRECATION_INFO")
    @Expose
    private String apiDeprecationInfo;
    @SerializedName("results")
    @Expose
    private Result[] results = null;
    @SerializedName("last_page")
    @Expose
    private Integer lastPage;

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public Boolean getRequestCached() {
        return requestCached;
    }

    public void setRequestCached(Boolean requestCached) {
        this.requestCached = requestCached;
    }

    public Integer getRequestCacheExpiry() {
        return requestCacheExpiry;
    }

    public void setRequestCacheExpiry(Integer requestCacheExpiry) {
        this.requestCacheExpiry = requestCacheExpiry;
    }

    public Boolean getApiDeprecation() {
        return apiDeprecation;
    }

    public void setApiDeprecation(Boolean apiDeprecation) {
        this.apiDeprecation = apiDeprecation;
    }

    public String getApiDeprecationDate() {
        return apiDeprecationDate;
    }

    public void setApiDeprecationDate(String apiDeprecationDate) {
        this.apiDeprecationDate = apiDeprecationDate;
    }

    public String getApiDeprecationInfo() {
        return apiDeprecationInfo;
    }

    public void setApiDeprecationInfo(String apiDeprecationInfo) {
        this.apiDeprecationInfo = apiDeprecationInfo;
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

}
