package com.dao;

import com.model.Pelicula;
import java.util.List;

public interface PeliculaDAO {
    void guardar(Pelicula pelicula);
    Pelicula buscarPorId(int id);
    List<Pelicula> listarTodos();
    void actualizar(Pelicula pelicula);
    void eliminar(int id);
}
