package com.martinbordon.parcialmartinbordon.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Pelicula implements Serializable {   // título, duración, director, año

    private String titulo;
    private String duracion;
    private String director;
    private LocalDate anio;

    public Pelicula(String titulo, String duracion, String director, LocalDate anio) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.director = director;
        this.anio = anio;
    }

    public Pelicula() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }
}
