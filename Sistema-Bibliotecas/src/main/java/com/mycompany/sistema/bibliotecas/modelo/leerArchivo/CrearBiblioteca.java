
package com.mycompany.sistema.bibliotecas.modelo.leerArchivo;

import com.mycompany.sistema.bibliotecas.modelo.Conexion;
import com.mycompany.sistema.bibliotecas.modelo.entidades.Biblioteca;
import com.mycompany.sistema.bibliotecas.modelo.entidades.LibrosBiblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrearBiblioteca {
    
    public static boolean registrarBiblioteca(Biblioteca bb){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO biblioteca (idbiblioteca, nombre, direccion) values (?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, bb.getIdBiblioteca());
            ps.setString(2, bb.getNombre());
            ps.setString(3, bb.getDireccion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public static void registrarLibroBiblioteca(LibrosBiblioteca bb){
        
        PreparedStatement ps = null;
        String query = "INSERT INTO libros_biblioteca (biblioteca, existencias, isbn) values (?,?,?)";
        
        try {
            Connection conexion = Conexion.getConnection();
            ps = conexion.prepareStatement(query);
            ps.setInt(1, bb.getBiblioteca());
            ps.setInt(2, bb.getExistencias());
            ps.setInt(3, bb.getIsbn());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
