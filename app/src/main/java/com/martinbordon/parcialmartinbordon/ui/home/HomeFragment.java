package com.martinbordon.parcialmartinbordon.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.martinbordon.parcialmartinbordon.R;
import com.martinbordon.parcialmartinbordon.databinding.FragmentHomeBinding;
import com.martinbordon.parcialmartinbordon.modelos.Pelicula;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel mv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mv.getListaMutable().observe(getViewLifecycleOwner(), new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                RecyclerView rv = binding.rvPeliculas;
                GridLayoutManager glm = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                rv.setLayoutManager(glm);
                PeliculaAdapter lad = new PeliculaAdapter(getContext(), peliculas, getLayoutInflater());
                rv.setAdapter(lad);
                lad.setOnItemClickListener(new PeliculaAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Pelicula pelicula) {
                        HomeFragment f = new HomeFragment();
                        Bundle bundle = new Bundle();

                        bundle.putString("duracion", pelicula.getDuracion().toString());
                        bundle.putString("anio", pelicula.getAnio().toString());

                        f.setArguments(bundle);
                        Navigation.findNavController(getView()).navigate(R.id.detalleFragment,bundle);
                    }
                });
            }
        });
        mv.armarLista();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}