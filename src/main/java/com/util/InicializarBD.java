package com.util;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializarBD {

    public static void crearTablas() {
        // Crear carpeta 'database' si no existe
        File carpetaDatabase = new File("database");
        if (!carpetaDatabase.exists()) {
            boolean creada = carpetaDatabase.mkdirs();
            if (creada) {
                System.out.println("📁 Carpeta 'database' creada correctamente.");
            } else {
                System.out.println("⚠️ No se pudo crear la carpeta 'database'. Verificá permisos.");
            }
        }
        //creacion de tablas
        String crearTablaDirectores = """
            CREATE TABLE IF NOT EXISTS directores (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(100) NOT NULL
            );
        """;

        String crearTablaPeliculas = """
            CREATE TABLE IF NOT EXISTS peliculas (
                id INT AUTO_INCREMENT PRIMARY KEY,
                titulo VARCHAR(100) NOT NULL,
                director_id INT NOT NULL,
                FOREIGN KEY (director_id) REFERENCES directores(id)
            );
        """;

        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement()) {

            stmt.execute(crearTablaDirectores);
            stmt.execute(crearTablaPeliculas);

            System.out.println(" Tablas creadas o ya existentes.");

        } catch (SQLException e) {
            System.out.println(" Error al crear las tablas:");
            e.printStackTrace();
        }
    }
}
