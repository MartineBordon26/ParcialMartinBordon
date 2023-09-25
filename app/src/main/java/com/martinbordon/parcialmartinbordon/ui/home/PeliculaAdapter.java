package com.martinbordon.parcialmartinbordon.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.martinbordon.parcialmartinbordon.R;
import com.martinbordon.parcialmartinbordon.modelos.Pelicula;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {


    private Context context;
    private List<Pelicula> listPeliculas;
    private LayoutInflater li;


    public PeliculaAdapter(Context context, List<Pelicula> listPeliculas, LayoutInflater li) {
        this.context = context;
        this.listPeliculas = listPeliculas;
        this.li = li;
    }

    public interface OnItemClickListener {
        void onItemClick(Pelicula pelicula);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_pelicula, parent, false);
        return new ViewHolder(view, mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaAdapter.ViewHolder holder, int position) {
        final Pelicula pelicula = listPeliculas.get(position);
        holder.titulo.setText(listPeliculas.get(position).getTitulo());
        holder.director.setText(listPeliculas.get(position).getDirector());

    }

    @Override    public int getItemCount() {
        return listPeliculas.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo, director ;


        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            titulo=itemView.findViewById(R.id.tvTitulo);
            director=itemView.findViewById(R.id.tvDirector);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION && listener != null && position < listPeliculas.size()) {
                                listener.onItemClick(listPeliculas.get(position));
                            }
                    }


            });
        }
    }

}
