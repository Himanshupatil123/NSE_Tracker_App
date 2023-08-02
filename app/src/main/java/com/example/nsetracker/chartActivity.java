package com.example.nsetracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class chartActivity extends AppCompatActivity {

    WebView webview;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

    webview=(WebView) findViewById(R.id.chartWebview);


    Intent intent=getIntent();
    String appendstr=intent.getStringExtra("name");

    appendstr=appendstr.toLowerCase();

    appendstr=appendstr.replaceAll(" ","_");
        appendstr=appendstr.replaceAll("-","_");


/*
    if(appendstr.equals("nifty 50"))
        appendstr="nifty";
*/

        String url="https://in.tradingview.com/chart/?symbol=NSE%3A"+appendstr;

        Toast.makeText(this,url,Toast.LENGTH_LONG).show();

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });

        webview.loadUrl(url);
    }

    public void onBackPressed() {
        if(webview.canGoBack())
        {
            webview.goBack();
        }
        else
            super.onBackPressed();
    }

}