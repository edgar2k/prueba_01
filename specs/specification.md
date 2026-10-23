# Especificación: Portal SDD Demo

## Estado

Versión inicial, implementada para prácticas locales.

## Objetivo

Proporcionar una aplicación web Java pequeña en la que un usuario pueda autenticarse con credenciales fijas de demostración y acceder a una página índice protegida. El repositorio debe servir como base para ejercicios posteriores con agentes siguiendo Spec-Driven Development.

## Alcance

- Aplicación Spring Boot MVC con vistas Thymeleaf.
- Formulario público en `GET /login`.
- Validación de credenciales estáticas en memoria: usuario `admin`, contraseña `12345`.
- Redirección a `GET /` al autenticar correctamente.
- Protección de `/` y `/index` frente a sesiones anónimas.
- Mensaje de error para credenciales inválidas y cierre de sesión disponible.
- Pruebas automatizadas del acceso, rechazo y autorización.

## Requisitos funcionales

- **RF-01:** Un visitante anónimo que solicita `/` debe ser redirigido a `/login`.
- **RF-02:** El formulario debe aceptar `admin` y `12345`, crear una sesión autenticada y redirigir a `/`.
- **RF-03:** El índice debe mostrar el nombre del usuario autenticado.
- **RF-04:** Cualquier otra combinación de usuario y contraseña debe volver a `/login?error`.
- **RF-05:** El usuario autenticado debe poder cerrar sesión; el resultado debe ser `/login?logout`.
- **RF-06:** Las vistas deben ser utilizables en pantallas móviles y de escritorio.

## Criterios de aceptación

- `mvn test` termina correctamente.
- `GET /` sin sesión responde con redirección a `/login`.
- El envío de credenciales válidas redirige a `/` y la página contiene el nombre `admin`.
- El envío de credenciales inválidas redirige a `/login?error`.
- El cierre de sesión invalida la sesión autenticada.
- No se requiere base de datos, registro, recuperación de contraseña ni proveedor externo de identidad.

## Restricciones y riesgos conocidos

- Las credenciales son públicas, fijas y solo sirven para una demostración local.
- La contraseña `{noop}` no está cifrada; este mecanismo no representa una práctica de producción.
- No desplegar este proyecto con acceso público ni introducir datos reales.
- CSRF permanece habilitado usando la protección predeterminada de Spring Security.

## Fuera de alcance

Persistencia de usuarios, roles administrables, MFA, recuperación de contraseña, rate limiting, auditoría, API REST y despliegue en producción.
