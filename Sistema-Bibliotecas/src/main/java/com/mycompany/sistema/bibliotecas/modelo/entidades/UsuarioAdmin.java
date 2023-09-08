
package com.mycompany.sistema.bibliotecas.modelo.entidades;

public class UsuarioAdmin {
    
    private int codigoUsuarioAdmin;
    private String nombre;
    private String nombreUsuario;
    private String contrasenia;
    private String correo;

    public UsuarioAdmin(int codigoUsuarioAdmin, String nombre, String nombreUsuario, String contrasenia, String correo) {
        this.codigoUsuarioAdmin = codigoUsuarioAdmin;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    public int getCodigoUsuarioAdmin() {
        return codigoUsuarioAdmin;
    }

    public void setCodigoUsuarioAdmin(int codigoUsuarioAdmin) {
        this.codigoUsuarioAdmin = codigoUsuarioAdmin;
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
