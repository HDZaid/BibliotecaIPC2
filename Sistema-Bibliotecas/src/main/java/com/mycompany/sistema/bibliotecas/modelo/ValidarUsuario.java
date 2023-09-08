
package com.mycompany.sistema.bibliotecas.modelo;

import com.mycompany.sistema.bibliotecas.modelo.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidarUsuario {
    
    private static Connection conexion;
    
    public Usuario validarUsuario(String username, String contraseña){
        Usuario usuario = null;
        
        if(encontrarAdmin(username, contraseña) != null ){
            return usuario = encontrarAdmin(username, contraseña);
        }else if(encontrarUsuarioRecepcion(username, contraseña) != null ){
            return usuario = encontrarUsuarioRecepcion(username, contraseña);
        }else if(encontrarUsuarioFinal(username, contraseña) != null ){
            return usuario = encontrarUsuarioFinal(username, contraseña);
        }else if(encontrarUsuarioTransporte(username, contraseña) != null ){
            return usuario = encontrarUsuarioTransporte(username, contraseña);
        }else{
            return usuario;
        }
    }
    
    private Usuario encontrarAdmin(String username, String contraseña){
        conexion = Conexion.getConnection();
        Usuario usuario = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT codigo_admin, nombre FROM usuario_admin "
                    + "WHERE nombre_usuario = ? AND contrasenia = ?");
            ps.setString(1, username);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = new Usuario(rs.getInt("codigo_admin"), rs.getString("nombre"), "ADMIN");
            }
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return usuario;
    }
    
    private Usuario encontrarUsuarioRecepcion(String username, String contraseña){
        conexion = Conexion.getConnection();
        Usuario usuario = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT codigo_usuario_recepcion, nombre, biblioteca FROM usuario_recepcion "
                    + "WHERE usuario = ? AND constrasenia = ?");
            ps.setString(1, username);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = new Usuario(rs.getInt("codigo_usuario_recepcion"), rs.getString("nombre"), rs.getInt("biblioteca"), "RECEPCION");

            }
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return usuario;
    }
    
    private Usuario encontrarUsuarioFinal(String username, String contraseña){
        conexion = Conexion.getConnection();
        Usuario usuario = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT codigo_usuario_final, nombre FROM usuario_final "
                    + "WHERE nombre_usuario = ? AND contrasenia = ?");
            ps.setString(1, username);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = new Usuario(rs.getInt("codigo_usuario_final"), rs.getString("nombre"), "FINAL");

            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return usuario;
    }
    
    private Usuario encontrarUsuarioTransporte(String username, String contraseña){
        conexion = Conexion.getConnection();
        Usuario usuario = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = conexion.prepareStatement("SELECT codigo_transporte, nombre FROM transporte_usuario "
                    + "WHERE nombre_usuario = ? AND contrasenia = ?");
            ps.setString(1, username);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = new Usuario(rs.getInt("codigo_transporte"), rs.getString("nombre"), "TRANSPORTE");

            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            
        }
        return usuario;
    }
    
}
