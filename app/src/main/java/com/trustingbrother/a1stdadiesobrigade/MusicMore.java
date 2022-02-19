package com.trustingbrother.a1stdadiesobrigade;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;

public class MusicMore extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
WebView webViewmore;
ProgressBar progressBar;
RelativeLayout relativeLayout;
AdView mAdView;
@SuppressLint("setJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_more);
        setTitle("Band Music Library");

    mAdView = findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

        webViewmore = findViewById(R.id.musicmore);
        progressBar = findViewById(R.id.progress2);
        relativeLayout = findViewById(R.id.methodisterror8);
        //webViewmore.loadUrl("https://sites.google.com/view/1stdadieso-band-library/");
        WebSettings webSettings = webViewmore.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        if(!CheckConnection.checkInternetConnection(this)){
            //webViewmore.loadUrl("file:///android_asset/HTMLF/error.html");
            progressBar.setVisibility(View.INVISIBLE);
            webViewmore.setVisibility(View.INVISIBLE);
            relativeLayout.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);
            webViewmore.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.INVISIBLE);
            //webViewmore.loadUrl("https://sites.google.com/view/1stdadieso-band-library/home");
            webViewmore.loadUrl("https://sites.google.com/view/band-materials-page/home");
        }


        downloading();

    webViewmore.setWebChromeClient(new WebChromeClient(){
        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView newWebview = new WebView(MusicMore.this);
            WebSettings webSettings1 = newWebview.getSettings();
            webSettings1.setJavaScriptEnabled(true);
            downloading();

            final Dialog dialog = new Dialog(MusicMore.this);
            dialog.setContentView(newWebview);
            dialog.show();

            newWebview.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    progressBar = findViewById(R.id.progress2);
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    progressBar = findViewById(R.id.progress2);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadResource(WebView view, String url) {
                    if(!CheckConnection.checkInternetConnection(MusicMore.this)){
                        progressBar.setVisibility(View.INVISIBLE);
                        webViewmore.setVisibility(View.INVISIBLE);
                        relativeLayout.setVisibility(View.VISIBLE);
                        //webViewmore.loadUrl("file:///android_asset/HTMLF/error.html");
                        //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
                    }
                }

            });

            newWebview.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onCloseWindow(WebView window) {
                    dialog.dismiss();
                }
            });

            ((WebView.WebViewTransport)resultMsg.obj).setWebView(newWebview);
            resultMsg.sendToTarget();
            return true;
        }
    });


    webViewmore.setWebViewClient(new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar = findViewById(R.id.progress2);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar = findViewById(R.id.progress2);
            progressBar.setVisibility(View.GONE);
        }


        @Override
        public void onLoadResource(WebView view, String url) {
            if(!CheckConnection.checkInternetConnection(MusicMore.this)){
                progressBar.setVisibility(View.INVISIBLE);
                webViewmore.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                //webViewmore.loadUrl("file:///android_asset/HTMLF/error.html");
                //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            }
        }


    });


}




    @Override
    public void onBackPressed() {
        if(webViewmore.canGoBack()){
            webViewmore.goBack();
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
                webViewmore.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                //webViewmore.loadUrl("file:///android_asset/HTMLF/error.html");
                Toast.makeText(getApplicationContext(), "No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            } else {
                progressBar.setVisibility(View.VISIBLE);
                webViewmore.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.INVISIBLE);
                webViewmore.reload();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void downloading() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions,1);
            }
        }
        webViewmore.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.setMimeType(mimetype);
            String Cookies = CookieManager.getInstance().getCookie(url);
            request.addRequestHeader("cookie",Cookies);
            request.addRequestHeader("User-Agent",userAgent);
            request.setDescription("Downloading file......");
            request.setTitle(URLUtil.guessFileName(url,contentDisposition,mimetype));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url,contentDisposition,mimetype));
            DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            assert dm != null;
            dm.enqueue(request);
            Toast.makeText(getApplicationContext(), "Your file is downloading so exercise patient", Toast.LENGTH_SHORT).show();
        });

    }


}

