
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class TransporteBiblioteca {
    
    private int codigoTransporteBi;
    private int recepcionista;
    private int bibliotecaOrigen;
    private int bibliotecaDestino;
    private int transportista;
    private String estado;
    private String fecha;

    public TransporteBiblioteca(int codigoTransporteBi, int recepcionista, int bibliotecaOrigen, int bibliotecaDestino, int transportista, String estado, String fecha) {
        this.codigoTransporteBi = codigoTransporteBi;
        this.recepcionista = recepcionista;
        this.bibliotecaOrigen = bibliotecaOrigen;
        this.bibliotecaDestino = bibliotecaDestino;
        this.transportista = transportista;
        this.estado = estado;
        this.fecha = fecha;
    }

    public TransporteBiblioteca(int recepcionista, int bibliotecaOrigen, int bibliotecaDestino, int transportista, String estado, String fecha) {
        this.recepcionista = recepcionista;
        this.bibliotecaOrigen = bibliotecaOrigen;
        this.bibliotecaDestino = bibliotecaDestino;
        this.transportista = transportista;
        this.estado = estado;
        this.fecha = fecha;
    }
    
    
    
    public int getCodigoTransporteBi() {
        return codigoTransporteBi;
    }

    public void setCodigoTransporteBi(int codigoTransporteBi) {
        this.codigoTransporteBi = codigoTransporteBi;
    }

    public int getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(int recepcionista) {
        this.recepcionista = recepcionista;
    }


    public int getTransportista() {
        return transportista;
    }

    public void setTransportista(int transportista) {
        this.transportista = transportista;
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

    public int getBibliotecaOrigen() {
        return bibliotecaOrigen;
    }

    public void setBibliotecaOrigen(int bibliotecaOrigen) {
        this.bibliotecaOrigen = bibliotecaOrigen;
    }

    public int getBibliotecaDestino() {
        return bibliotecaDestino;
    }

    public void setBibliotecaDestino(int bibliotecaDestino) {
        this.bibliotecaDestino = bibliotecaDestino;
    }
    
    
    
}
