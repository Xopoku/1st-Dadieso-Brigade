package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class new45 extends AppCompatActivity {
WebView webView;
@SuppressWarnings("All")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new45);
        setTitle("Jesus in Jerusalem for the Passover");


    webView = findViewById(R.id.new45webview);
    WebSettings webSettings = webView.getSettings();
    webSettings.getAllowFileAccess();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setAllowFileAccess(true);
    webSettings.setAllowContentAccess(true);
    webSettings.setSupportZoom(true);
    webSettings.setBuiltInZoomControls(true);
    webSettings.setDisplayZoomControls(false);
    webView.loadUrl("file:///android_asset/Newtest/new45.html");
}
}