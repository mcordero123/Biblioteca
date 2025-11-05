# Sistema biblioteca
Consiste en un sistema para gestionar un biblioteca mediante metodos como: agregar, eliminar, editar y buscar libros.

**Autor:** 
Miguel Cordero
**Curso:**
4°Medio A


## Tecnologías utilizadas:

Spring Boot y Java 17 para el backend.

H2 Console para simular la base de datos.

Conexión a la API externa de Google Books para buscar libros por ISBN.

HTML, CSS y Bootstrap para el diseño del frontend.

# Estructura del proyecto
src/<br>
└── main/<br>
├── java/<br>
│ ├── controller/ → Controladores de las rutas<br>
│ ├── model/ → Entidades<br>
│ ├── repository/ → Interfaces para acceso a la base de datos<br>
│ ├── services/ → Lógica detras de la funcionalidad de la página (Agregar, eliminar, editar y buscar)<br>
│ └── BibliotecaApplication.java → Clase principal<br>
└── resources/<br>
├── static/ → Archivos estáticos (CSS)<br>
├── templates/ → Páginas HTML<br>
└── application.properties → Configuración del proyecto<br>

# Instrucciones para ejectuar el programa
- Requisitos:<br>
→ Tener instalado Java 17 o superior<br>
→ Tener un IDE compatible(Visual Studio Code, IntelliJ)<br>
→ Git bash para clonar el repositorio<br>

- Ejecución: <br>
→ git clone https://github.com/mcordero123/Biblioteca.git <br>
→ Entrar a la carpeta del proyecto y ejecutar la clase principal BibliotecaApplication.java desde tu IDE. <br>
→ Una vez iniciada la clase principal, debes ingresar a tu navegador y acceder a http://localhost:8080/libros/nuevo<br>

- Si deseas acceder a la consola, sigue estos pasos: <br>
→ Abrir en tu navegador http://localhost:8080/h2-console <br>
→ Completar con los siguientes datos: <br>
**Campo**	       **Valor**<br>
JDBC URL:	jdbc:h2:mem:bibliotecadb<br>
User Name:	sa<br>
Password:    **vacio**<br>
→ Hacer click en Connect para acceder a la BD


![alt text](image-1.png)
![alt text](image.png)