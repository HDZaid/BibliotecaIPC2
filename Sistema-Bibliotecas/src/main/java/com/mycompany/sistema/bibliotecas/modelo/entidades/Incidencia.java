
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class Incidencia {
    
    private int codigoIncidencia;
    private int prestamo ;
    private String tipoIncidencia;
    private double cantidadPagada;

    public Incidencia(int codigoIncidencia, int prestamo, String tipoIncidencia, double cantidadPagada) {
        this.codigoIncidencia = codigoIncidencia;
        this.prestamo = prestamo;
        this.tipoIncidencia = tipoIncidencia;
        this.cantidadPagada = cantidadPagada;
    }

    public Incidencia(int prestamo, String tipoIncidencia, double cantidadPagada) {
        this.prestamo = prestamo;
        this.tipoIncidencia = tipoIncidencia;
        this.cantidadPagada = cantidadPagada;
    }

    public int getCodigoIncidencia() {
        return codigoIncidencia;
    }

    public void setCodigoIncidencia(int codigoIncidencia) {
        this.codigoIncidencia = codigoIncidencia;
    }

    public int getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public double getCantidadPagada() {
        return cantidadPagada;
    }

    public void setCantidadPagada(double cantidadPagada) {
        this.cantidadPagada = cantidadPagada;
    }
    
    
}
