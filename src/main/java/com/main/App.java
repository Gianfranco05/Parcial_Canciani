package com.main;

import com.daoImpl.DirectorDAOImpl;
import com.daoImpl.PeliculaDAOImpl;
import com.model.Director;
import com.model.Pelicula;
import com.util.InicializarBD;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final DirectorDAOImpl directorDAO = new DirectorDAOImpl();
    private static final PeliculaDAOImpl peliculaDAO = new PeliculaDAOImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InicializarBD.crearTablas();; //esto inicializa las tablas si no existen

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Selecciona una opción: ");
            switch (opcion) {
                case 1 -> menuDirectores();
                case 2 -> menuPeliculas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Gestionar Directores");
        System.out.println("2. Gestionar Películas");
        System.out.println("0. Salir");
    }

    // ======= MENÚ DIRECTORES =======
    private static void menuDirectores() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ DIRECTORES ---");
            System.out.println("1. Crear director");
            System.out.println("2. Listar directores");
            System.out.println("3. Buscar director por ID");
            System.out.println("4. Actualizar director");
            System.out.println("5. Eliminar director");
            System.out.println("0. Volver");
            opcion = leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = leerTexto("Nombre: ");
                    directorDAO.guardar(new Director(nombre));
                }
                case 2 -> {
                    List<Director> directores = directorDAO.listarTodos();
                    directores.forEach(System.out::println);
                }
                case 3 -> {
                    int id = leerEntero("ID del director: ");
                    System.out.println(directorDAO.buscarPorId(id));
                }
                case 4 -> {
                    int id = leerEntero("ID del director a actualizar: ");
                    String nuevoNombre = leerTexto("Nuevo nombre: ");
                    directorDAO.actualizar(new Director(id, nuevoNombre));
                }
                case 5 -> {
                    int id = leerEntero("ID del director a eliminar: ");
                    directorDAO.eliminar(id);
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // ======= MENÚ PELÍCULAS =======
    private static void menuPeliculas() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PELÍCULAS ---");
            System.out.println("1. Crear película");
            System.out.println("2. Listar películas");
            System.out.println("3. Buscar película por ID");
            System.out.println("4. Actualizar película");
            System.out.println("5. Eliminar película");
            System.out.println("0. Volver");
            opcion = leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String titulo = leerTexto("Título: ");
                    int directorId = leerEntero("ID del director: ");
                    peliculaDAO.guardar(new Pelicula(titulo, directorId));
                }
                case 2 -> {
                    List<Pelicula> peliculas = peliculaDAO.listarTodos();
                    peliculas.forEach(System.out::println);
                }
                case 3 -> {
                    int id = leerEntero("ID de la película: ");
                    System.out.println(peliculaDAO.buscarPorId(id));
                }
                case 4 -> {
                    int id = leerEntero("ID de la película a actualizar: ");
                    String nuevoTitulo = leerTexto("Nuevo título: ");
                    int nuevoDirectorId = leerEntero("Nuevo ID de director: ");
                    peliculaDAO.actualizar(new Pelicula(id, nuevoTitulo, nuevoDirectorId));
                }
                case 5 -> {
                    int id = leerEntero("ID de la película a eliminar: ");
                    peliculaDAO.eliminar(id);
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // ======= MÉTODOS DE ENTRADA =======
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.print("Entrada no válida. " + mensaje);
            input = scanner.nextLine();
        }
        return input;
    }

    private static int leerEntero(String mensaje) {
        int numero = -1;
        boolean valido = false;
        do {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número.");
            }
        } while (!valido);
        return numero;
    }
}