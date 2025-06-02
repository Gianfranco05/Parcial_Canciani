package com.dao;

import com.model.Director;
import java.util.List;

public interface DirectorDAO {
    void guardar(Director director);
    Director buscarPorId(int id);
    List<Director> listarTodos();
    void actualizar(Director director);
    void eliminar(int id);
}
