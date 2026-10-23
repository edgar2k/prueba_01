# Portal SDD Demo

Aplicación web Java mínima para practicar desarrollo guiado por especificaciones (SDD). Incluye autenticación estática de demostración, una página de inicio protegida y documentos de especificación, plan y tareas.

## Requisitos

- JDK 17 o superior
- Maven 3.9 o superior

## Ejecutar

```powershell
mvn spring-boot:run
```

Abre `http://localhost:8080` en el navegador. La ruta `/` redirige al formulario si no hay una sesión autenticada.

## Credenciales de demostración

- Usuario: `admin`
- Contraseña: `12345`

## Verificar

```powershell
mvn test
mvn package
```

Las pruebas cubren el acceso anónimo, credenciales incorrectas y el acceso correcto al índice.

## Estructura de SDD

- `specs/`: requisitos y criterios de aceptación
- `plan/`: arquitectura y enfoque de implementación
- `tasks/`: trabajo inicial y posibles siguientes ejercicios
- `.github/copilot-instructions.md`: reglas para agentes que trabajen sobre el proyecto

Antes de implementar un cambio, consulta y actualiza los documentos SDD relevantes. Mantén las pruebas alineadas con los criterios de aceptación.

## Limitaciones

La cuenta se define en memoria y la contraseña se compara sin hash mediante `{noop}` para hacer visible la mecánica en un ejercicio local. No hay persistencia, recuperación de contraseña, controles de fuerza bruta ni administración de usuarios. Esta configuración es exclusivamente didáctica y no debe desplegarse ni reutilizarse en producción.
