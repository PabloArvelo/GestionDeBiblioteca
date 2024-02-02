## ✏️ Actividad - Gestión de biblioteca
Debes diseñar un sistema de gestión de biblioteca en el que tengas clases abstractas e interfaces para representar libros, revistas y películas. Para esto deberás:

- Crea una clase abstracta "ItemBiblioteca" que contenga métodos abstractos como "prestar()", "devolver()" y "calcularMultas()". 

- Luego, crea las clases concretas “Libro”, “Revista” y “Pelicula” que extiendan esta clase y proporcionan implementaciones concretas de los métodos. 

- Crea una interfaz llamada "Catalogable" con métodos para obtener información sobre el elemento bibliotecario (por ejemplo, título, autor, etc.) y haz que todas las clases implementen esta interfaz. 

- Agregue los atributos “titulo”, “autor” y “numeroDePaginas” a la clase “Libro”. Además, implementa un método “mostrarInformación()” que muestre la información del libro en consola.

- Crea la clase “Biblioteca” que contenga un arreglo de objetos “Libro” para mantener un catálogo de libros disponibles en la biblioteca. La biblioteca también debe tener un método para agregar libros al catálogo.

- Crear una instancia de la clase Biblioteca y agregar varios libros al catálogo .

- Implementa un menú por consola que permite al usuario agregar libros a la biblioteca y mostrar la información de los libros en el catálogo.
