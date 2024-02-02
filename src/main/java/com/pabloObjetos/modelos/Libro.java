package com.pabloObjetos.modelos;

public class Libro extends ItemBiblioteca{
  //---------------------ATRIBUTOS
  private String titulo;
  private String autor;
  private int numPaginas;
  private boolean prestado;
  private int id;


  //---------------------CONSTRUCTORES
  public Libro() {
  }
  public Libro(String titulo, String autor, int numPaginas) {
    this.titulo = titulo;
    this.autor = autor;
    this.numPaginas = numPaginas;
    this.prestado = false;
  }

  //---------------------GETTERS - SETTERS
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }
  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getNumPaginas() {
    return numPaginas;
  }
  public void setNumPaginas(int numPaginas) {
    this.numPaginas = numPaginas;
  }

  public boolean getPrestado() {
    return prestado;
  }
  public void setPrestado(boolean prestado) {
    this.prestado = prestado;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  //---------------------METODOS
  @Override
  public void prestar(int opcion){
  }
  @Override
  public void devolver(int opcion) {
  }
  @Override
  public void calcularMultas() {
  }

  @Override
  public String toString() {
    if (prestado){
      return "titulo: " + titulo +
              ", autor: " + autor +
              ", Paginas: " + numPaginas +
              ", NO DISPONIBLE" ;
    }else {
      return "titulo: " + titulo +
              ", autor: " + autor +
              ", Paginas: " + numPaginas +
              ", DISPONIBLE" ;
    }
  }
}
