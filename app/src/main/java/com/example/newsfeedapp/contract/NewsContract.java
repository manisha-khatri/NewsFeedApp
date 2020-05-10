package com.example.newsfeedapp.contract;

import com.example.newsfeedapp.model.News;

public interface NewsContract {
    void displayNews(News news);
    void displayErrorMessage(String errorMsg);
}
