# Plan de implementación

## Arquitectura inicial

- Java 17 y Maven administran compilación y dependencias.
- Spring Boot arranca la aplicación y configura MVC.
- `SecurityConfig` define el usuario demo, las rutas públicas/protegidas, el formulario y el logout.
- `PageController` mapea las vistas y entrega el usuario autenticado al índice.
- Thymeleaf renderiza `login.html` e `index.html`; `static/css/styles.css` contiene el diseño adaptable.
- `SecurityFlowTest` verifica las rutas y el comportamiento de autenticación con MockMvc.

## Secuencia SDD para los cambios

1. Aclarar el problema y actualizar los requisitos/criterios de `specs/specification.md`.
2. Registrar decisiones, componentes afectados y riesgos en este plan.
3. Desglosar la implementación comprobable en `tasks/tasks.md`.
4. Implementar el cambio mínimo que satisfaga los criterios.
5. Añadir o ajustar pruebas de aceptación y ejecutar `mvn test`.
6. Actualizar los documentos con el resultado real y cualquier limitación.

## Decisiones iniciales

- Spring Security gestiona la sesión y la protección de rutas, evitando autenticación artesanal en el controlador.
- El almacenamiento en memoria y `{noop}` hacen explícita la naturaleza didáctica; no deben convertirse en configuración de producción.
- La página índice `/` es la ruta de llegada tras el login, y `/index` es un alias protegido.

## Riesgos

- Credenciales codificadas y contraseña sin hash son inseguras fuera del entorno local de práctica.
- No se confirmó disponibilidad de Maven en el entorno inicial; debe ejecutarse la compilación en una instalación con JDK 17+ y Maven 3.9+.

## Ideas para ejercicios posteriores

- Sustituir el usuario en memoria por almacenamiento persistente y hashes de contraseña.
- Añadir autorización por rol con vistas diferenciadas.
- Introducir logout/expiración de sesión con criterios explícitos.
- Añadir pruebas de accesibilidad, validación visual y CI.
