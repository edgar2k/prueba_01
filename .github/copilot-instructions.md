# Instrucciones para agentes

Este repositorio es una base de práctica SDD (Spec-Driven Development).

- Lee `specs/specification.md`, `plan/implementation-plan.md` y `tasks/tasks.md` antes de cambiar comportamiento.
- Trata la especificación como fuente de verdad y plantea preguntas si hay requisitos contradictorios o incompletos.
- Para cada cambio funcional, actualiza primero la especificación y el plan/tareas afectados; luego implementa y añade o ajusta pruebas de aceptación.
- Mantén aislada la autenticación de demostración. No presentes las credenciales estáticas como seguras ni añadas secretos reales.
- Ejecuta `mvn test` para validar cambios. No marques una tarea como completada si sus criterios no están verificados.
- Evita ampliar el alcance, incorporar base de datos o proveedores de identidad sin una tarea SDD que lo solicite.
