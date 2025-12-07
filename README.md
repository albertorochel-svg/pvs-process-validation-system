Process Validation System (PVS)
Resumen ejecutivo
Descripción

El Process Validation System (PVS) es una aplicación diseñada para apoyar al área de entrenamiento en la validación diaria de procesos en líneas de producción. Su objetivo es asegurar que cada estación opere con el personal correcto, en la cantidad adecuada, y con las certificaciones requeridas según el modelo configurado por ingeniería.

Problema identificado

Actualmente, los entrenadores deben validar manualmente:

Qué líneas están en operación.

Si cada estación cuenta con operadores certificados.

Si existe personal extra o no autorizado.

Si el entrenador completó o no la captura diaria.

Este procedimiento manual es lento, propenso a errores y dificulta la trazabilidad.

Solución propuesta

El sistema PVS proporciona:

Dashboard general de líneas con estatus en tiempo real.

Validación automática de certificaciones por estación.

Identificación de personal extra o faltante.

Registro digital de capturas diarias.

Integración con GitHub, CI/CD y Trello para facilitar la evolución ágil del producto.

Arquitectura

El sistema está basado en una arquitectura de múltiples capas:

Cliente (navegador web)
Vista del dashboard, detalle de líneas y captura diaria.

Servidor web / servidor de aplicaciones (Java + Maven)
Controladores REST/MVC que reciben solicitudes y envían respuestas al cliente.

Capa de servicios de negocio
ValidationService procesa reglas de certificación, conteo de personal y alertas.

Base de datos
Almacena líneas, estaciones, operadores, certificaciones y registros diarios.

Repositorio de código (GitHub)
Control de versiones mediante ramas master, develop y feature/*.

Integración continua (Travis CI)
Ejecuta pruebas unitarias de forma automática.

Gestor de tareas (Trello)
Ordena backlog, Beta, GA y futuras funcionalidades.

Tabla de contenidos (ToC)

Resumen ejecutivo

Requerimientos

Instalación

Configuración

Uso

Contribución

Roadmap

Producto final

Requerimientos
Servidores

Servidor de aplicación compatible con Tomcat, GlassFish o cualquier contenedor Java.

Servidor web integrado con el contenedor de servlets.

Base de datos: MySQL, PostgreSQL o H2 (modo desarrollo).

Paquetes adicionales

Maven 3.9 o superior

JUnit 5

Git 2.0+

Travis CI (opcional para CI/CD)

Versión de Java

Java 17 (OpenJDK recomendado)

Instalación
1. Instalar ambiente de desarrollo

Clonar el repositorio:

git clone https://github.com/albertorochel-svg/pvs-process-validation-system.git
cd pvs-process-validation-system


Instalar dependencias y compilar:

mvn clean install


Abrir el proyecto en el IDE de preferencia usando la opción "Import as Maven Project".

Crear una rama de desarrollo:

git checkout -b feature/nueva-funcionalidad

2. Ejecutar pruebas manualmente

Ejecutar pruebas con Maven:

mvn test


Ejecutar pruebas desde el IDE: clic derecho en la clase ValidationServiceTest → Run Test.

3. Implementar la solución en producción
Implementación local

Generar el archivo ejecutable:

mvn clean package


Ejecutar la aplicación:

java -jar target/pvs-process-validation-system-0.0.1-SNAPSHOT.jar

Implementación en la nube (Heroku)

Iniciar sesión en Heroku:

heroku login


Crear la aplicación:

heroku create pvs-validation-system


(Optativo) Crear base de datos:

heroku addons:create heroku-postgresql:hobby-dev


Desplegar:

git push heroku master


Abrir aplicación:

heroku open

Configuración
Configuración del producto

Archivo principal:
src/main/resources/application.properties

Parámetros típicos:

Conexión a BD

Puerto del servidor

Logs

Modo desarrollo/producción

Configuración del entorno

Java 17 debe estar en JAVA_HOME

Maven agregado al PATH

Git configurado para permitir push/pull

Travis CI con archivo .travis.yml incluido

Uso
Referencia para usuario final

El usuario podrá:

Acceder al dashboard.

Seleccionar una línea.

Ver operadores asignados y sus certificaciones.

Verificar alertas por personal extra o faltante.

Registrar validación diaria.

Referencia para usuario administrador

Funciones del administrador:

Gestionar usuarios y permisos.

Crear o modificar líneas y estaciones.

Actualizar certificaciones.

Consultar reportes y logs.

Revisar historial de validaciones.

Contribución
Flujo de trabajo

Clonar el repositorio

git clone https://github.com/albertorochel-svg/pvs-process-validation-system.git


Crear una rama

git checkout -b feature/nombre


Realizar cambios

git add .
git commit -m "Descripción clara"


Subir cambios

git push origin feature/nombre


Crear un Pull Request hacia develop

Esperar revisión y aprobación

Roadmap
Funcionalidades futuras

Integración con RRHH para certificaciones automáticas.

Conexión con MES para detectar líneas activas.

Gráficas semanales de validaciones.

Autenticación SSO.

Exportación de auditorías a PDF.

App móvil para capturas.

Mejoras técnicas

Migración a Spring Boot.

Dockerización del backend.

Migración de Travis CI a GitHub Actions.

BD PostgreSQL para producción.

