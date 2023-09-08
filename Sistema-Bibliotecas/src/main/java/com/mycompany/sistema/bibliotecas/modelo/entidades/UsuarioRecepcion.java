
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class UsuarioRecepcion {
    
    private int codigoUsuarioRecepcion;
    private String nombre;
    private String usuario;
    private String constrasenia;
    private String correo;
    private int biblioteca;

    public UsuarioRecepcion(int codigoUsuarioRecepcion, String nombre, String usuario, String constrasenia, String correo, int biblioteca) {
        this.codigoUsuarioRecepcion = codigoUsuarioRecepcion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.constrasenia = constrasenia;
        this.correo = correo;
        this.biblioteca = biblioteca;
    }

    public UsuarioRecepcion(String nombre, String usuario, String constrasenia, String correo, int biblioteca) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.constrasenia = constrasenia;
        this.correo = correo;
        this.biblioteca = biblioteca;
    }

    public int getCodigoUsuarioRecepcion() {
        return codigoUsuarioRecepcion;
    }

    public void setCodigoUsuarioRecepcion(int codigoUsuarioRecepcion) {
        this.codigoUsuarioRecepcion = codigoUsuarioRecepcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
}
