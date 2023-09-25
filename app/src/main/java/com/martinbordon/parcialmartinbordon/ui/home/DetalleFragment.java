package com.martinbordon.parcialmartinbordon.ui.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.martinbordon.parcialmartinbordon.R;
import com.martinbordon.parcialmartinbordon.databinding.FragmentDetalleBinding;
import com.martinbordon.parcialmartinbordon.modelos.Pelicula;

import java.time.LocalDate;


public class DetalleFragment extends Fragment {

    private FragmentDetalleBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle bundle = getArguments();

        binding.tvDuracion.setText(bundle.getString("duracion"));
        binding.tvDuracion.setText(bundle.getString("duracion"));

        LocalDate fecha = LocalDate.parse(bundle.getString("anio"));
        int anio = fecha.getYear();

        binding.tvAnio.setText(String.valueOf(anio));



        Log.d("salida", anio + "" );




        return root;
    }



}