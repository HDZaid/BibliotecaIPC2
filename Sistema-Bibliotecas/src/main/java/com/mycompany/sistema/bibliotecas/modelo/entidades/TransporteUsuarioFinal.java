
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class TransporteUsuarioFinal {
    
    private int codigoTransporteFinal;
    private int usuario;
    private int transportista;
    private int biblioteca;
    private int isbn;
    private String estado;
    private String fecha;

    public TransporteUsuarioFinal(int codigoTransporteFinal, int usuario, int transportista, int biblioteca, int isbn, String estado, String fecha) {
        this.codigoTransporteFinal = codigoTransporteFinal;
        this.usuario = usuario;
        this.transportista = transportista;
        this.biblioteca = biblioteca;
        this.isbn = isbn;
        this.estado = estado;
        this.fecha = fecha;
    }

    public TransporteUsuarioFinal(int usuario, int transportista, int biblioteca, int isbn, String estado, String fecha) {
        this.usuario = usuario;
        this.transportista = transportista;
        this.biblioteca = biblioteca;
        this.isbn = isbn;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getCodigoTransporteFinal() {
        return codigoTransporteFinal;
    }

    public void setCodigoTransporteFinal(int codigoTransporteFinal) {
        this.codigoTransporteFinal = codigoTransporteFinal;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getTransportista() {
        return transportista;
    }

    public void setTransportista(int transportista) {
        this.transportista = transportista;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
