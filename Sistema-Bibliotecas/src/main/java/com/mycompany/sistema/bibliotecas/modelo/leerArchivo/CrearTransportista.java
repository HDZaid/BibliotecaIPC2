
package com.mycompany.sistema.bibliotecas.modelo.leerArchivo;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.UsuarioTransporte;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearTransportista {
    
    public static void registrarTransportista(UsuarioTransporte usuario){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO transporte_usuario(codigo_transporte,nombre,nombre_usuario,contrasenia, correo) VALUES (?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, usuario.getCodigoUsuarioTransporte());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getNombreUsuario());
            ps.setString(4, usuario.getContrasenia());
            ps.setString(5, usuario.getCorreo());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
