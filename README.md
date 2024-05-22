Esta es una API RESTful construida con Spring Boot, utilizando PostgreSQL como base de datos y Swagger para la documentación de la API.


## Requisitos Previos

Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

- Tener instalado Java 11 o superior.
- Tener instalado PostgreSQL.
- Tener instalado Gradle.

Endpoints de la API
Los siguientes endpoints están disponibles:

GET /api/products - Obtener todos los productos.
GET /api/products/{id} - Obtener un producto por ID.
POST /api/products - Crear un nuevo producto.
PUT /api/products/{id} - Actualizar un producto.
DELETE /api/products/{id} - Eliminar un producto.

Api
├── build.gradle
├── settings.gradle
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── RESTFull
│   │   │           └── Api
│   │   │               ├── ApiApplication.java
│   │   │               ├── config
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controller
│   │   │               │   └── ProductController.java
│   │   │               ├── entity
│   │   │               │   └── Product.java
│   │   │               ├── repository
│   │   │               │   └── ProductRepository.java
│   │   │               └── service
│   │   │                   └── ProductService.java
│   │   └── resources
│   │       ├── application.properties
└── └── test
    └── java
        └── com
            └── RESTFull
                └── Api
                    └── ApiApplicationTests.java
