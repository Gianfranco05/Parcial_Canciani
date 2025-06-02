# Gestión de Películas y Directores

## Descripción

Aplicación Java para gestionar directores y películas usando una base de datos H2 embebida.  
Interfaz por consola con menús para realizar operaciones CRUD (crear, leer, actualizar, eliminar).

---

## Requisitos

- **Java JDK 17** instalado y configurado.
- **Gradle** instalado (o usa el wrapper incluido).
- IDE recomendado: **IntelliJ IDEA** o acceso a terminal.

---

## Configuración

El proyecto usa Gradle para manejar dependencias, incluyendo el driver de la base de datos H2.  
No es necesario instalar nada extra, Gradle descarga y configura todo automáticamente.

---

## Ejecutar la aplicación

### Opción 1: Desde IntelliJ IDEA (recomendado)

1. Abre el proyecto en IntelliJ como proyecto Gradle.
2. Espera que descargue las dependencias.
3. Navega a `src/main/java/com/main/App.java`.
4. Haz clic derecho en `App` → **Run 'App.main()'**.
5. La consola mostrará el menú principal para interactuar.

### Opción 2: Desde la terminal

1. Abre la terminal en la raíz del proyecto.
2. Ejecuta la compilación con:

   ```bash
   ./gradlew build
