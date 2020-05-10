package com.example.newsfeedapp.presenter;

import com.example.newsfeedapp.constants.GenericConstants;
import com.example.newsfeedapp.contract.NewsContract;
import com.example.newsfeedapp.model.News;
import com.example.newsfeedapp.network.APINewsRepository;
import com.example.newsfeedapp.network.APINewsRepositoryImpl;
import com.example.newsfeedapp.network.APIResponseCallBack;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class NewsPresenter {
    private final NewsContract contract;
    APINewsRepository apiNewsRepository;

    public NewsPresenter(NewsContract contract){
        this.contract = contract;
    }

    public void fetchNews(String source){
        apiNewsRepository = new APINewsRepositoryImpl();
        apiNewsRepository.fetchNewsForSource(new APIResponseCallBack() {
            @Override
            public void onSuccessfulResponse(Call<News> call, Response<News> response) {
                validateSuccessfulResponse(call, response);
            }

            @Override
            public void onFailureResponse(Call<News> call, Throwable t) {
                validateFailureResponse(call, t);
            }
        }, source,"en");
    }

    private void validateSuccessfulResponse(Call<News> call, Response<News> response){
        if (response.isSuccessful()) {
            News news = response.body();
            if (news.getTotalResults() > 0) {
                contract.displayNews(news);
            } else {
                contract.displayErrorMessage(GenericConstants.No_news_found);
            }
        }
        else{
            contract.displayErrorMessage(GenericConstants.Internal_server_error);
        }
    }

    private void validateFailureResponse(Call<News> call, Throwable t){
        if(t instanceof IOException){
            contract.displayErrorMessage(GenericConstants.Network_error);
        }
        else{
            contract.displayErrorMessage(GenericConstants.Converter_error);
        }
    }

}
