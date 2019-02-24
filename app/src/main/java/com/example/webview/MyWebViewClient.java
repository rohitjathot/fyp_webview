package com.example.webview;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        if (Uri.parse(url).getHost().equals("https://www.example.com")) {
//            // This is my website, so do not override; let my WebView load the page
//            return false;
//        }
        return false;
    }
}

