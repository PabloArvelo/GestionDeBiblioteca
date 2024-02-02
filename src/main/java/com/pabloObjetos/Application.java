package com.pabloObjetos;

import com.pabloObjetos.modelos.Biblioteca;
import com.pabloObjetos.modelos.Libro;
import com.pabloObjetos.modelos.Persona;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

  public static int opc1, opc2, opcPer;
  public static Persona persona;
  public static Scanner ingresa = new Scanner(System.in);
  public static Biblioteca b1 = new Biblioteca();
  public static Persona[] listadoPersonas = new Persona[3];

  public static void main(String[] args) {
    int contador = 0;

    // creo las instancias de personas - aun no está preparado para cambiar a otra persona

    Persona p1 = new Persona("Pablo", "Arvelo");
    Persona p2 = new Persona("Luis", "Perez");
    Persona p3 = new Persona("Pedro", "Gonzalez");
    listadoPersonas[0] = p1;
    listadoPersonas[1] = p2;
    listadoPersonas[2] = p3;

    System.out.println("LISTADO DE PERSONAS");
    for (Persona listadoPersona : listadoPersonas) {
      contador++;
      System.out.println(contador + " " + listadoPersona.getNombre() + " " + listadoPersona.getApellido());
    }

    System.out.print("Elige una persona:");
    opcPer = ingresa.nextInt();
    persona = listadoPersonas[opcPer - 1];


    do {
      menu();
      opc1 = ingresa.nextInt();
      switch (opc1) {
        case 1:  // crea libro y agrega a la biblioteca
          crearLibro();
          break;
        case 2:  // muestra catálogo
          solicitarLibro();
          break;
        case 3:  // DEVUELVE LIBRO
          devolverLibro();
          break;
        case 4:
          System.out.println("      hasta luego");
          break;
        default:
          System.out.println("      opcion no válida");
          break;
      }

    } while (opc1 != 4);
  }

  public static void menu() {
    System.out.print("\n       ELIJA UNA OPCION \n" +
            "       1 - AGREGAR LIBRO \n" +
            "       2 - MOSTRAR CATALOGO \n" +
            "       3 - DEVOLVER LIBRO \n" +
            "       4 - SALIR \n" +
            "       ► ");
  }

  // crea un libro y lo guarda en el array de libros (catálogo) de la biblioteca
  public static void crearLibro() {
    Scanner ingT = new Scanner(System.in);
    Scanner ingA = new Scanner(System.in);
    Scanner ingN = new Scanner(System.in);
    System.out.print("ingrese título: ");
    String titulo = ingT.nextLine();
    System.out.print("\ningrese autor: ");
    String autor = ingA.nextLine();
    System.out.print("\ningrese cant. páginas: ");
    int nPaginas = ingN.nextInt();
    Libro libro = new Libro(titulo, autor, nPaginas);
    b1.agregarLibrosCatalogo(libro);
  }

  // muestra el catálogo de libros
  // permite elegir un libro para pedirlo prestado
  public static void solicitarLibro() {

    if (b1.getCatalogoLibros().length == 0) {
      System.out.println("aun no hay libros en el catálogo");
    } else {

      b1.mostrarCatalogolibros();

      System.out.print("\n       DESEA PEDIR UN LIBRO? \n" +
              "       1 - SI \n" +
              "       2 - NO \n" +
              "       ► ");
      opc1 = ingresa.nextInt();
      do {
        if (opc1 == 1) { //1
          do { //2
            System.out.print("      ingrese el ID del libro: ");
            opc2 = ingresa.nextInt(); //3
            if (opc2 <= b1.getCatalogoLibros().length) { //4
              b1.prestar(opc2);
              persona.setLibrosPedidos(b1.getCatalogoLibros()[opc2 - 1]);
              System.out.println("      " + persona.getNombre() + " pidió prestado " + persona.getLibrosPedidos()[0].getTitulo());
              System.out.println("      id: " + persona.getLibrosPedidos()[0].getId());
            } else {
              System.out.println("      ID inexistente");
            }
          } while (opc2 > b1.getCatalogoLibros().length);
          System.out.print("\n       DESEA PEDIR OTRO LIBRO? \n" +
                  "       1 - SI \n" +
                  "       2 - NO \n" +
                  "       ► ");
          opc1 = ingresa.nextInt();
        }
        if (opc1 == 1) {
          b1.mostrarCatalogolibros();
        }
      } while (opc1 == 1);

    }

  }

  //  invoca los metodos para devolver el libro
  public static void devolverLibro() {
    if (persona.getLibrosPedidos().length == 0) {
      System.out.println("aun no ha pedido libros");
    } else {
      for (int i = 0; i < persona.getLibrosPedidos().length; i++) {
        System.out.println("id: " + (i + 1) + persona.getLibrosPedidos()[i].getTitulo());
      }

      System.out.println("      ingrese el ID del libro a devolver: ");
      opc2 = ingresa.nextInt();

      // cambia el atributo del libro a DISPONIBLE
      b1.devolver(persona.getLibrosPedidos()[opc2 - 1].getId());

      // invoca el metodo para quitar el libro del array de libros pedidos de la persona
      persona.devuelveLibro(opc2 - 1);
    }
  }
}


