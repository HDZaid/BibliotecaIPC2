
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class LibrosTransporte {
    
    private int idLibrosTransporte;
    private int codigoTransporteBiblio;
    private int isbn;
    private int unidades;

    public LibrosTransporte(int idLibrosTransporte, int codigoTransporteBiblio, int isbn, int unidades) {
        this.idLibrosTransporte = idLibrosTransporte;
        this.codigoTransporteBiblio = codigoTransporteBiblio;
        this.isbn = isbn;
        this.unidades = unidades;
    }

    public LibrosTransporte(int codigoTransporteBiblio, int isbn, int unidades) {
        this.codigoTransporteBiblio = codigoTransporteBiblio;
        this.isbn = isbn;
        this.unidades = unidades;
    }

    public int getIdLibrosTransporte() {
        return idLibrosTransporte;
    }

    public void setIdLibrosTransporte(int idLibrosTransporte) {
        this.idLibrosTransporte = idLibrosTransporte;
    }

    public int getCodigoTransporteBiblio() {
        return codigoTransporteBiblio;
    }

    public void setCodigoTransporteBiblio(int codigoTransporteBiblio) {
        this.codigoTransporteBiblio = codigoTransporteBiblio;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    
    
}
