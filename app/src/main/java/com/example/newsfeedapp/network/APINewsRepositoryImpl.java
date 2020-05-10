package com.example.newsfeedapp.network;

import com.example.newsfeedapp.constants.GenericConstants;
import com.example.newsfeedapp.model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APINewsRepositoryImpl implements APINewsRepository {
    APIService apiService;
    Call<News> call;

    public APINewsRepositoryImpl(){
        apiService = Retrofit2Client.getRetrofitInstance().create(APIService.class);
    }

    public void fetchNewsForSource(APIResponseCallBack apiResponseCallBack, String source, String language){
        call = apiService.getNewsForSource(
                source,
                language,
                GenericConstants.API_KEY
        );
        fetchNewsFromServer(call, apiResponseCallBack);
    }

    private void fetchNewsFromServer(Call<News> call, final APIResponseCallBack apiResponseCallBack) {
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                apiResponseCallBack.onSuccessfulResponse(call, response);
            }
            @Override
            public void onFailure(Call<News> call, Throwable t) {
                apiResponseCallBack.onFailureResponse(call,t);
            }
        });
    }

}
