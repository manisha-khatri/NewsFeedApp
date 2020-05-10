package com.example.newsfeedapp.network;

import com.example.newsfeedapp.constants.GenericConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Client {
    private static Retrofit retrofit;
    private Retrofit2Client(){}

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(GenericConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
