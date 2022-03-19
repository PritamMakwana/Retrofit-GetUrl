package com.example.retrofitgeturldemo.activity.json;

import com.example.retrofitgeturldemo.activity.model.ModelAnime;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Response;

public class JsonAnime {

    List<ModelAnime> animeList;
    private JSONObject jsonObject;
    private ArrayList<ModelAnime> json;
    private static String[] sName;
    private static String[] sType;
    private static Integer[] sEpisodes;
    private  static Float[] sScore;
    private static  String[] sDescription;
    private static String[] sImageUrl;

//    public JsonAnime(Response<ArrayList<ModelAnime>> response) {
//        this.json = response;
//
//    }

    public JsonAnime(ArrayList<ModelAnime> body) {
        this.json = body;
    }
//
//
//    public JsonAnime(String json) {
//        this.json = json;
//    }

    protected void JsonAnime() {
      try{
          jsonObject = new JSONObject(String.valueOf(json));
          JSONArray jsonArray = jsonObject.getJSONArray("results");

          sName = new String[jsonObject.length()];
          sType = new String[jsonObject.length()];
          sEpisodes = new Integer[jsonObject.length()];
          sScore = new Float[jsonObject.length()];
          sDescription = new String[jsonObject.length()];
          sImageUrl = new String[jsonObject.length()];

          animeList = new ArrayList<>();

          for(int i = 0 ; i <jsonArray.length(); i++){

              ModelAnime anime = new ModelAnime();

              JSONObject object = jsonArray.getJSONObject(i);

              anime.setmName(object.getString("title"));
              anime.setmType(object.getString("type"));
              anime.setmEpisodes(object.getInt("episodes"));
              anime.setmScore((float) object.getDouble("score"));
              anime.setmDescription(object.getString("synopsis"));
              anime.setmImage(object.getString("image_url"));

              animeList.add(anime);

          }

      }catch (JSONException e){
               e.printStackTrace();
      }
    }




    ArrayList<ModelAnime> getLenghtOnArray(){
        return (ArrayList<ModelAnime>) animeList;
    }

}
