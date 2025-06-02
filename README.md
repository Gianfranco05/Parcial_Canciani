# Gestión de Películas y Directores

## Descripción

Aplicación Java para gestionar directores y películas usando una base de datos H2 .  
Interfaz por consola con menús para realizar operaciones CRUD.

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
4. Hacé clic derecho en `App` → **Run 'App.main()'**.
5. La consola mostrará el menú principal para interactuar.

### Opción 2: Desde la terminal

1. Abre la terminal en la raíz del proyecto.
2. Ejecuta la compilación con:

   ```bash
   ./gradlew build
3. Ejecuta el programa con el comando:
   ```bash
   ./gradlew run
5. Aparecerá el menú en consola para gestionar directores y películas.

# Clase Principal

La aplicación inicia en la clase `com.main.App`, que se encarga de:

- Crear las tablas en la base de datos si no existen.
- Mostrar los menús para gestionar directores y películas mediante consola.

---

# Base de Datos H2 Embebida

- La base de datos se guarda localmente en la carpeta `./database` con el archivo `peliculasDB`.
- La carpeta `database` y las tablas `directores` y `peliculas` se crean automáticamente al iniciar el programa.

## Estructura de Tablas

| Tabla      | Columnas                                  |
|------------|------------------------------------------|
| directores | `id` (auto incremental), `nombre`        |
| peliculas  | `id`, `titulo`, `director_id` (clave foránea) |

---

# Qué hacer si hay errores con la base de datos

- Verificar que la carpeta `database` tenga permisos de escritura.
- Si la conexión o creación de tablas falla, se mostrarán mensajes de error en consola.
- Para reiniciar la base de datos, elimina la carpeta `database` (esto eliminará los datos guardados).
- El driver H2 está incluido en las dependencias gestionadas por Gradle, no requiere instalación manual.
- Asegúrate de tenr la JDK 17 correctamente instalado.

---

# Uso Básico del Programa

Desde el menú principal, elige gestionar **Directores** o **Películas**, o salir.

En cada gestión puedes:

- Crear nuevos registros.
- Listar todos los registros.
- Buscar registros por ID.
- Actualizar registros existentes.
- Eliminar registros.

**Importante:**

- Los campos de texto no pueden quedar vacíos.
- Los IDs deben ingresarse como números válidos.
- Si ingresas datos inválidos, el programa te pedirá que intentes nuevamente.

---

# Resumen Rápido de Opciones de Menú

| Menú Principal | Acción               |
|----------------|----------------------|
| 1              | Gestionar Directores |
| 2              | Gestionar Películas  |
| 0              | Salir                |

| Submenú | Acción              |
|---------|---------------------|
| 1       | Crear registro      |
| 2       | Listar registros    |
| 3       | Buscar por ID       |
| 4       | Actualizar registro |
| 5       | Eliminar registro   |
| 0       | Volver al menú      |

---

# Solución de Problemas Comunes

- **Error de conexión o creación de base:** revisa que la carpeta `database` tenga permisos de escritura.
- **Errores al correr el programa:** asegúrate de tener JDK 17 y Gradle configurados correctamente.
- **Base corrupta o fallo persistente:** elimina la carpeta `database` para reiniciar la base de datos.
- **Errores de entrada:** sigue las indicaciones del programa para ingresar datos válidos.

---

# Estructura del Proyecto

- `com.model`: Clases modelo (`Director`, `Pelicula`).
- `com.dao` y `com.daoImpl`: Interfaces y clases DAO para acceso a datos.
- `com.util`: Utilidades para conexión y creación de tablas.
- `com.main`: Clase principal `App` con la lógica del menú.

