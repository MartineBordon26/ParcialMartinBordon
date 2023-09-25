package com.martinbordon.parcialmartinbordon.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.martinbordon.parcialmartinbordon.R;
import com.martinbordon.parcialmartinbordon.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        GalleryViewModel.mostrarDialog(getActivity());
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

}