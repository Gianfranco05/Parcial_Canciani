package com.model;

public class Pelicula {
    private int id;
    private String titulo;
    private int directorId;

    public Pelicula() {
    }

    public Pelicula(String titulo, int directorId) {
        this.titulo = titulo;
        this.directorId = directorId;
    }

    public Pelicula(int id, String titulo, int directorId) {
        this.id = id;
        this.titulo = titulo;
        this.directorId = directorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", titulo=" + titulo + ", directorId=" + directorId + "]";
    }
}
