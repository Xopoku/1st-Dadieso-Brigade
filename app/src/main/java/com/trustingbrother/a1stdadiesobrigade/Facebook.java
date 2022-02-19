package com.trustingbrother.a1stdadiesobrigade;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Facebook extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
WebView fbwebview;
ProgressBar progressBar;
RelativeLayout relativeLayout;
AdView mAdView;
FloatingActionButton floatingActionButton;
    @Override
    @SuppressLint("setJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        setTitle("Facebook Page");

        progressBar = findViewById(R.id.progress3);
        floatingActionButton = findViewById(R.id.switchytube);
        relativeLayout = findViewById(R.id.methodisterror1);
        fbwebview = findViewById(R.id.myfbweb);

        floatingActionButton.setOnClickListener(view -> {
            Intent youtubeintent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/channel/UCFUr_7U3dmV4a-kEH_H1gTQ"));
            startActivity(youtubeintent);
        });

        //fbwebview.loadUrl("https://web.facebook.com/groups/344081619281118/");
        WebSettings webSettings = fbwebview.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        registerForContextMenu(fbwebview);
        if(!CheckConnection.checkInternetConnection(this)){
            relativeLayout.setVisibility(View.VISIBLE);
            fbwebview.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            Snackbar snackbar = Snackbar.make(findViewById(R.id.facebookrel),"No Network Connection",Snackbar.LENGTH_LONG);
            snackbar.show();
            //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
        }
        else{
            relativeLayout.setVisibility(View.INVISIBLE);
            fbwebview.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            fbwebview.loadUrl("https://web.facebook.com/groups/344081619281118/");
        }


        fbwebview.setWebChromeClient(new WebChromeClient(){

        });


        fbwebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar = findViewById(R.id.progress3);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar = findViewById(R.id.progress3);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                if(!CheckConnection.checkInternetConnection(Facebook.this)){
                    relativeLayout.setVisibility(View.VISIBLE);
                    fbwebview.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.facebookrel),"No Network Connection",Snackbar.LENGTH_LONG);
                    snackbar.show();
                    //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                if(!CheckConnection.checkInternetConnection(Facebook.this)){
                    relativeLayout.setVisibility(View.VISIBLE);
                    fbwebview.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    //reportwebview.loadUrl("file:///android_asset/HTMLF/error.html");
                }
                if (errorCode == ERROR_TIMEOUT) {
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    fbwebview.setVisibility(View.INVISIBLE);
                }

                else if(errorCode == ERROR_CONNECT){
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    fbwebview.setVisibility(View.INVISIBLE);
                }

                else if(errorCode == ERROR_BAD_URL){
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    fbwebview.setVisibility(View.INVISIBLE);
                }

                else if(errorCode == ERROR_FILE || errorCode == ERROR_FILE_NOT_FOUND){
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    fbwebview.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (fbwebview.canGoBack()) {
            fbwebview.goBack();
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
                fbwebview.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.facebookrel),"No Network Connection",Snackbar.LENGTH_LONG);
                snackbar.show();
                //fbwebview.loadUrl("file:///android_asset/HTMLF/error.html");
                //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            } else {
                relativeLayout.setVisibility(View.INVISIBLE);
                fbwebview.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                fbwebview.reload();
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
        fbwebview.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> {
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        final WebView.HitTestResult webViewHintTestResults = fbwebview.getHitTestResult();

        if(webViewHintTestResults.getType() == WebView.HitTestResult.IMAGE_TYPE || webViewHintTestResults.getType() == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE){
            menu.setHeaderTitle("Download Image From Below");
            menu.add(0, 1, 0, "Save - Download Image")
                    .setOnMenuItemClickListener(item -> {
                        String DownloadImageURL = webViewHintTestResults.getExtra();
                        if (URLUtil.isValidUrl(DownloadImageURL)){
                            downloading();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Sorry.. Something Went Wrong.", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    });
        }
    }

}
