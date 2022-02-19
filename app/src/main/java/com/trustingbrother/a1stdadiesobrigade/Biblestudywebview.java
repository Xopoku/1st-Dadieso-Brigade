package com.trustingbrother.a1stdadiesobrigade;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
public class Biblestudywebview extends AppCompatActivity{
AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_biblestudywebview);
    setTitle("Bible Studies & Stories");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setupViewPaper();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setupViewPaper(){
        SectionpagerAdapter adapter = new SectionpagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OldTestamentFragment());
        adapter.addFragment(new ArmanackFragment());
        adapter.addFragment(new NewTTestamentFragment());


        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        tabLayout.setTabTextColors(getResources().getColor(R.color.black),getResources().getColor(R.color.white));

        Objects.requireNonNull(tabLayout.getTabAt(0)).setText("Old Testament");
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText("Methodist Almanack");
        Objects.requireNonNull(tabLayout.getTabAt(2)).setText("New Testament");

    }

    static class SectionpagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mfragmentList = new ArrayList<>();
        public  SectionpagerAdapter(FragmentManager fm){
            super(fm);
        }
        @NonNull
        @Override
        public Fragment getItem(int position){
            return mfragmentList.get(position);
        }

        @Override
        public int getCount(){
            return mfragmentList.size();
        }

        public void addFragment(Fragment fragment){
            mfragmentList.add(fragment);
        }

    }
}