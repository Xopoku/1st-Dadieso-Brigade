package com.trustingbrother.a1stdadiesobrigade;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Appmanual extends AppCompatActivity {
WebView appmanual;
AdView mAdView;
@SuppressLint("setJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appmanual);
        setTitle("The App Manual");
    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

        appmanual = findViewById(R.id.appmanualapp);
        appmanual.loadUrl("file:///android_asset/HTMLF/Appmanual.html");
        WebSettings webSettings = appmanual.getSettings();
        webSettings.getAllowFileAccess();
        appmanual.setWebViewClient(new WebViewClient());
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        appmanual.setWebChromeClient(new WebChromeClient(){

        });

    }

    @Override
    public void onBackPressed() {
    if(appmanual.canGoBack()){
        appmanual.goBack();
    }
    else{
        super.onBackPressed();
    }

    }
}
