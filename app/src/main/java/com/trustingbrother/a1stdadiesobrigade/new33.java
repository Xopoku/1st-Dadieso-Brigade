package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class new33 extends AppCompatActivity {
WebView webView;
    @Override
    @SuppressWarnings("ALL")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new33);
        setTitle("Jesus cast a demon out of a child");


        webView = findViewById(R.id.new33webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webView.loadUrl("file:///android_asset/Newtest/new33.html");
    }
}