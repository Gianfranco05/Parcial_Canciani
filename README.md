# Proyecto Gestión de Películas y Directores

## Introducción

Esta aplicación en Java permite gestionar películas y directores almacenados en una base de datos H2 local. Se interactúa mediante menús en consola para realizar operaciones CRUD (crear, leer, actualizar y eliminar).

---

## Base de Datos

- **Tipo:** H2, base de datos embebida en archivo local.
- **Ubicación:** El archivo de datos se crea en la carpeta `database` dentro del directorio del proyecto (`./database/peliculasDB`).
- **Inicialización automática:** Al ejecutar el programa, se crea la carpeta `database` si no existe y se generan las tablas necesarias (`directores` y `peliculas`).
- **Estructura:**
  - `directores`: almacena `id` (auto incremental) y `nombre`.
  - `peliculas`: almacena `id`, `titulo` y `director_id` (clave foránea a directores).

### Qué hacer si hay errores con la base de datos

- Verifica que la carpeta `database` tenga permisos de escritura.
- Si la conexión falla, el programa mostrará mensajes de error en consola.
- En caso de error persistente, eliminar la carpeta `database` puede ayudar a reiniciar la base limpia (esto elimina los datos guardados).
- Asegúrate de tener Java instalado correctamente y que el driver H2 está disponible en las dependencias.

---

## Cómo correr el programa

1. Compila el proyecto (si usas Gradle, `gradle build`).
2. Ejecuta la clase principal `com.main.App` desde tu IDE o terminal.
3. Al iniciar, el programa crea las tablas si no existen.
4. Usa los menús en consola para gestionar directores y películas.
5. Sigue las instrucciones en pantalla para ingresar datos o realizar búsquedas.

---

## Uso básico del programa

- El menú principal permite elegir entre gestionar directores, películas o salir.
- En cada gestión, puedes crear, listar, buscar, actualizar o eliminar registros.
- Las entradas de texto no pueden estar vacías.
- Los IDs deben ingresarse como números válidos.
- Si ingresas datos inválidos, el programa te pedirá que intentes nuevamente.

---

## Resumen rápido de comandos

| Opción Menú | Acción                         |
|-------------|--------------------------------|
| 1           | Gestionar Directores           |
| 2           | Gestionar Películas            |
| 0           | Salir                         |

En cada submenú:

| Opción | Acción                        |
|--------|------------------------------|
| 1      | Crear nuevo registro          |
| 2      | Listar todos los registros   |
| 3      | Buscar por ID                |
| 4      | Actualizar registro          |
| 5      | Eliminar registro            |
| 0      | Volver al menú anterior      |

---

## Consideraciones finales

- El programa está pensado para uso local y de prueba.
- No usa interfaz gráfica, solo consola.
- La base de datos es persistente mientras no elimines la carpeta `database`.
- En caso de problemas, revisa los mensajes de error que se imprimen en consola para diagnóstico.

---

¡Listo para usar! Si tienes dudas, revisa el código o consulta al desarrollador.
