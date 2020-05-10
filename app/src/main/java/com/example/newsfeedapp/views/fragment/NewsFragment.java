package com.example.newsfeedapp.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.newsfeedapp.R;
import com.example.newsfeedapp.constants.GenericConstants;
import com.example.newsfeedapp.contract.NewsContract;
import com.example.newsfeedapp.model.Article;
import com.example.newsfeedapp.model.News;
import com.example.newsfeedapp.presenter.NewsPresenter;
import com.example.newsfeedapp.views.activity.NewsDetailActivity;
import com.example.newsfeedapp.views.adapter.NewsRecyclerViewAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFragment extends Fragment implements NewsContract, NewsRecyclerViewAdapter.RecyclerViewListener {
    NewsPresenter newsPresenter;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_news, viewGroup, false);
        return rootView;
    }

    public static Fragment getNewsInstance(String source){
        Fragment newsFragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SOURCE", source);
        newsFragment.setArguments(bundle);
        return newsFragment;
    }

    private String getSource() {
        return this.getArguments().getString("SOURCE", GenericConstants.Hindustantimes);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initViews();
        newsPresenter.fetchNews(getSource());  //fetch news by retrofit call
    }

    public void onStart(){
        super.onStart();
    }

    @Override
    public void displayNews(News news) {
        stopLoader();
        displayTopStories(news);
    }

    public void displayTopStories(News news) {
        setNewsInRecyclerViewAdapter(news);
    }

    public void setNewsInRecyclerViewAdapter(News news) {
        NewsRecyclerViewAdapter adapter = new NewsRecyclerViewAdapter(news, getActivity(), this);     //class object, which calls default constructor
        ((RecyclerView)rootView.findViewById(R.id.recycler_view_top_stories)).setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        ((RecyclerView)rootView.findViewById(R.id.recycler_view_top_stories)).setLayoutManager(linearLayoutManager);
    }

    @Override
    public void displayErrorMessage(String errorMsg) {
        showErrorOnFailure(errorMsg);
    }

    void showErrorOnFailure( String errorMsg){
        rootView.findViewById(R.id.top_stories_progress_bar).setVisibility(View.GONE);
        ((TextView)rootView.findViewById(R.id.top_stories_err_msg)).setText(errorMsg);
    }

    @Override
    public void onItemClick(Article article) {
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        intent.putExtra("URL", article.getUrl());
        this.startActivity(intent);
    }

    private void initViews() {
        newsPresenter = new NewsPresenter(this);
    }

    private void stopLoader() {
        rootView.findViewById(R.id.top_stories_progress_bar).setVisibility(View.GONE);
        rootView.findViewById(R.id.top_stories_msg_holder).setVisibility(View.GONE);
    }

}