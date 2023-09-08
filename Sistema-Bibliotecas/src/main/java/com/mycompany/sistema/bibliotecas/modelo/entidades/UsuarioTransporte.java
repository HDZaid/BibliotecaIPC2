
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class UsuarioTransporte {
    
    private int codigoUsuarioTransporte;
    private String nombre;
    private String nombreUsuario;
    private String contrasenia;
    private String correo;

    public UsuarioTransporte(int codigoUsuarioTransporte, String nombre, String nombreUsuario, String contrasenia, String correo) {
        this.codigoUsuarioTransporte = codigoUsuarioTransporte;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    public UsuarioTransporte(String nombre, String nombreUsuario, String contrasenia, String correo) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }
    
    

    public int getCodigoUsuarioTransporte() {
        return codigoUsuarioTransporte;
    }

    public void setCodigoUsuarioTransporte(int codigoUsuarioTransporte) {
        this.codigoUsuarioTransporte = codigoUsuarioTransporte;
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
    
    
}
