
package com.mycompany.sistema.bibliotecas.modelo.leerArchivo;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearLibro {
    
    public static void registrarLibro(Libro libro){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO libro (isbn, nombre, autor, categoria, costo) values (?,?,?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, libro.getIsbn());
            ps.setString(2, libro.getNombre());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getCategoria());
            ps.setDouble(5, libro.getCosto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
