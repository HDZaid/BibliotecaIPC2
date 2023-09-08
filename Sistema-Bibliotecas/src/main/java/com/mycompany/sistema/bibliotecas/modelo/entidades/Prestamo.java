
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class Prestamo {

    private int codigoPrestamo;
    private int recepcionista;
    private int bibloteca;
    private int usuario;
    private int isbn;
    private String estado;
    private double multa;
    private String fechaPrestamo;
    private String fechaDevolucion;

    public Prestamo(int codigoPrestamo, int recepcionista, int bibloteca, int usuario, int isbn, String estado, double multa, String fechaPrestamo, String fechaDevolucion) {
        this.codigoPrestamo = codigoPrestamo;
        this.recepcionista = recepcionista;
        this.bibloteca = bibloteca;
        this.usuario = usuario;
        this.isbn = isbn;
        this.estado = estado;
        this.multa = multa;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(int recepcionista, int bibloteca, int usuario, int isbn, String estado, double multa, String fechaPrestamo, String fechaDevolucion) {
        this.recepcionista = recepcionista;
        this.bibloteca = bibloteca;
        this.usuario = usuario;
        this.isbn = isbn;
        this.estado = estado;
        this.multa = multa;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(int codigoPrestamo, int recepcionista, int bibloteca, int usuario, int isbn, String estado, double multa, String fechaPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
        this.recepcionista = recepcionista;
        this.bibloteca = bibloteca;
        this.usuario = usuario;
        this.isbn = isbn;
        this.estado = estado;
        this.multa = multa;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Prestamo(int recepcionista, int bibloteca, int usuario, int isbn, String fechaPrestamo, String fechaDevolucion) {
        this.recepcionista = recepcionista;
        this.bibloteca = bibloteca;
        this.usuario = usuario;
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    
    
    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(int codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public int getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(int recepcionista) {
        this.recepcionista = recepcionista;
    }

    public int getBibloteca() {
        return bibloteca;
    }

    public void setBibloteca(int bibloteca) {
        this.bibloteca = bibloteca;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
}
