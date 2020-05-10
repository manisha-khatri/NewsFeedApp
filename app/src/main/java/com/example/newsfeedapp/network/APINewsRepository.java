package com.example.newsfeedapp.network;

public interface APINewsRepository {
    void fetchNewsForSource(APIResponseCallBack apiResponseCallBack, String domain, String language);
}
