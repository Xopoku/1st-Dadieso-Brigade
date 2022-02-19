package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class new39 extends AppCompatActivity {
WebView webView;
@SuppressWarnings("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new39);
        setTitle("Jesus heals a man born blind");

    webView = findViewById(R.id.new39webview);
    WebSettings webSettings = webView.getSettings();
    webSettings.getAllowFileAccess();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setAllowFileAccess(true);
    webSettings.setAllowContentAccess(true);
    webSettings.setSupportZoom(true);
    webSettings.setBuiltInZoomControls(true);
    webSettings.setDisplayZoomControls(false);
    webView.loadUrl("file:///android_asset/Newtest/new39.html");
}
}