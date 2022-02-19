package com.trustingbrother.a1stdadiesobrigade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

@SuppressWarnings("ALL")
public class TonicFragment extends Fragment {
PDFView pdfViewright;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tonic,container,false);

        pdfViewright = view.findViewById(R.id.tonicpdf);
        pdfViewright.fromAsset("HTMLF/tonic.pdf").scrollHandle(new DefaultScrollHandle(getActivity()))
                .spacing(4)
                .load();
        return view;
    }
}
