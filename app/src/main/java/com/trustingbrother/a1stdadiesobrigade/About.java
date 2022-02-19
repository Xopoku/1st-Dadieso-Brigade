package com.trustingbrother.a1stdadiesobrigade;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
WebView mwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About the Developer");

        mwebview = findViewById(R.id.aboutweb);
        mwebview.loadUrl("file:///android_asset/HTMLF/about.html");
        WebSettings webSettings = mwebview.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
       mwebview.setWebViewClient(new WebViewClient(){
           @Override
           public boolean shouldOverrideUrlLoading(WebView view, String url) {
               view.loadUrl(url);
               if (url.startsWith("tel:")) {
                   mwebview.stopLoading();
                   Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                   startActivity(intent);
                   return true;
               }
               else  if (url.startsWith("mailto:")){
                   mwebview.stopLoading();
                   startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(url)));
                   return true;
               }

               else {
                   return false;
               }


           }
       });

    }
}
