package com.trustingbrother.a1stdadiesobrigade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class Drill_Manual extends AppCompatActivity {
    PDFView pdfViewright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill__manual);
        setTitle("Drill Book");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        pdfViewright = findViewById(R.id.drill_book);
        pdfViewright.fromAsset("HTMLF/drillbook.pdf").scrollHandle(new DefaultScrollHandle(this))
                .spacing(4)
                .load();
    }
}