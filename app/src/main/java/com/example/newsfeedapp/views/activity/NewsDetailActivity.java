package com.example.newsfeedapp.views.activity;

import android.os.Bundle;
import android.webkit.WebView;
import com.example.newsfeedapp.R;
import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        openWebView(getValueFromIntent("URL"));
    }

    private void openWebView(String url ){
        WebView webView = findViewById(R.id.webview);
        webView.loadUrl(url);
    }

    private String getValueFromIntent(String key) {
        return (getIntent().hasExtra(key)) ? getIntent().getStringExtra(key) : "https://www.google.com/";
    }
}