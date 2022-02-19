package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Brigade_Anthem extends AppCompatActivity implements View.OnClickListener {
    WebView anthemwebview;
    SeekBar seekBar;
    ImageView imageView1, imageView2;
    MediaPlayer mediaPlayer;
    Runnable runnable;
    Handler handler;
    AdView mAdView;

    @SuppressWarnings("ALL")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brigade_anthem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        seekBar = findViewById(R.id.seekbar);
        imageView1 = findViewById(R.id.playmusic);
        imageView2 = findViewById(R.id.paulsemusic);
        handler = new Handler();
        mediaPlayer = MediaPlayer.create(this,R.raw.anchor);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);


        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(mediaPlayer.getDuration());
                ChangeSeekbar();
            }
        });


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                imageView1.setImageResource(R.drawable.playmusic);

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        setTitle("Brigade Anthem");
        anthemwebview = findViewById(R.id.anthem_web);
        anthemwebview.loadUrl("file:///android_asset/HTMLF/anthem.html");
        WebSettings webSettings = anthemwebview.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setUseWideViewPort(true);
        anthemwebview.setWebViewClient(new WebViewClient());
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        anthemwebview.setWebChromeClient(new WebChromeClient(){

        });


    }

    private void ChangeSeekbar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if (mediaPlayer.isPlaying()){
            runnable = this::ChangeSeekbar;
            handler.postDelayed(runnable,1000);
        }


    }

    @Override
    public void onBackPressed() {
        if (anthemwebview.canGoBack()) {
            anthemwebview.goBack();
        }
        else if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            super.onBackPressed();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playmusic) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                imageView1.setImageResource(R.drawable.playmusic);
            } else {
                mediaPlayer.start();
                imageView1.setImageResource(R.drawable.palsemusic);
                ChangeSeekbar();
            }
        }

    }

    @Override
    //this method displays when the back arrow is clicked
    public boolean onSupportNavigateUp() {
        mediaPlayer.pause();
        finish();
        return super.onSupportNavigateUp();
    }
}
