# ForoHub API

API REST desarrollada con **Spring Boot** para la gestión de tópicos de un foro.  
Permite registrar usuarios, autenticarse mediante **JWT**, y realizar operaciones CRUD sobre los tópicos.

El proyecto sigue una arquitectura basada en **capas (Controller, Service, Repository y Domain)** utilizando **Spring Data JPA** y **Hibernate** para la persistencia de datos.

---

## Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL / Base de datos relacional
- Maven
- Lombok

---

## Arquitectura del proyecto

El proyecto está organizado en diferentes capas para mantener una separación clara de responsabilidades.
### Controller
Se encarga de recibir las peticiones HTTP y devolver las respuestas al cliente.

### Service
Contiene la lógica de negocio de la aplicación.

### Repository
Se encarga de la comunicación con la base de datos mediante **Spring Data JPA**.

### Domain
Contiene las entidades del sistema y los DTO utilizados para transferencia de datos.

---

# Seguridad

La API utiliza **Spring Security con JWT** para proteger los endpoints.

Para acceder a la mayoría de los recursos es necesario enviar un token JWT válido en el header:
- Authorization: Bearer Token

---

# Endpoints públicos (sin autenticación)

Se permite acceso sin JWT únicamente para los endpoints necesarios para **crear cuenta e iniciar sesión**.

## Crear usuario

Permite registrar una nueva cuenta.
### POST /usuarios
Ejemplo de body:

```json
{
  "nombre": "Juan Perez",
  "correoElectronico": "juan@email.com",
  "contrasena": "123456"
}
```
## Iniciar sesión

Permite autenticar un usuario y obtener un JWT.
### POST /login
Ejemplo de body:

```json
{
  "correoElectronico": "juan@email.com",
  "contrasena": "123456"
}
```
Respuesta:
```json
{
  "token": "jwt_token_generado"
}
```
# Endpoints de tópicos
Todos los endpoints de tópicos requieren autenticación mediante JWT a excepcion del GET, suponiendo que una persona sin cuenta puede ver el contenido del foro sin problema.
## Crear tópico
### POST /topicos
Crea un nuevo tópico en el foro, ejemplo de body:
```json
{
  "titulo": "Problema con Spring Boot",
  "mensaje": "No puedo configurar mi aplicación",
  "cursoId": 1
}
```
## Listar tópicos
### GET /topicos
Permite obtener una lista paginada de tópicos.

También permite filtros opcionales, parámetros disponibles:
- curso
- anio
### GET /topicos?curso=Spring o /topicos?año=2020 

## Obtener detalle de tópico
### GET /topicos/{id}
Permite obtener información detallada de un solo tópico.

## Actualizar tópico
### PUT /topicos/{id}
Permite modificar la información de un tópico.
Ejemplo:
```json
{
  "titulo": "Nuevo titulo del topico",
  "mensaje": "Mensaje actualizado"
}
```
## Eliminar tópico
### DELETE /topicos/{id}
Elimina un tópico del sistema.
Respuesta:
```json
204 No Content
```

# Flujo de uso de la API
1. Crear una cuenta
```json
POST /usuarios
```
2. Iniciar sesión
```json
- POST /login
```
3. Obtener el token JWT.
4. Enviar el token en el header de las peticiones:
```json
Authorization: Bearer TOKEN
```
5. Consumir los endpoints protegidos.

# Manejo de errores
La API devuelve códigos HTTP estándar para indicar el resultado de cada operación.

| Código | Significado |
|------|-------------|
| 200 | Operación exitosa |
| 201 | Recurso creado |
| 204 | Eliminación exitosa |
| 400 | Error de validación |
| 401 | No autenticado |
| 403 | Acceso prohibido |
| 404 | Recurso no encontrado |
| 500 | Error interno del servidor |
