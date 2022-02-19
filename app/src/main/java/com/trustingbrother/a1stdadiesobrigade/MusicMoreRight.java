package com.trustingbrother.a1stdadiesobrigade;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
public class MusicMoreRight extends AppCompatActivity {
PDFView pdfViewright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_more_right);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setTitle("Tonic Solfas");

        setupViewPaper();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setupViewPaper(){
        SectionpagerAdapter adapter = new SectionpagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TonicFragment());
        adapter.addFragment(new Fragment_GME());


        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.black));

        Objects.requireNonNull(tabLayout.getTabAt(0)).setText("Meth. Praise");
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText("GME Folks");

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