
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class LibrosBiblioteca {
    
    private int idLibrosBiblioteca;
    private int biblioteca;
    private int existencias;
    private int isbn;

    public LibrosBiblioteca(int idLibrosBiblioteca, int biblioteca, int existencias, int isbn) {
        this.idLibrosBiblioteca = idLibrosBiblioteca;
        this.biblioteca = biblioteca;
        this.existencias = existencias;
        this.isbn = isbn;
    }

    public LibrosBiblioteca(int biblioteca, int existencias, int isbn) {
        this.biblioteca = biblioteca;
        this.existencias = existencias;
        this.isbn = isbn;
    }

    public int getIdLibrosBiblioteca() {
        return idLibrosBiblioteca;
    }

    public void setIdLibrosBiblioteca(int idLibrosBiblioteca) {
        this.idLibrosBiblioteca = idLibrosBiblioteca;
    }

    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    
    
}
