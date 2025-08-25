# Spring-Boot-Learning
Spring Boot ejercicios

**** Producto API **** EJERCICIO 1
Una API REST desarrollada con Spring Boot para la gestión de productos, implementando las mejores prácticas de desarrollo con manejo centralizado de errores, validaciones, manejo de @anotaciones, unificacion de urls.
 * Características

 -CRUD completo de productos
 -Manejo centralizado de errores con @ControllerAdvice
 -Validaciones personalizadas con excepciones específicas
 -Arquitectura en capas (Controller → Service → Repository)
 -Persistencia con JPA/Hibernate
 -Seguridad básica con Spring Security
 -Timestamps automáticos de creación y actualización

 *Tecnologías Utilizadas
TecnologíaVersiónPropósitoSpring Boot3.xFramework principalSpring Data JPA3.xPersistencia de datosSpring Security6.xAutenticación básicaMySQL8.xBase de datosMaven4.xGestión de dependencias
 Requisitos Previos

Java 17 o superior
Maven 3.6+
MySQL 8.0+
Un cliente REST (Postman, Insomnia, etc.)

 Configuración de Base de Datos
Crear la Base de Datos
Ejecuta el siguiente script SQL en tu servidor MySQL:
sqlCREATE DATABASE productos;
USE productos;

-- La tabla se crea automáticamente gracias a JPA
-- Pero aquí tienes la estructura para referencia:

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    detalle TEXT,
    precio DECIMAL(10,2) NOT NULL,
    fecha_creado DATETIME(6),
    fecha_actualizado DATETIME(6)
);


 API Endpoints
Productos
MétodoEndpointDescripciónBodyGET/productosObtener todos los productos-GET/productos/{id}Obtener producto por ID-POST/productosCrear nuevo productoJSONDELETE/productos/{id}Eliminar producto-
Ejemplo de Producto (JSON)
json{
    "nombre": "Laptop HP",
    "detalle": "Laptop HP Pavilion 15.6 pulgadas",
    "precio": 2500.99
}
Respuesta de Producto
json{
    "id": 1,
    "nombre": "Laptop HP",
    "detalle": "Laptop HP Pavilion 15.6 pulgadas",
    "precio": 2500.99,
    "fechaCreado": "2024-08-24T10:30:00",
    "fechaActualizado": "2024-08-24T10:30:00"
}

 *Manejo de Errores
La API implementa un manejo centralizado de errores con respuestas consistentes:
Errores Comunes
Producto no encontrado (404)
json{
    "codigo": "PRODUCTO_NO_ENCONTRADO",
    "mensaje": "Producto con ID 999 no encontrado",
    "timestamp": "2024-08-24T18:35:00.591"
}
Petición inválida (400)
json{
    "codigo": "PETICION_INVALIDA", 
    "mensaje": "El valor ingresado no puede ser negativo",
    "timestamp": "2024-08-24T18:35:00.591"
}

*Validaciones Implementadas

 -ID no puede ser negativo
 -Validación de existencia de producto
 -Manejo de parámetros inválidos

* Notas de Desarrollo
Problemas Encontrados y Soluciones
Durante el desarrollo me encontré con algunos desafíos típicos de Spring Boot:

Problemas de conexión a MySQL:

Solución: Activé el modo debug y revisé los logs detalladamente
Configuración: spring.jpa.show-sql=true para monitorear las consultas


-Manejo de errores inconsistente:

Solución: Implementé @ControllerAdvice para centralizar el manejo de excepciones
Resultado: Respuestas de error uniformes en toda la API


-Validaciones dispersas:

Solución: Creé excepciones personalizadas específicas para cada caso de uso
Beneficio: Código más limpio y mantenible


-Decisiones de Diseño

Integer vs int: Utilicé Integer para permitir valores null en validaciones
BigDecimal: Para precios, evitando problemas de precisión con double
Timestamps automáticos: @CreationTimestamp y @UpdateTimestamp para auditoría
