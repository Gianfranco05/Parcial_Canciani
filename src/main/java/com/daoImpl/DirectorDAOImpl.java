package com.daoImpl;

import com.dao.DirectorDAO;
import com.model.Director;
import com.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAOImpl implements DirectorDAO {

    @Override
    public void guardar(Director director) {
        String sql = "INSERT INTO directores (nombre) VALUES (?)";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, director.getNombre());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar director: " + e.getMessage());
        }
    }

    @Override
    public Director buscarPorId(int id) {
        String sql = "SELECT * FROM directores WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Director(rs.getInt("id"), rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar director: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Director> listarTodos() {
        List<Director> lista = new ArrayList<>();
        String sql = "SELECT * FROM directores";
        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Director(rs.getInt("id"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar directores: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void actualizar(Director director) {
        String sql = "UPDATE directores SET nombre = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, director.getNombre());
            stmt.setInt(2, director.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar director: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM directores WHERE id = ?";
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar director: " + e.getMessage());
        }
    }
}
