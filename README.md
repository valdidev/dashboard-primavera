User CRUD Application (Java Spring Boot)

Descripción

Esta es una aplicación para gestionar usuarios mediante operaciones CRUD (Crear, Leer, Actualizar, Eliminar). 
Desarrollada con Java y Spring Boot, permite administrar información de usuarios de forma eficiente.

Características

Crear nuevos usuarios.
Listar todos los usuarios registrados.
Actualizar información de usuarios existentes.
Eliminar usuarios.
API RESTful con endpoints claros.

Tecnologías

Backend: Java 17, Spring Boot 3.x
Base de datos: MySQL
Dependencias: Spring Web, Spring Data JPA, Lombok, Spring Boot Starter Test
Herramientas: Maven

Requisitos

Java 17 o superior
Maven 3.8.x o superior
Opcional: Base de datos externa (MySQL/PostgreSQL)

Instalación

Clona el repositorio

Navega al directorio del proyecto:cd nombre-repositorio

Configura las variables de entorno en src/main/resources/application.properties:spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
server.port=8080

Para MySQL, ajusta la configuración correspondiente.
Compila e instala las dependencias:mvn clean install


Inicia la aplicación:mvn spring-boot:run

Uso

Accede a la API en http://localhost:8080.

- GET /api/usuarios: Listar todos los usuarios.
- GET /api/usuario/{id}: Obtener un usuario por ID.
- POST /api/users: Crear un usuario (ejemplo de cuerpo JSON):{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}

- PUT /api/usuario/{id}: Actualizar un usuario.
- DELETE /api/usuario/{id}: Eliminar un usuario.


Para pruebas, usa herramientas como Postman o cURL.
Accede a la consola H2 (si está habilitada) en http://localhost:8080/h2-console.

Estructura del Proyecto
nombre-repositorio/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/    # Controladores REST
│   │   │   ├── entity/        # Entidades JPA
│   │   │   ├── repository/    # Repositorios JPA
│   │   │   ├── service/       # Lógica de negocio
│   │   │   └── DemoApplication.java  # Clase principal
│   │   └── resources/
│   │       └── application.properties  # Configuración
│   └── test/                  # Pruebas unitarias e integrales
├── pom.xml                    # Dependencias y configuración de Maven
└── README.md                  # Este archivo

Contribución

Haz un fork del repositorio.
Crea una rama para tu feature:git checkout -b mi-nueva-feature


Realiza tus cambios y haz commit:git commit -m "Agrega mi nueva feature"


Sube los cambios:git push origin mi-nueva-feature


Abre un Pull Request en GitHub.

MIT License.

Para dudas o sugerencias, contacta a iamvaldidev@gmail.com.
