package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class new41 extends AppCompatActivity {
WebView webView;
    @Override
    @SuppressWarnings("All")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new41);
        setTitle("The good samaritan");

        webView = findViewById(R.id.new41webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webView.loadUrl("file:///android_asset/Newtest/new41.html");
        }
        }