package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class new30 extends AppCompatActivity {
WebView webView;
@SuppressWarnings("ALL")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new30);
        setTitle("Jesus heals the sick");

    webView = findViewById(R.id.new30webview);
    WebSettings webSettings = webView.getSettings();
    webSettings.getAllowFileAccess();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setAllowFileAccess(true);
    webSettings.setAllowContentAccess(true);
    webSettings.setSupportZoom(true);
    webSettings.setBuiltInZoomControls(true);
    webSettings.setDisplayZoomControls(false);
    webView.loadUrl("file:///android_asset/Newtest/new30.html");
}
}