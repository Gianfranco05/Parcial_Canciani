package com.daoImpl;

import com.dao.PeliculaDAO;
import com.model.Pelicula;
import com.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAOImpl implements PeliculaDAO {

    @Override
    public void guardar(Pelicula pelicula) {
        String sql = "INSERT INTO peliculas (titulo, director_id) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pelicula.getTitulo());
            stmt.setInt(2, pelicula.getDirectorId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar película: " + e.getMessage());
        }
    }

    @Override
    public Pelicula buscarPorId(int id) {
        String sql = "SELECT * FROM peliculas WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Pelicula(rs.getInt("id"), rs.getString("titulo"), rs.getInt("director_id"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar película: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pelicula> listarTodos() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";
        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Pelicula(rs.getInt("id"), rs.getString("titulo"), rs.getInt("director_id")));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar películas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void actualizar(Pelicula pelicula) {
        String sql = "UPDATE peliculas SET titulo = ?, director_id = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pelicula.getTitulo());
            stmt.setInt(2, pelicula.getDirectorId());
            stmt.setInt(3, pelicula.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar película: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM peliculas WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar película: " + e.getMessage());
        }
    }
}
