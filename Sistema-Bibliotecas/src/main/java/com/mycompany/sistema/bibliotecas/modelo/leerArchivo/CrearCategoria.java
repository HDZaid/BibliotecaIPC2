
package com.mycompany.sistema.bibliotecas.modelo.leerArchivo;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearCategoria {
    
    public static void registrarCategoria(Categoria categoria){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO categoria (codigo_categoria, nombre, descripcion) values (?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, categoria.getCodigoCategoria());
            ps.setString(2, categoria.getNombre());
            ps.setString(3, categoria.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
}
