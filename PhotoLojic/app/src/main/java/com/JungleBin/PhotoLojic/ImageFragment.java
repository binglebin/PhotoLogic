package com.JungleBin.PhotoLojic;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class ImageFragment extends Fragment {
    ImageView imgView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_image, container, false);
        imgView=(ImageView) rootView.findViewById(R.id.imgView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Uri uri = getArguments().getParcelable("imageUri");
        imgView.setImageURI(uri);
    }
}