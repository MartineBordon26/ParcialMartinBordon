package com.martinbordon.parcialmartinbordon.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martinbordon.parcialmartinbordon.modelos.Pelicula;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<List<Pelicula>> listaMutable;
    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context= application.getApplicationContext();
    }

    public LiveData<List<Pelicula>> getListaMutable() {
        if (listaMutable == null ) {
            listaMutable= new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void armarLista() {
        List<Pelicula> lista=new ArrayList<>();
        lista.add(new Pelicula("Tierra de osos", "120", "crack", LocalDate.of(2006, 12,23)));
        lista.add(new Pelicula("Soy Leyenda", "140", "otro crack", LocalDate.of(2010, 9,13)));
        lista.add(new Pelicula("Titanic", "78", "crack", LocalDate.of(2002, 2,3)));

        listaMutable.setValue(lista);
    }


}