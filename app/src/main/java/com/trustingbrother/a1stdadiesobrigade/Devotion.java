package com.trustingbrother.a1stdadiesobrigade;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

@SuppressWarnings("ALL")
public class Devotion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    WebView webView;
    ProgressBar progressBar;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;
    Button button;
    AdView mAdView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devotion);
        setTitle("Devotion");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        webView = findViewById(R.id.devotionVideosweb);
        progressBar = findViewById(R.id.devotionvideoprogress);
        relativeLayout = findViewById(R.id.devotionvideoerror8);
        button = findViewById(R.id.devotionvideorefresh);
        swipeRefreshLayout = findViewById(R.id.devotionvideoswiperefreshlayout);

        button.setOnClickListener(v -> {
            if (!CheckConnection.checkInternetConnection(Devotion.this)) {
                relativeLayout.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.devotionvideorel),"No Network Connection",Snackbar.LENGTH_LONG);
                snackbar.show();
                //webView.loadUrl("file:///android_asset/HTMLF/error.html");
                //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            } else {
                relativeLayout.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                webView.reload();
            }
        });


        swipeRefreshLayout.setOnRefreshListener(() -> webView.reload());

        webView.setWebViewClient(new Devotion.Browser_Home());
        webView.setWebChromeClient(new Devotion.ChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAppCacheEnabled(true);
        if(!CheckConnection.checkInternetConnection(this)){
            progressBar.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.INVISIBLE);
            relativeLayout.setVisibility(View.VISIBLE);
            Snackbar snackbar = Snackbar.make(findViewById(R.id.devotionvideorel),"No Network Connection",Snackbar.LENGTH_LONG);
            snackbar.show();
            // Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.INVISIBLE);
            loadWebSite();
        }


    }

    private void loadWebSite() {
        webView.loadUrl("https://1stdadiesobrigadedevotion.blogspot.com/");
    }

    private class Browser_Home extends WebViewClient {
        Browser_Home(){}

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar = findViewById(R.id.devotionvideoprogress);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar = findViewById(R.id.devotionvideoprogress);
            progressBar.setVisibility(View.GONE);
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            if(!CheckConnection.checkInternetConnection(Devotion.this)){
                progressBar.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                //webViewmore.loadUrl("file:///android_asset/HTMLF/error.html");
                //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            if(!CheckConnection.checkInternetConnection(Devotion.this)){
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
    }

    private class ChromeClient extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        ChromeClient() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
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
                relativeLayout.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.devotionvideorel),"No Network Connection",Snackbar.LENGTH_LONG);
                snackbar.show();
                //webView.loadUrl("file:///android_asset/HTMLF/error.html");
                //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            } else {
                relativeLayout.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                webView.reload();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}