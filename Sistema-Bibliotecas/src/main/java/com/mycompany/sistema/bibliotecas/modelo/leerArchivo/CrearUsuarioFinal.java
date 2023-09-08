
package com.mycompany.sistema.bibliotecas.modelo.leerArchivo;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Revocacion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.SolicitudPrestamo;
import com.mycompany.sistema.bibliotecas.modelo.entidades.UsuarioFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearUsuarioFinal {
    
    public static void registrarUsuarioFinal(UsuarioFinal usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO usuario_final(codigo_usuario_final,nombre,nombre_usuario,contrasenia, correo, saldo) VALUES (?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoUsuarioFinal());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getNombreUsuario());
            ps.setString(4, usuario.getContrasenia());
            ps.setString(5, usuario.getCorreo());
            ps.setDouble(6, usuario.getSaldo());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void registrarSolicitudPrestamo(SolicitudPrestamo usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO solicitud_prestamo(codigo_solicitud_prestamo,usuario,recepcionista,biblioteca"
                + ", transportista, isbn, estado, tipo_entrega, fecha) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoSolicitudPrestamo());
            ps.setInt(2, usuario.getUsuario());
            ps.setInt(3, usuario.getRecepcionista());
            ps.setInt(4, usuario.getBiblioteca());
            ps.setInt(5, usuario.getTransportista());
            ps.setInt(6, usuario.getIsbn());
            ps.setString(7, usuario.getEstado());
            ps.setString(8, usuario.getTipo_entrega());
            ps.setString(9, usuario.getFecha());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void registrarRevocacion(Revocacion usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO revocacion(codigo_revocacion,usuario,detalle"
                + ",estado) VALUES (?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoRevocacion());
            ps.setInt(2, usuario.getUsuario());
            ps.setString(3, usuario.getDetalle());
            ps.setString(4, usuario.getEstado());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
