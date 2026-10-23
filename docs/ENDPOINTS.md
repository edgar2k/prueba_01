# Endpoints externos consumidos

## Estado actual

La aplicación no consume endpoints HTTP externos en tiempo de ejecución. No realiza solicitudes salientes a APIs, servicios de identidad, bases de datos ni otros servicios remotos. Por tanto, no hay solicitudes externas, datos enviados ni respuestas externas que documentar en esta versión.

La autenticación usa un usuario fijo en memoria mediante Spring Security. El formulario y el índice forman parte de esta misma aplicación; `/login` es un endpoint local de autenticación, no una API externa ni un proveedor de identidad.

## Herramientas de desarrollo

Durante la compilación, Maven puede descargar dependencias desde los repositorios configurados en `pom.xml` (por defecto, Maven Central). Estas solicitudes las realiza Maven como herramienta de build; no son llamadas HTTP realizadas por la aplicación en ejecución.

## Integraciones futuras

Antes de añadir una integración, documentar aquí cada endpoint consumido con:

- Propósito y sistema propietario.
- Método HTTP y URL base/ruta, sin incluir secretos.
- Headers y parámetros requeridos.
- Formato y campos enviados en la solicitud.
- Códigos de respuesta y formato/campos esperados.
- Autenticación, timeouts, reintentos y manejo de errores.
- Datos sensibles transmitidos y consideraciones de privacidad.
