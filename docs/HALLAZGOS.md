# Hallazgos

Alcance: revisión documental de `README.md` y `docs/ENDPOINTS.md` únicamente. No se inspeccionó la implementación ni se ejecutaron pruebas; por ello, los riesgos de comportamiento en ejecución son hipótesis basadas en lo documentado.

| afirmacion | evidencia archivo:linea | comprobado o hipotesis | prueba propuesta |
|---|---|---|---|
| El README publica una cuenta fija (`admin` / `12345`) y afirma que la contraseña se compara sin hash (`{noop}`). Si esta configuración se usa fuera del ejercicio local, las credenciales conocidas y sin hash permiten autenticaciones no autorizadas y exponen una contraseña débil. | `README.md:18-21,43` | Comprobado como afirmación del README; el uso efectivo en ejecución y cualquier despliegue son hipótesis, pues no se leyó el código. | Prueba local: enviar `POST /login` con `admin` / `12345` y comprobar que autentica, conforme a las credenciales de demostración. Enviar una contraseña distinta y comprobar que no autentica. Repetir con un valor de usuario que incluya una comilla, por ejemplo `admin'`, y comprobar que no autentica. El documento no especifica nombres de campos ni el comportamiento específico ante comillas; confirmar el contrato del formulario antes de automatizar la solicitud. |
| No se documentan controles contra intentos repetidos de inicio de sesión; según el README, no hay controles de fuerza bruta. Si también están ausentes en ejecución, es posible probar contraseñas repetidamente sin limitación documentada. | `README.md:41-43` | Comprobado como limitación declarada en el README; la ausencia efectiva de controles en ejecución es hipótesis, ya que no se inspeccionó la implementación. | Prueba local: enviar varios intentos con credenciales inválidas y verificar si existe bloqueo, demora o limitación. El README declara que no hay controles de fuerza bruta, por lo que el resultado esperado según lo documentado es que no exista tal protección; el comportamiento HTTP concreto no está especificado. Incluir en la misma prueba los casos válido (`admin` / `12345`), inválido y usuario con comilla descritos en la fila anterior. |

## Preguntas abiertas

- ¿La cuenta y la contraseña `{noop}` documentadas se limitan efectivamente al entorno didáctico local?
- ¿Qué nombres de campos recibe `POST /login` y qué respuestas establece el contrato para un rechazo o para una entrada con comilla?
- ¿Hay limitación de intentos implementada aunque el README indique que no existe?

## Comandos no ejecutados

- `mvn test`
- Iniciar la aplicación localmente y enviar solicitudes de prueba a `http://localhost:8080/login` con credenciales ficticias o las credenciales de demostración documentadas.
