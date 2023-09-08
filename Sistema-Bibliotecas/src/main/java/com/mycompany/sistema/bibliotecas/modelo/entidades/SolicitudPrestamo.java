
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class SolicitudPrestamo {
    
    private int codigoSolicitudPrestamo;
    private int usuario;
    private int recepcionista;
    private int biblioteca;
    private int transportista;
    private int isbn;
    private String estado;
    private String tipo_entrega;
    private String fecha;

    public SolicitudPrestamo(int codigoSolicitudPrestamo, int usuario, int recepcionista, int biblioteca, int transportista, int isbn, String estado, String tipo_entrega, String fecha) {
        this.codigoSolicitudPrestamo = codigoSolicitudPrestamo;
        this.usuario = usuario;
        this.recepcionista = recepcionista;
        this.biblioteca = biblioteca;
        this.transportista = transportista;
        this.isbn = isbn;
        this.estado = estado;
        this.tipo_entrega = tipo_entrega;
        this.fecha = fecha;
    }

    public SolicitudPrestamo(int usuario, int recepcionista, int biblioteca, int transportista, int isbn, String estado, String tipo_entrega, String fecha) {
        this.usuario = usuario;
        this.recepcionista = recepcionista;
        this.biblioteca = biblioteca;
        this.transportista = transportista;
        this.isbn = isbn;
        this.estado = estado;
        this.tipo_entrega = tipo_entrega;
        this.fecha = fecha;
    }

    public SolicitudPrestamo(int codigoSolicitudPrestamo, int usuario, int recepcionista, int biblioteca, int isbn, String fecha) {
        this.codigoSolicitudPrestamo = codigoSolicitudPrestamo;
        this.usuario = usuario;
        this.recepcionista = recepcionista;
        this.biblioteca = biblioteca;
        this.isbn = isbn;
        this.fecha = fecha;
    }
    
    

    public int getCodigoSolicitudPrestamo() {
        return codigoSolicitudPrestamo;
    }

    public void setCodigoSolicitudPrestamo(int codigoSolicitudPrestamo) {
        this.codigoSolicitudPrestamo = codigoSolicitudPrestamo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(int recepcionista) {
        this.recepcionista = recepcionista;
    }

    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getTransportista() {
        return transportista;
    }

    public void setTransportista(int transportista) {
        this.transportista = transportista;
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

    public String getTipo_entrega() {
        return tipo_entrega;
    }

    public void setTipo_entrega(String tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
