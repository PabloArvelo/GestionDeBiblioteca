package com.pabloObjetos.modelos;

import com.pabloObjetos.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

  @Test
  void agregarLibrosCatalogo() {
    Biblioteca b1 = new Biblioteca();
    //Libro[] libros = new Libro[]{new Libro("La Biblia", "Dios", 1000)};

    Libro l1 = new Libro("La Biblia", "Dios", 1000);
    b1.agregarLibrosCatalogo(l1);

    //assertArrayEquals(libros, b1.getCatalogoLibros());
    assertTrue(b1.getCatalogoLibros()[0] instanceof Libro);

  }
}