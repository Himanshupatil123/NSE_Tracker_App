package com.example.nsetracker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class option extends AppCompatActivity {

    WebView webView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        webView=findViewById(R.id.webView);

        String url="https://www.nseindia.com/option-chain";
       // String url="https://in.tradingview.com/chart/?symbol=NSE%3ANIFTY";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });



      //  webView.loadUrl("http://www.teluguoneradio.com/rssHostDescr.php?hostId=147");


        webView.loadUrl(url);

        //webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
            super.onBackPressed();
    }
}