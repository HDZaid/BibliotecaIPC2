
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class LibrosTotal {
    
    private int biblioteca;
    private int isbn;
    private int existencias;
    private String nombreLibro;
    private String autor;
    private String descripcion;

    public LibrosTotal(int biblioteca, int isbn, int existencias, String nombreLibro, String autor, String descripcion) {
        this.biblioteca = biblioteca;
        this.isbn = isbn;
        this.existencias = existencias;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    
    
    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
