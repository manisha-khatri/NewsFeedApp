package com.example.newsfeedapp.network;

import com.example.newsfeedapp.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    //https://newsapi.org/v2/top-headlines?country=in&apiKey=53ad2000d9d243f9b1a7e270275fe3a7
    //https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=53ad2000d9d243f9b1a7e270275fe3a7
    //https://newsapi.org/v2/top-headlines?q=trump&apiKey=53ad2000d9d243f9b1a7e270275fe3a7

    //https://newsapi.org/v2/everything?domains=wsj.com,nytimes.com&apiKey=53ad2000d9d243f9b1a7e270275fe3a7
    /*
        the-times-of-india

     */

    @GET("top-headlines")
    Call<News> getNewsFor(
            @Query("country") String country,
            @Query("language") String language,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<News> getNewsForSource(
            @Query("domains") String source,
            @Query("language") String language,
            @Query("apiKey") String apiKey
    );
}
