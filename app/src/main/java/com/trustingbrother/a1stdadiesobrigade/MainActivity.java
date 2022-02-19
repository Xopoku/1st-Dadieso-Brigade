package com.trustingbrother.a1stdadiesobrigade;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;

import hotchemi.android.rate.AppRate;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    WebView webView;
    Dialog epicdialog;
    Button button1, button2;
    TextView textView;
    ImageView imageView;
    BottomNavigationView bottomNavigationView;
    private static final int REQUEST_PHONE_CALL = 1;

    //In-App-Update Declaration
    private AppUpdateManager mappUpdateManager;
    private static final int RC_APP_UPDATE = 100;
    @Override
    @SuppressLint("setJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home-Page");


        //In-App-Update Code Lines
        mappUpdateManager = AppUpdateManagerFactory.create(this);
        mappUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo appUpdateInfo) {
                if(appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)){
                    try {
                        mappUpdateManager.startUpdateFlowForResult(appUpdateInfo,AppUpdateType.FLEXIBLE, MainActivity.this,
                                RC_APP_UPDATE);
                    } catch (IntentSender.SendIntentException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
        mappUpdateManager.registerListener(installStateUpdatedListener);


        //Rating dialog
       AppRate.with(this)
                .setInstallDays(1) // default 10, 0 means install day.
                .setLaunchTimes(3) // 3 times open
                .setRemindInterval(2) // 2 days after later
                .monitor();

        // Show a dialog if meets conditions
        AppRate.showRateDialogIfMeetsConditions(this);
        AppRate.with(this).clearAgreeShowDialog();


        epicdialog = new Dialog(this);
        button1 = findViewById(R.id.btnpositive);
        button2 = findViewById(R.id.btnnegative);
        imageView = findViewById(R.id.imgpop);
        textView = findViewById(R.id.txtmessage);

        webView = findViewById(R.id.homeweb);
        webView.loadUrl("file:///android_asset/HTMLF/Home.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.getAllowFileAccess();
        webSettings.setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient());
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){

        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_anthem:
                        startActivity(new Intent((MainActivity.this), Brigade_Anthem.class));
                        break;

                    case R.id.nav_developer:
                        startActivity(new Intent((MainActivity.this), About.class));
                        break;

                    case R.id.nav_annualreport:
                        startActivity(new Intent((MainActivity.this), loginreport.class));
                        break;

                    case R.id.nav_patrons:
                        startActivity(new Intent((MainActivity.this), Membership.class));
                        break;

                    case R.id.nav_biblestudy:
                        startActivity(new Intent((MainActivity.this),Biblestudywebview.class));
                        break;

                   /* case R.id.nav_programout:
                        startActivity(new Intent((MainActivity.this),Programsoutwebview.class));
                        break; */

                    case R.id.nav_scores:
                        startActivity(new Intent((MainActivity.this), ActualMusic.class));
                        break;


                    case R.id.nav_images:
                        Intent youtubeintent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/channel/UCFUr_7U3dmV4a-kEH_H1gTQ"));
                        startActivity(youtubeintent);
                        break;

                    case R.id.nav_devotion:
                        startActivity(new Intent((MainActivity.this),Devotion.class));
                        break;

                    case R.id.nav_hymns:
                        try{
                            startActivity(getPackageManager().getLaunchIntentForPackage("ideanity.oceans.methodistndwom"));
                        }
                        catch (Exception ex){
                            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/details?id=ideanity.oceans.methodistndwom")));
                        }
                        break;

                    case R.id.nav_support_developer:
                        Intent supportintent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://paystack.com/pay/wlj4db0n4i"));
                        startActivity(supportintent);
                        break;


                    case R.id.nav_colour_presentation:
                        startActivity(new Intent((MainActivity.this),Colour_Presentation.class));
                        break;

                    case R.id.nav_drill_manual:
                        startActivity(new Intent((MainActivity.this),Drill_Manual.class));
                        break;


                    case R.id.nav_weeklyactivities:
                        startActivity(new Intent((MainActivity.this), News_and_event.class));
                        break;

                    case R.id.nav_methodist:
                        startActivity(new Intent((MainActivity.this), Methodist_church_Ghana.class));
                        break;

                    case R.id.band_fund:

                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this,R.style.BottomSheetTheme);
                        bottomSheetDialog.setContentView(R.layout.activity_payment);
                        bottomSheetDialog.setCanceledOnTouchOutside(true);

                        Button button = bottomSheetDialog.findViewById(R.id.btnpayment);
                        assert button != null;
                        button.setOnClickListener(v -> {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                                }
                                else
                                {
                                    Intent i = new Intent(Intent.ACTION_CALL);
                                    i.setData(Uri.parse(Uri.parse("tel:"+"*920*5071")+Uri.encode("#")));
                                    startActivity(i);
                                }
                            }
                            bottomSheetDialog.cancel();
                            //Toast.makeText(getApplicationContext(),"Payment",Toast.LENGTH_LONG).show();
                        });

                        bottomSheetDialog.show();

                        break;

                    case R.id.nav_rate:
                        try{
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market:details?id="+getPackageName())));
                        }
                        catch (ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                        }
                        break;

                    case R.id.nav_mail:
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        Uri data = Uri.parse("mailto:?subject=" + "" + "&body=" + "" + "&to=" +"1stdadieso@gmail.com, samuelopoku035@gmail.com");
                        intent.setData(data);
                        startActivity(Intent.createChooser(intent,"Send mail through"));
                       /* intent.setData(Uri.parse("mailto:"));
                        String[] recipients = {"1stdadieso@gmail.com"};
                        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "");
                        intent.putExtra(Intent.EXTRA_TEXT, "");
                        intent.setType("text/html");


                        if (intent.resolveActivity(getPackageManager()) != null) {
                            //startActivity(intent);
                            startActivity(Intent.createChooser(intent,"Send mail through"));

                        }*/

                        break;
                }
                    return true;

            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }

        else if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            ShowPositivePopup();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_bar_1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navdot1:
                startActivity(new Intent((MainActivity.this),Appmanual.class));
                //Toast.makeText(getApplicationContext(),"Shows the Application Manual", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navdot3:
                ShowPositivePopup();
                break;

            case R.id.navdot4:
                startActivity(new Intent((MainActivity.this),Passwordreset.class));
                break;

            case R.id.navdot5:
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market:details?id="+getPackageName())));
                }
                catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }
                break;

            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "Download this app through the link below."+" https://play.google.com/store/apps/details?id=com.trustingbrother.a1stdadiesobrigade" );
                startActivity(Intent.createChooser(sharingIntent,"Share Via"));



        }
        return super.onOptionsItemSelected(item);
    }


    public  void ShowPositivePopup(){
        epicdialog.setContentView(R.layout.custompop);
        epicdialog.show();
        button2 = epicdialog.findViewById(R.id.btnnegative);
        button1 = epicdialog.findViewById(R.id.btnpositive);
        imageView = epicdialog.findViewById(R.id.imgpop);
        textView = epicdialog.findViewById(R.id.txtmessage);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                epicdialog.dismiss();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicdialog.dismiss();
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PHONE_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse(Uri.parse("tel:" + "*920*5071") + Uri.encode("#")));
                startActivity(i);
            }
        }
    }
    //In-App_Update  Install Update Listener codes
    private InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() {
        @Override
        public void onStateUpdate(@NonNull InstallState installState) {
            if(installState.installStatus() == InstallStatus.DOWNLOADED)
            {
                showCompletedUpdate();
            }
        }
    };

    //In-App-Update onStop
    @Override
    protected void onStop()
    {
        if(mappUpdateManager !=null) mappUpdateManager.unregisterListener(installStateUpdatedListener);
        super.onStop();
    }

    private void showCompletedUpdate() {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "The new app is ready",
                Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Install", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mappUpdateManager.completeUpdate();
            }
        });
        snackbar.show();
    }

    //In-App_Update onActivity Result codes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == RC_APP_UPDATE && resultCode != RESULT_OK)
        {
            Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}