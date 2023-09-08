
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class Usuario {
    
    private int codigoUsuario;
    private String nombre;
    private int biblioteca;
    private String cargo;

    public Usuario(int codigoUsuario, String nombre, int biblioteca, String cargo) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.biblioteca = biblioteca;
        this.cargo = cargo;
    }

    public Usuario(int codigoUsuario, String nombre, String cargo) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(int biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
