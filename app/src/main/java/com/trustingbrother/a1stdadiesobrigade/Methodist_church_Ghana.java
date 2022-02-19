package com.trustingbrother.a1stdadiesobrigade;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
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
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Methodist_church_Ghana extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
WebView webView;
AdView mAdView;
RelativeLayout relativeLayout;
ProgressBar progressBar;
    ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> uploadMessage;
    public static final int REQUEST_SELECT_FILE = 100;
    final static int FILECHOOSER_RESULTCODE = 1;


    @SuppressLint("setJavaScriptEnabled")
    @SuppressWarnings("ALL")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_methodistwebview);
        setTitle("The Methodist Church Ghana");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        webView = findViewById(R.id.methwebview);
        progressBar = findViewById(R.id.methodistprogress);
        relativeLayout = findViewById(R.id.methodisterror);
        WebSettings webSettings = webView.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        registerForContextMenu(webView);





    webView.setWebChromeClient(new WebChromeClient() {
        // For 3.0+ Devices (Start)
        // onActivityResult attached before constructor
        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);

            mUploadMessage = uploadMsg;
            Intent j = new Intent(Intent.ACTION_GET_CONTENT);
            j.addCategory(Intent.CATEGORY_OPENABLE);
            j.setType("application/vnd.ms-powerpoint");
            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);

            mUploadMessage = uploadMsg;
            Intent k = new Intent(Intent.ACTION_GET_CONTENT);
            k.addCategory(Intent.CATEGORY_OPENABLE);
            k.setType("application/msword");
            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);

            mUploadMessage = uploadMsg;
            Intent l = new Intent(Intent.ACTION_GET_CONTENT);
            l.addCategory(Intent.CATEGORY_OPENABLE);
            l.setType("application/pdf");
            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);
        }


        // For Lollipop 5.0+ Devices
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (uploadMessage != null) {
                uploadMessage.onReceiveValue(null);
                uploadMessage = null;
            }

            uploadMessage = filePathCallback;

            Intent intent = fileChooserParams.createIntent();
            try {
                startActivityForResult(intent, REQUEST_SELECT_FILE);
            } catch (ActivityNotFoundException e) {
                uploadMessage = null;
                Toast.makeText(getApplicationContext(), "Cannot Open File Chooser", Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        }

        //For Android 4.1 only
        protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            mUploadMessage = uploadMsg;
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);

            Intent intent1 = new Intent(Intent.ACTION_GET_CONTENT);
            intent1.addCategory(Intent.CATEGORY_OPENABLE);
            intent1.setType("application/pdf");
            startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);

            Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
            intent2.addCategory(Intent.CATEGORY_OPENABLE);
            intent2.setType("application/zip");
            startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);

            Intent intent3 = new Intent(Intent.ACTION_GET_CONTENT);
            intent3.addCategory(Intent.CATEGORY_OPENABLE);
            intent3.setType("application/vnd.ms-powerpoint");
            startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);

            Intent intent4 = new Intent(Intent.ACTION_GET_CONTENT);
            intent4.addCategory(Intent.CATEGORY_OPENABLE);
            intent4.setType("application/msword");
            startActivityForResult(Intent.createChooser(intent, "File Browser"), FILECHOOSER_RESULTCODE);
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);

            mUploadMessage = uploadMsg;
            Intent j = new Intent(Intent.ACTION_GET_CONTENT);
            j.addCategory(Intent.CATEGORY_OPENABLE);
            j.setType("application/vnd.ms-powerpoint");
            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);

            mUploadMessage = uploadMsg;
            Intent k = new Intent(Intent.ACTION_GET_CONTENT);
            k.addCategory(Intent.CATEGORY_OPENABLE);
            k.setType("application/msword");
            startActivityForResult(Intent.createChooser(i, "File Browser"), FILECHOOSER_RESULTCODE);

            mUploadMessage = uploadMsg;
            Intent l = new Intent(Intent.ACTION_GET_CONTENT);
            l.addCategory(Intent.CATEGORY_OPENABLE);
            l.setType("application/pdf");
            startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
        }
    });



    if(!CheckConnection.checkInternetConnection(this)){
        //webView.loadUrl("file:///android_asset/HTMLF/error.html");

        relativeLayout.setVisibility(View.VISIBLE);
        webView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        Snackbar snackbar = Snackbar.make(findViewById(R.id.methrel),"No Network Connection",Snackbar.LENGTH_LONG);
        snackbar.show();
        //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
    }
    else{
        relativeLayout.setVisibility(View.INVISIBLE);
        webView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        webView.loadUrl("https://www.methodistchurch.org.gh");
    }


    downloading();

    webView.setWebViewClient(new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar = findViewById(R.id.methodistprogress);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar = findViewById(R.id.methodistprogress);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            if(!CheckConnection.checkInternetConnection(Methodist_church_Ghana.this)){
                //webView.loadUrl("file:///android_asset/HTMLF/error.html");
                relativeLayout.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.methrel),"No Network Connection",Snackbar.LENGTH_LONG);
                snackbar.show();
                //Toast.makeText(getApplicationContext(),"No Internet Connection. Make sure your WIFI or MOBILE DATA is on", Toast.LENGTH_LONG).show();
            }
        }


        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            if(!CheckConnection.checkInternetConnection(Methodist_church_Ghana.this)){
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
                //webView.loadUrl("file:///android_asset/HTMLF/error.html");

                relativeLayout.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.methrel),"No Network Connection",Snackbar.LENGTH_LONG);
                snackbar.show();
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

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }


    public void downloading() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions,1);
            }
        }
        webView.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> {
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
        final WebView.HitTestResult webViewHintTestResults = webView.getHitTestResult();

        if(webViewHintTestResults.getType() == WebView.HitTestResult.IMAGE_TYPE || webViewHintTestResults.getType() == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE){
            menu.setHeaderTitle("Download Image From Below");
            menu.add(0, 1, 0, "Save - Download Image")
            .setOnMenuItemClickListener(item -> {
                String DownloadImageURL = webViewHintTestResults.getExtra();
                if (URLUtil.isValidUrl(DownloadImageURL)){
                    DownloadManager.Request mrequest = new DownloadManager.Request(Uri.parse(DownloadImageURL));
                    mrequest.allowScanningByMediaScanner();

                    mrequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                    assert downloadManager != null;
                    downloadManager.enqueue(mrequest);
                    Toast.makeText(getApplicationContext(),"Downloading......", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sorry.. Something Went Wrong.", Toast.LENGTH_SHORT).show();
                }
                return false;
            });

        }
    }


}
