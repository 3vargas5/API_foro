# API Rest con Spring

Este proyecto consiste en crear una API Rest usando el framework Spring para simular un foro de matemáticas de preguntas y respuestas. La API permite a los usuarios realizar las siguientes operaciones sobre los tópicos del foro:

- Crear un nuevo tópico
- Mostrar todos los tópicos creados
- Mostrar un tópico específico
- Actualizar un tópico
- Eliminar un tópico

Estas operaciones se conocen como CRUD (CREATE, READ, UPDATE, DELETE) y siguen las mejores prácticas del modelo REST.

## Modelo de datos

La API utiliza una base de datos para la persistencia de la información. El modelo de datos se compone de una entidad llamada Tópico, que tiene los siguientes atributos:

- titulo: el título del tópico, que resume el problema o la pregunta planteada por el usuario.
- mensaje: el mensaje del tópico, que explica con más detalle el problema o la pregunta del usuario.
- estatus: el estatus del tópico, que indica si ha sido resuelto o no. Los posibles valores son: RESUELTO, NO_RESUELTO.
- autor: el nombre de usuario del autor del tópico.
- curso: el curso al que pertenece el tópico. Los posibles valores son: CALCULO, MATEMATICAS_AVANZADAS, OTRAS_MATEMATICAS, ALGEBRA, TRIGONOMETRIA, PROBABILIDAD_ESTADISTICA, GEOMETRIA.

Un ejemplo de un tópico en formato JSON es el siguiente:

```json
{
	"titulo": "¿Cómo demostrar este teorema de geometría?",
	"mensaje": "El teorema dice que si dos triángulos tienen dos lados congruentes y el ángulo comprendido entre ellos también es congruente, entonces los triángulos son congruentes. ¿Cómo puedo demostrarlo usando las propiedades de los triángulos y las congruencias?",
	"estatus": "NO_RESUELTO",
	"autor": "geometry_guru",
	"curso": "GEOMETRIA"
}
```
##Rutas de la API
La API expone las siguientes rutas para interactuar con los tópicos:

- POST /topicos: crea un nuevo tópico y lo guarda en la base de datos. Recibe como parámetro un objeto JSON con los atributos del tópico (excepto el estatus, que se asigna por defecto a NO_RESUELTO). Devuelve el tópico creado con un código de respuesta 201 (CREATED).

- GET /topicos: muestra todos los tópicos existentes en la base de datos. No recibe ningún parámetro. Devuelve una lista de objetos JSON con los atributos de los tópicos y un código de respuesta 200 (OK).

- GET /topicos/{id}: muestra el tópico con el identificador especificado en la ruta. No recibe ningún parámetro. Devuelve un objeto JSON con los atributos del tópico y un código de respuesta 200 (OK). Si no existe ningún tópico con ese identificador, devuelve un código de respuesta 404 (NOT FOUND).

- PUT /topicos/{id}: actualiza el tópico con el identificador especificado en la ruta. Recibe como parámetro un objeto JSON con los atributos del tópico que se quieren modificar. Devuelve el tópico actualizado con un código de respuesta 200 (OK). Si no existe ningún tópico con ese identificador, devuelve un código de respuesta 404 (NOT FOUND).

- DELETE /topicos/{id}: elimina el tópico con el identificador especificado en la ruta. No recibe ningún parámetro. Devuelve un código de respuesta 204 (NO CONTENT). Si no existe ningún tópico con ese identificador, devuelve un código de respuesta 404 (NOT FOUND).
