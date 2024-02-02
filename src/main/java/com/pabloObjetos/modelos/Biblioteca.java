package com.pabloObjetos.modelos;

import com.pabloObjetos.Application;

import java.util.Arrays;

public class Biblioteca extends ItemBiblioteca {

  //---------------------ATRIBUTOS
  private static Libro[] catalogoLibros = new Libro[0]; // la hice estática para poder usarla en el
  // metodo mostrarCatalogolibros()

  //---------------------CONSTRUCTORES
  public Biblioteca() {
  }

  public Biblioteca(Libro[] catalogoLibros) {
    catalogoLibros = catalogoLibros;
  }

  //---------------------GETTERS - SETTERS
  public Libro[] getCatalogoLibros() {
    return catalogoLibros;
  }

  public void setCatalogoLibros(Libro[] catalogoLibros) {
    catalogoLibros = catalogoLibros;
  }

  //---------------------OVERRIDES


  //---------------------METODOS
  public void agregarLibrosCatalogo(Libro libro) {
    catalogoLibros = Arrays.copyOf(catalogoLibros, catalogoLibros.length + 1);

    catalogoLibros[catalogoLibros.length - 1] = libro;
    libro.setId(catalogoLibros.length - 1);
  }

  public void mostrarCatalogolibros() {
    if (catalogoLibros.length == 0){
      System.out.println("      no hay libros en el catálogo");
    }else {
      System.out.println("      LISTADO DE LIBROS");
      for (int i = 0; i < catalogoLibros.length; i++) {
        System.out.println("      id: " + (i + 1) + " - " + Biblioteca.catalogoLibros[i].toString());
      }
    }
  }

  @Override
  public void prestar(int opcion) {
    for (int i = 0; i < catalogoLibros.length; i++) {
      if (i == opcion - 1) {
        if (catalogoLibros[i].getPrestado()) {
          System.out.println("      Libro no disponibe, ya fue prestado");
        } else {
          catalogoLibros[i].setPrestado(true);
          System.out.println("      libro "+catalogoLibros[i].getTitulo()+" prestado");
        }
      }
    }
  }

  @Override
  public void devolver(int id) { // este int recibe el id que almacenó el libro segun la
                                 // posición que tenía en el array de la biblioteca

    if (catalogoLibros.length == 0 ){
      System.out.println("      aun no pidió libros");
    }else {
      for (int i = 0; i < catalogoLibros.length; i++) {
        if (i == id){
          catalogoLibros[i].setPrestado(false);


          System.out.println("      libro devuelto");
        }
    }


    }

  }

  @Override
  public void calcularMultas() {

  }
}
