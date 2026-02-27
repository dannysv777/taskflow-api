# Taskflow API

## Descripción

TaskFlow es una API rest construida en Java con Spring Boot que modela el funcionamiento de tres estructuras de datos en memoria:

- Lista Enlazada (LinkedList) --> Backlog de tareas
- Pila (Stack) -> Registro de acciones tipo "Undo"
- Cola (Queue) -> (procesamiento por orden de llegada)

El objetivo fue aplicar correctamente arquitectura por capas (Controller -> Service -> Repository -> Model) y operar estructuras de datos reales sin base de datos.

---

## Stack Tecnológico

- Lenguaje: Java 21
- Framework: Spring Boot
- Build Tool: Maven
- Servidor: Tomcat

---

## Ejecución del Proyecto
mvnw spring-boot:run
### Se inicia en: http://localhost:8080
## Endpoints 
### Backlog (Lista Enlazada)
Método - Endpoint - Descripción

POST	/backlog/tasks	Crear tarea

GET	/backlog/tasks	Listar tareas

GET	/backlog/tasks/{id}	Obtener tarea

DELETE	/backlog/tasks/{id}	Eliminar tarea

### Undo (Pila)
POST	/undo	Registrar acción (push)

GET	/undo/peek	Ver última acción

DELETE	/undo	Deshacer acción (pop)

### Processing Queue (Cola)

Método	Endpoint	Descripción

POST	/queue	Encolar tarea

GET	/queue/next	Ver siguiente

DELETE	/queue	Procesar siguiente (dequeue)

### Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd taskflow

Probar con cURL:
## Crear backlog: 
curl -i -X POST http://localhost:8080/backlog/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Aprender colas"}'

## Listar backlog:
curl -i http://localhost:8080/backlog/tasks

## Encolar una tarea: 
curl -i -X POST http://localhost:8080/queue \
  -H "Content-Type: application/json" \
  -d '{"taskId":"<ID_DE_LA_TAREA>"}'

## Ver siguiente en cola: 
curl -i http://localhost:8080/queue/next

## Procesar siguiente: 
curl -i -X DELETE http://localhost:8080/queue