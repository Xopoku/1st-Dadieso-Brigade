package com.trustingbrother.a1stdadiesobrigade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class explorerwebview extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
ProgressBar progressBar;
WebView webView;
RelativeLayout relativeLayout;
    @SuppressLint("setJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explorerwebview);
        setTitle("Explorer Girls' Profile");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        relativeLayout = findViewById(R.id.explorererror);
        progressBar = findViewById(R.id.explorereprogress);
        webView = findViewById(R.id.explorereweb);
        //fbwebview.loadUrl("https://web.facebook.com/groups/344081619281118/");
        WebSettings webSettings = webView.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        if(!CheckConnection.checkInternetConnection(this)){
            //webView.loadUrl("file:///android_asset/HTMLF/error.html");
            progressBar.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.INVISIBLE);
            relativeLayout.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.INVISIBLE);
            webView.loadUrl("https://sites.google.com/view/explorergirls/home");
        }


        webView.setWebChromeClient(new WebChromeClient(){

        });


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar = findViewById(R.id.explorereprogress);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar = findViewById(R.id.explorereprogress);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                if(!CheckConnection.checkInternetConnection(explorerwebview.this)){
                    progressBar.setVisibility(View.INVISIBLE);
                    webView.setVisibility(View.INVISIBLE);
                    relativeLayout.setVisibility(View.VISIBLE);
                    //webView.loadUrl("file:///android_asset/HTMLF/error.html");
                    //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                if(!CheckConnection.checkInternetConnection(explorerwebview.this)){
                    relativeLayout.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    //reportwebview.loadUrl("file:///android_asset/HTMLF/error.html");
                }
                if (errorCode == ERROR_TIMEOUT) {
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    webView.setVisibility(View.INVISIBLE);
                }

                else if(errorCode == ERROR_CONNECT){
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    webView.setVisibility(View.INVISIBLE);
                }

                else if(errorCode == ERROR_BAD_URL){
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    webView.setVisibility(View.INVISIBLE);
                }

                else if(errorCode == ERROR_FILE || errorCode == ERROR_FILE_NOT_FOUND){
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    webView.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_refresh,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            if (!CheckConnection.checkInternetConnection(this)) {
                progressBar.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                //webView.loadUrl("file:///android_asset/HTMLF/error.html");
                Toast.makeText(getApplicationContext(), "No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            } else {
                progressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.INVISIBLE);
                webView.reload();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}