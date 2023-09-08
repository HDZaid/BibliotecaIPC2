
package com.mycompany.sistema.bibliotecas.modelo.leerArchivo;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.UsuarioAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearAdmin {
    
    public static void registrarAdmin(UsuarioAdmin admin){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO usuario_admin(codigo_admin,nombre,nombre_usuario,contrasenia, correo) VALUES (?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, admin.getCodigoUsuarioAdmin());
            ps.setString(2, admin.getNombre());
            ps.setString(3, admin.getNombreUsuario());
            ps.setString(4, admin.getContrasenia());
            ps.setString(5, admin.getCorreo());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
