package com.pabloObjetos.modelos;

import java.util.Arrays;

public class Persona {
  private String nombre;
  private String apellido;
  private Libro[] librosPedidos;
  private Libro[] librosPedidosCopy;

  //---------------------CONSTRUCTORES
  public Persona() {
  }
  public Persona(String nombre, String apellido) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.librosPedidos = new Libro[0];
  }
//---------------------GETTERS - SETTERS

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public Libro[] getLibrosPedidos() {
      return librosPedidos;
  }

  // agrega el libro que se pide al array LibrosPedidos de la persona
  public void setLibrosPedidos(Libro libro) {
    librosPedidos = Arrays.copyOf(librosPedidos, librosPedidos.length+1);
    librosPedidos[librosPedidos.length-1]=libro;
  }

  // quita el libro que se devuelve del array LibrosPedidos de la persona
  public void devuelveLibro(int id){

    librosPedidosCopy = new Libro[librosPedidos.length-1];
    int contador = 0;
    for (int i = 0; i < librosPedidos.length; i++) {
      if (i != id){
        librosPedidosCopy[contador]= librosPedidos[i];
        contador++;
      }
    }
    librosPedidos = librosPedidosCopy;
  }
}
