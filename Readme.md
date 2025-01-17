# Cofrade GPT

Cofrade GPT es un agente inteligente de Recuperación Aumentada de Información (RAG) diseñado para interactuar con una base de datos rica en información sobre la Semana Santa de Jerez de la Frontera. Este sistema combina la potencia de Spring Boot y LangChain para ofrecer una experiencia conversacional inmersiva, como si estuvieras charlando con ese amigo que lo sabe todo sobre la Semana Santa jerezana.

## Licencia

Este proyecto está licenciado bajo los términos de la [Licencia MIT](./LICENSE). Puedes usarlo, modificarlo y distribuirlo libremente, siempre y cuando se incluya una copia de la licencia.

## Estructura del Proyecto

El proyecto está organizado en varios módulos, cada uno con una responsabilidad específica:

- ai_logs: Servicio de registro de respuestas de la IA.
- ai_models: Modelos de IA para Chat Cofrade.
- discoveryserver: Servidor de descubrimiento Eureka.
- information: Servicio que publica información de la base de datos.
- vaadin_chat: Interfaz de usuario basada en Vaadin para interactuar con Cofrade GPT.

## Requisitos

- Java 17
- Maven 3.8.7 o superior
- Docker (opcional, para despliegue con Docker Compose o Kubernetes)

## Instalación

1. Clona el repositorio.

2. Configura la variable de entorno $GITHUB_MODELS_TOKEN. Este token es necesario para que el microservicio ai_models pueda interactuar con un modelo GPT de GitHub.

3. Construye el proyecto Maven desde la raiz del proyecto.

```bash
mvn clean install
```
4. Inicia la infraestructura con Docker desde el directorio docker del proyecto.
```bash
docker compose up -d
```

5. Ejecuta los servicios de Spring

## Contribución

Si deseas contribuir al proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
3. Realiza tus cambios y haz commit (git commit -am 'Añadir nueva funcionalidad').
4. Sube tus cambios a tu fork (git push origin feature/nueva-funcionalidad).
5. Abre un Pull Request.


