
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class Revocacion {
    
    private int codigoRevocacion;
    private int usuario;
    private String detalle;
    private String estado;

    public Revocacion(int codigoRevocacion, int usuario, String detalle, String estado) {
        this.codigoRevocacion = codigoRevocacion;
        this.usuario = usuario;
        this.detalle = detalle;
        this.estado = estado;
    }

    public Revocacion(int usuario, String detalle, String estado) {
        this.usuario = usuario;
        this.detalle = detalle;
        this.estado = estado;
    }

    
    
    public int getCodigoRevocacion() {
        return codigoRevocacion;
    }

    public void setCodigoRevocacion(int codigoRevocacion) {
        this.codigoRevocacion = codigoRevocacion;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
