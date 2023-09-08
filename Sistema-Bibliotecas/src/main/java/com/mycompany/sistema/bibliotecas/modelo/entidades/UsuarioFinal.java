
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class UsuarioFinal {
    
    private int codigoUsuarioFinal;
    private String nombre;
    private String nombreUsuario;
    private String contrasenia;
    private String correo;
    private double saldo;
    private int premiun;

    public UsuarioFinal(int codigoUsuarioFinal, String nombre, String nombreUsuario, String contrasenia, String correo, double saldo, int premiun) {
        this.codigoUsuarioFinal = codigoUsuarioFinal;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.saldo = saldo;
        this.premiun = premiun;
    }

    public UsuarioFinal(String nombre, String nombreUsuario, String contrasenia, String correo, double saldo, int premiun) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.saldo = saldo;
        this.premiun = premiun;
    }

    public UsuarioFinal(String nombre, String nombreUsuario, String correo, double saldo) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.saldo = saldo;
    }

    public UsuarioFinal(int codigoUsuarioFinal, String nombre, String nombreUsuario, String correo) {
        this.codigoUsuarioFinal = codigoUsuarioFinal;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
    }

    public UsuarioFinal(int codigoUsuarioFinal, String nombre, String nombreUsuario, String contrasenia, String correo, double saldo) {
        this.codigoUsuarioFinal = codigoUsuarioFinal;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.saldo = saldo;
    }
    
    

    public int getCodigoUsuarioFinal() {
        return codigoUsuarioFinal;
    }

    public void setCodigoUsuarioFinal(int codigoUsuarioFinal) {
        this.codigoUsuarioFinal = codigoUsuarioFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPremiun() {
        return premiun;
    }

    public void setPremiun(int premiun) {
        this.premiun = premiun;
    }
    
    
    
}
